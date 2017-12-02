
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goquezadag
 */
public class PreguntasTerminadas {
    private String cedula;
    private String pregunta;
    private int respuesta;
    private boolean contestada;

    @Override
    public String toString() {
        return   "Resolucion de la pregunta    " + pregunta + " = " + respuesta + "   Respuesta  " + contestada ;
    }

    public PreguntasTerminadas(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PreguntasTerminadas other = (PreguntasTerminadas) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    
    public PreguntasTerminadas() {
    }

    public PreguntasTerminadas(String cedula, String pregunta, int respuesta, boolean contestada) {
        this.cedula = cedula;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.contestada = contestada;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isContestada() {
        return contestada;
    }

    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    }
    
}
