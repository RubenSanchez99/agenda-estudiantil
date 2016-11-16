// Proyecto Final de Programación Orientada a Objetos

package agendaestudiantil;

public class AgendaEstudiantil {

    public static void main(String[] args) {
        /*DB.write("H", "INSERT INTO agenda.materias (codigo, nombre, semestre, hora_inicio, hora_fin, dias, aula)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)",
                "POO", "Programación Orientada a Objetos", "1", "07:00", "09:00", "0101000", "103");
        */
        //DB.write(materia);
        
        final String insertMateriaQuery = "INSERT INTO agenda.materias (codigo, nombre, semestre, hora_inicio, hora_fin, dias, aula)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        boolean[] dias = {true, false, true, false, true, false, false};        
        Materia admon = new Materia(1, "ADMON", "Administración", 1, "09:00", "09:00", 
                dias, "103");
        DB.write(admon, insertMateriaQuery);
        
        
        Materia m = DB.read("ADMON");
        System.out.println(m);
    }
    
}
