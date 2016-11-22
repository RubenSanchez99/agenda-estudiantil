package agendaestudiantil;

public class Evaluacion {
    private String materia;
    private String evaluacion;
    private double porcentaje;
    private double calificacion;
    private double calificacionTotal;

    public Evaluacion(String materia, String evaluacion, int porcentaje, int calificacion) {
        this.materia = materia;
        this.evaluacion = evaluacion;
        
        if (porcentaje > 100)
            this.porcentaje = 100;
        else if (porcentaje < 0)
            this.porcentaje = 0;
        else
            this.porcentaje = porcentaje;
        
        if (calificacion > 100)
            this.calificacion = 100;
        else if (calificacion < 0)
            this.calificacion = 0;
        else
            this.calificacion = calificacion;
        
        this.calificacionTotal = setCalificacionTotal();
    }

    public Evaluacion() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }    

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public double getCalificacionTotal() {
        return calificacionTotal;
    }

    public void setCalificacionTotal(double calificacionTotal) {
        this.calificacionTotal = calificacionTotal;
    }
    
    public double setCalificacionTotal() {
        this.calificacionTotal = this.porcentaje / 100 * this.calificacion;
        return this.calificacionTotal;
    }
}
