
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3
 */
public class PrincipalExamen {

    public static void main(String[] args) {

        ArrayList<PreguntasTerminadas> listaPregunta = new ArrayList<>();
        PreguntaRespuesta preg_resp = null;
        String respuestaCorrecta = "";
        while (true) {
            int command = JOptionPane.showOptionDialog(null, "CIS 2017", "UNL", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Rendir Examen",
                        "Administrar Examen",
                        "Calificar Examen",
                        "Salir"}, null);
            switch (command) {
                case 0:
                    boolean cerrar = true;
                    String cedula = "";
                    while (cerrar) {
                        cedula = JOptionPane.showInputDialog(null, "Ingrese cedula para rendir el examen", "UNL", JOptionPane.QUESTION_MESSAGE);
                        if (cedula.length() < 10) {
                            JOptionPane.showMessageDialog(null, "Cedula Incorrecta", "UNL", JOptionPane.ERROR_MESSAGE);
                        } else {
                            cerrar = false;
                        }
                    }
                    boolean val = Utilidades.validarUsuario(listaPregunta, cedula);
                    if (!val) {
                        int limPreguntas = 0;
                        int calificacion = 0;
                        boolean contestada = false;
                        PreguntasTerminadas guardarPregunta;
                        while (limPreguntas < 10) {
                            int tipo_pregunta = (int) (Math.random() * 4 + 1);
                            switch (tipo_pregunta) {
                                case 1://Suma
                                    PreguntaSuma suma = new PreguntaSuma();
                                    String opcionesArreglo1[] = obtenerOpciones(suma.respuesta());
                                    int pregunS = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + suma.pregunta(), "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo1, opcionesArreglo1[0]);
                                    if (opcionesArreglo1[pregunS].equals(String.valueOf(suma.respuesta()))) {
                                        JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                        contestada = true;
                                        calificacion++;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Respuesta Incorrecta\nCorrecion: " + suma.pregunta() + " =" + suma.respuesta(), "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    preg_resp = suma;
                                    respuestaCorrecta = opcionesArreglo1[pregunS];
                                    break;
                                case 2://RestaPregunta
                                    PreguntaResta resta = new PreguntaResta();
                                    String opcionesArreglo2[] = obtenerOpciones(resta.respuesta());
                                    int pregunR = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + resta.pregunta(), "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo2, opcionesArreglo2[0]);
                                    if (opcionesArreglo2[pregunR].equals(String.valueOf(resta.respuesta()))) {
                                        JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                        contestada = true;
                                        calificacion++;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + resta.pregunta() + " =" + resta.respuesta(), "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    preg_resp = resta;
                                    respuestaCorrecta = opcionesArreglo2[pregunR];
                                    break;
                                case 3://Multiplicacion
                                    PreguntaMultiplicacion multiplicacion = new PreguntaMultiplicacion();
                                    String opcionesArreglo3[] = obtenerOpciones(multiplicacion.respuesta());
                                    int pregunM = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + multiplicacion.pregunta(), "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo3, opcionesArreglo3[0]);
                                    if (opcionesArreglo3[pregunM].equals(String.valueOf(multiplicacion.respuesta()))) {
                                        JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                        contestada = true;
                                        calificacion++;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + multiplicacion.pregunta() + " =" + multiplicacion.respuesta(), "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    preg_resp = multiplicacion;
                                    respuestaCorrecta = opcionesArreglo3[pregunM];
                                    break;
                                case 4://Divicion
                                    PreguntaDivicion divicion = new PreguntaDivicion();
                                    String opcionesArreglo4[] = obtenerOpciones(divicion.respuesta());
                                    int pregunD = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + divicion.pregunta(), "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo4, opcionesArreglo4[0]);
                                    if (opcionesArreglo4[pregunD].equals(String.valueOf(divicion.respuesta()))) {
                                        JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                        contestada = true;
                                        calificacion++;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + divicion.pregunta() + " =" + divicion.respuesta(), "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    preg_resp = divicion;
                                    respuestaCorrecta = opcionesArreglo4[pregunD];
                                    break;
                            }
                            guardarPregunta = new PreguntasTerminadas(cedula, preg_resp, contestada, respuestaCorrecta);
                            listaPregunta.add(guardarPregunta);
                            limPreguntas++;
                            contestada = false;
                        }
                        JOptionPane.showMessageDialog(null, "Examen terminado con exito\n Cedula " + cedula + "\nResume:\n Correctas =" + calificacion + "\nIncorrectas " + (10-calificacion) + "\nCalificacion " + calificacion, "UNL", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ya rindio Examen, un examen por Usuario", "UNL", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    Utilidades.presentarPreguntas(listaPregunta);
                    break;
                case 2:
                    Utilidades.calificarPreguntas(listaPregunta);
                    break;
                case 3:
                    Utilidades.guardarPreguntas(listaPregunta);
                    System.exit(0);
                    break;
            }

        }
    }

    public static String[] obtenerOpciones(int respuesta) {
        String arregloOpciones[] = new String[4];
        int posResp = (int) (Math.random() * 4);
        for (int i = 0; i < arregloOpciones.length; i++) {
            if (i == posResp) {
                arregloOpciones[i] = String.valueOf(respuesta);
            } else {
                int opciones = (int) (Math.random() * 50 + 1);
                arregloOpciones[i] = String.valueOf(opciones);
            }
        }
        return arregloOpciones;
    }
}
