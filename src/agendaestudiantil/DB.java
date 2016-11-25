package agendaestudiantil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DB {
    static String dbURL = "jdbc:mysql://localhost:3306/agenda";
    static String username = "root";
    static String password = "admin";// Con toda la encriptación AES-1024
    private static Connection conn;
    
    public static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void desconectar() {
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void write(Materia materia) {        
        // Usamos un try-with-resources para abrir y cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "INSERT INTO agenda.materias (codigo, nombre, semestre, hora_inicio, hora_fin, maestro, dias, aula)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, materia.getCodigo());
            statement.setString(2, materia.getNombre());
            statement.setInt(3, materia.getSemestre());
            statement.setTime(4, new Time(materia.getHora_inicio().getTime()));
            statement.setTime(5, new Time(materia.getHora_fin().getTime()));
            statement.setString(6, materia.getMaestro());
            statement.setString(7, materia.getDiasFormat());
            statement.setString(8, materia.getAula());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se han guardado " + materia.getNombre() + " en la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void write(Evaluacion ev) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "INSERT INTO agenda.evaluaciones"
                + " (materia, evaluacion, porcentaje, calificacion, calificacion_total)" 
                + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, ev.getMateria());
            statement.setString(2, ev.getEvaluacion());
            statement.setDouble(3, ev.getPorcentaje());
            statement.setDouble(4, ev.getCalificacion());
            statement.setDouble(5, ev.getCalificacionTotal());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se ha guardado " + ev.getEvaluacion() + " en la base de datos");
            }
            
            setPromedio(ev.getMateria(), readPromedio(ev.getMateria()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void write(Tarea t) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "INSERT INTO agenda.tareas (materia, tarea, fecha_entrega, fecha_recordatorio, recordatorio_enviado)"
                + " VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, t.getMateria());
            statement.setString(2, t.getTarea());
            statement.setDate(3, new java.sql.Date(t.getFechaEntrega().getTime()));
            statement.setDate(4, new java.sql.Date(t.getFechaRecordatorio().getTime()));
            statement.setBoolean(5, false);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se ha guardado " + t.getTarea() + " de " + t.getMateria() + " en la base de datos");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void setPromedio(String materia, double promedio) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "UPDATE agenda.materias SET promedio=? WHERE codigo=?";
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setDouble(1, promedio);
            statement.setString(2, materia);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se han actualizado el promedio de " + materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void write(String... args) {
        // Usamos un try-with-resources para abrir y cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            char mode = args[0].toUpperCase().charAt(0);
            String query = args[1];
            PreparedStatement statement = conn.prepareStatement(query);
            
            switch(mode) {
                case 'H':
                    Date startDate = null, endDate = null;
                    try {
                        startDate = new SimpleDateFormat("HH:mm").parse(args[5]);
                        endDate = new SimpleDateFormat("HH:mm").parse(args[6]);
                    } catch (ParseException e) {
                        System.out.println("Ingrese la fecha en el formato correcto");
                    }
                    statement.setString(1, args[2]);
                    statement.setString(2, args[3]);
                    statement.setInt(3, Integer.parseInt(args[4]));
                    statement.setTime(4, new Time(startDate.getTime()));
                    statement.setTime(5, new Time(endDate.getTime()));
                    statement.setString(6, args[7]);
                    statement.setString(7, args[8]);
                    break;
                
            }
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se han escrito en la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void createTable(String codigo) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "CREATE TABLE " + codigo + " ("
                    + "id INT(11) NOT NULL AUTO_INCREMENT, " 
                    + "evaluacion VARCHAR(32) NOT NULL," 
                    + "porcentaje DOUBLE NOT NULL," 
                    + "calificacion DOUBLE NOT NULL, " 
                    + "calificacion_total DOUBLE NOT NULL,"
                    + "PRIMARY KEY (id)" + ");";
            
            PreparedStatement statement = conn.prepareStatement(query);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se han escrito en la base de datos");
            }
            System.out.println("Tabla " + codigo + " creada");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Materia read(String codigo) {
        Materia m = new Materia();
        
        // Usamos un try-with-resources para abrir y cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query;
            if (codigo.matches("^-?\\d+$")) {
                query = "SELECT * FROM agenda.materias where id='" + codigo + "'";
            } else if (codigo.matches("")) {
                query = "SELECT * FROM agenda.materias";
            } else {
                query = "SELECT * FROM agenda.materias where codigo='" + codigo + "'";
            }
                        
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            int count = 0;
            while(result.next()) {
                m.setId(result.getInt(1));
                m.setCodigo(result.getString(2));
                m.setNombre(result.getString(3));
                m.setSemestre(result.getInt(4));
                m.setHora_inicio(result.getTime(5));
                m.setHora_fin(result.getTime(6));
                m.setDiasFormat(result.getString(7));
                m.setAula(result.getString(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return m;
    }
    
    public static List<Tarea> getTodayTareas() {
        List<Tarea> tareas = new ArrayList<Tarea>();
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "SELECT materia, tarea, fecha_entrega, fecha_recordatorio, recordatorio_enviado "
                    + "FROM agenda.tareas "
                    + "WHERE day(fecha_recordatorio) = day(curdate()) AND recordatorio_enviado=false";
                        
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
                        
            while(result.next()) {
                Tarea t = new Tarea();
                t.setMateria(result.getString(1));
                t.setTarea(result.getString(2));
                t.setFechaEntrega(result.getDate(3));
                t.setFechaRecordatorio(result.getDate(4));
                
                tareas.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tareas;
    }
    
    public static String[] getAllMaterias() {
        Vector<String> materias = new Vector<String>();
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "SELECT codigo FROM agenda.materias";
                        
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            int count = 0;
            while(result.next()) {
                materias.addElement(result.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return materias.toArray(new String[materias.size()]);
    }
    
    public static double readPromedio(String materia) {
        double promedio = 0.0;
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "SELECT SUM(calificacion_total) FROM agenda.evaluaciones WHERE materia='" + materia + "'";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()) {
                promedio = result.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promedio;
    }
    
    public static void setCorreoEnviado(String tarea) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "UPDATE agenda.tareas SET recordatorio_enviado=1 WHERE tarea=?";
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, tarea);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se ha actualizado el estado de " + tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void delete(String codigo) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "DELETE FROM agenda.materias WHERE codigo=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, codigo);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Se eliminó " + codigo + " de la lista de materias");
            }
            query = "DELETE FROM agenda.evaluaciones WHERE codigo=?";
            statement = conn.prepareStatement(query);
            statement.setString(1, codigo);
            
            rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Se eliminó " + codigo + " de la tabla de tareas");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   public static void deleteEvaluacion(String evaluacion, String materia) {
       try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "DELETE FROM agenda.evaluaciones WHERE evaluacion=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, evaluacion);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Se eliminó " + evaluacion + " de la lista de evaluaciones");
            }
            
            setPromedio(materia, readPromedio(materia));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
   
   public static void deleteTarea(String tarea) {
       try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query = "DELETE FROM agenda.tareas WHERE tarea=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, tarea);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Se eliminó " + tarea + " de la lista de tareas");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
    
    public static DefaultTableModel buildTableModel(String query){
        // Creamos vectores para almacenar la información y las columnas de las tablas
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<String> columnNames = new Vector<String>();;
        
        // Usamos un try-with-resources para abrir y cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){     
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            // Guardamos los metadatos de la tabla, para sacar el nombre de las columnas
            ResultSetMetaData metaData = result.getMetaData();
            
            // Nombres de las columnas
            
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }
            
            // Datos de la tabla
                      
            while(result.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(result.getObject(columnIndex));
                }
                data.add(vector);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        /* Regresamos un DefaultTableModel, que contiene la información extraída de la base de datos
           en un formato para ponerlo en la tabla.
           Para ponerlo en una tabla, busque su propiedad model, elija la opción Custom Code
           y ponga esta función con una llamada SQL como argumento.
           Ejemplo:
               DB.buildTableModel("SELECT * FROM agenda.materias")
               // Crea un model con todos los datos de la tabla
               
               DB.buildTableModel("SELECT codigo, maestro, promedio FROM agenda.materias")
               // Crea un model con el codigo, el maestro y el promedio

        */
        return new DefaultTableModel(data, columnNames);
    }
    
}
