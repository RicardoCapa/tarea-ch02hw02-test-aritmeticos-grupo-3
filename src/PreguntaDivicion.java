/**
 *
 * @author goquezadag
 */
public class PreguntaDivicion extends PreguntaRespuesta{
     private int num1;
    private int num2;

    public PreguntaDivicion() {
        num1 = (int) (Math.random() * 50);
        num2 = (int) (Math.random() * 50 + 1);
    }

    @Override
    public String pregunta() {
       return num1 +" / "+ num2;
    }

    @Override
    public int respuesta() {
        return num1/num2;
    }
}
