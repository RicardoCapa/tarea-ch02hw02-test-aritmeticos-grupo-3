/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goquezadag
 */
public class PreguntaMultiplicacion extends PreguntaRespuesta{
    private int num1;
    private int num2;

    public PreguntaMultiplicacion() {
        num1 = (int) (Math.random() * 50);
        num2 = (int) (Math.random() * 50 + 1);
    }

    @Override
    public String pregunta() {
        return num1 +" * "+ num2;
    }

    @Override
    public int respuesta() {
        return num1*num2;
    }
}
