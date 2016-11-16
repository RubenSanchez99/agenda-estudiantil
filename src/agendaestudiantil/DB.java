package agendaestudiantil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DB {
    public static void write(Materia materia, String query) {
        String dbURL = "jdbc:mysql://localhost:3306/agenda";
        String username = "root";
        String password = "admin";// Con toda la encriptación AES-1024
        
        // Usamos un try-with-resources para abrir y cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, materia.getCodigo());
            statement.setString(2, materia.getNombre());
            statement.setInt(3, materia.getSemestre());
            statement.setTime(4, new Time(materia.getHora_inicio().getTime()));
            statement.setTime(5, new Time(materia.getHora_fin().getTime()));
            statement.setString(6, materia.getDiasFormat());
            statement.setString(7, materia.getAula());
                
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se han escrito en la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static void write(String... args) {
        String dbURL = "jdbc:mysql://localhost:3306/agenda";
        String username = "root";
        String password = "admin";// Con toda la encriptación AES-1024
        
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
    
    public static Materia read(String codigo) {
        String dbURL = "jdbc:mysql://localhost:3306/agenda";
        String username = "root";
        String password = "admin";// Con toda la encriptación AES-1024
        Materia m = new Materia();
        
        // Usamos un try-with-resources para abrir y cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String query;
            if (codigo.matches("^-?\\d+$")) {
                query = "SELECT * FROM agenda.materias where id='" + codigo + "'";
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
}
