
import java.util.Objects;
/**
 *
 * @author JorgePucha
 */
public class PreguntasTerminadas {
    private String cedula;
    PreguntaRespuesta preg_resp;
    private boolean contestada;
    private String respuesta;
    @Override
    public String toString() {
        return   "cedula:"+cedula +", Pregunta: "+preg_resp.pregunta()+ ", Respuesta: " + preg_resp.respuesta()+", Respuesta correcta: "+  respuesta;
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
    public PreguntasTerminadas(String cedula, PreguntaRespuesta preg_resp, boolean contestada,String respuesta) {
        this.cedula = cedula;
        setPreg_resp(preg_resp);
        this.contestada = contestada;
        this.respuesta=respuesta;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public PreguntaRespuesta getPreg_resp() {
        return preg_resp;
    }
    public void setPreg_resp(PreguntaRespuesta preg_resp) {
        this.preg_resp = preg_resp;
    }
    public boolean isContestada() {
        return contestada;
    }
    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    } 

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
