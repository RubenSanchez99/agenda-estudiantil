package agendaestudiantil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Materia {
    private int id;
    private String codigo;
    private String nombre;
    private int semestre;
    private Date hora_inicio;
    private Date hora_fin;
    private boolean[] dias;
    private String aula;

    public Materia(int id, String codigo, String nombre, int semestre, String hora_inicio, String hora_fin, boolean[] dias, String aula) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre = semestre;
        try {
            this.hora_inicio = new SimpleDateFormat("HH:mm").parse(hora_inicio);
            this.hora_fin = new SimpleDateFormat("HH:mm").parse(hora_fin);
        } catch (ParseException ex) {
            System.out.println("Error en la hora");
        }
        this.dias = dias;
        this.aula = aula;
    }
    
    public Materia() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    public boolean[] getDias() {
        return dias;
    }
    
    public String getDiasFormat() {
        String diasFormat = "";
        for (boolean dia : dias) {
            if (dia) {
                diasFormat += "1";
            } else {
                diasFormat += "0";
            }
        }
        return diasFormat;
    }

    public void setDias(boolean[] dias) {
        this.dias = dias;
    }
    
    public void setDiasFormat(String dias) {
        this.dias = new boolean[7];
        String[] arrDias = dias.split("");
        for (int i = 0; i < 7; i++) {
            this.dias[i] = arrDias[i].equals("1");
        }
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", semestre=" + semestre + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + ", dias=" + dias + ", aula=" + aula + '}';
    }
    
    
}
