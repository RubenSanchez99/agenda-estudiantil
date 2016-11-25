package agendaestudiantil;

import java.util.Date;

public class Tarea {
    private String materia;
    private String tarea;
    private Date fechaEntrega;
    private Date fechaRecordatorio;

    public Tarea(String materia, String tarea, Date fechaEntrega, Date fechaRecordatorio) {
        this.materia = materia;
        this.tarea = tarea;
        this.fechaEntrega = fechaEntrega;
        this.fechaRecordatorio = fechaRecordatorio;
    }
    
    public Tarea() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setFechaRecordatorio(Date fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }
    

    @Override
    public String toString() {
        return "Tarea{" + "materia=" + materia + ", tarea=" + tarea + ", fechaEntrega=" + fechaEntrega + ", fechaRecordatorio=" + fechaRecordatorio + '}';
    }
    
    
}
