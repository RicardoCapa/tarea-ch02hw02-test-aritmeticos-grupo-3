
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalExamen {

    public int posR = 0;

    public static void main(String[] args) {
        ArrayList<PreguntasTerminadas> listaPregunta = new ArrayList<>();
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

                    int limPreguntas = 0;
                    int respuesta = 0;
                    String pregunta = "";
                    int calificacion = 0;
                    int malas = 0;
                    boolean contestada = false;
                    while (limPreguntas < 10) {
                        int tipo_pregunta = (int) (Math.random() * 4 + 1);
                        switch (tipo_pregunta) {
                            case 1://Suma
                                PreguntaSuma suma = new PreguntaSuma();
                                respuesta = suma.respuesta();
                                pregunta = suma.pregunta();
                                String opcionesArreglo1[] = obtenerOpciones(respuesta);
                                int pregunS = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + pregunta, "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo1, opcionesArreglo1[0]);
                                if (opcionesArreglo1[pregunS].equals(String.valueOf(respuesta))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta + " =" + respuesta, "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    malas++;
                                }
                                break;
                            case 2://RestaPregunta
                                PreguntaResta resta = new PreguntaResta();
                                respuesta = resta.respuesta();
                                pregunta = resta.pregunta();
                                String opcionesArreglo2[] = obtenerOpciones(respuesta);
                                int pregunR = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + pregunta, "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo2, opcionesArreglo2[0]);
                                if (opcionesArreglo2[pregunR].equals(String.valueOf(respuesta))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta + " =" + respuesta, "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    malas++;
                                }
                                break;
                            case 3://Multiplicacion
                                PreguntaMultiplicacion multiplicacion = new PreguntaMultiplicacion();
                                respuesta = multiplicacion.respuesta();
                                pregunta = multiplicacion.pregunta();
                                String opcionesArreglo3[] = obtenerOpciones(respuesta);
                                int pregunM = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + pregunta, "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo3, opcionesArreglo3[0]);
                                if (opcionesArreglo3[pregunM].equals(String.valueOf(respuesta))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta + " =" + respuesta, "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    malas++;
                                }
                                break;
                            case 4://Divicion
                                PreguntaDivicion divicion = new PreguntaDivicion();
                                respuesta = divicion.respuesta();
                                pregunta = divicion.pregunta();
                                String opcionesArreglo4[] = obtenerOpciones(respuesta);
                                int pregunD = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + pregunta, "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo4, opcionesArreglo4[0]);
                                if (opcionesArreglo4[pregunD].equals(String.valueOf(respuesta))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta", "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta + " =" + respuesta, "UNL", JOptionPane.INFORMATION_MESSAGE);
                                    malas++;
                                }
                                break;
                        }

                        PreguntasTerminadas guardarPregunta = new PreguntasTerminadas(cedula, pregunta, respuesta, contestada);
                        listaPregunta.add(guardarPregunta);
                        limPreguntas++;
                    }
                    JOptionPane.showMessageDialog(null, "Examen terminado con exito\n Cedula " + cedula + "\nResume:\n Correctas =" + calificacion + "\nIncorrectas " + malas + "\nCalificacion " + calificacion, "UNL", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    PreguntaAlmacenadas.presentarPreguntas(listaPregunta);
                    break;
                case 2:
                    PreguntaAlmacenadas.calificarPreguntas(listaPregunta);
                    break;
                case 3:
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
