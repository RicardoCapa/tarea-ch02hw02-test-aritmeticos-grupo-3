
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author goquezadag
 */
public class Utilidades {

    public static boolean validarUsuario(ArrayList<PreguntasTerminadas> listaPreguntas, String ced) {
        boolean res = false;
        for (PreguntasTerminadas elemento : listaPreguntas) {
            if (elemento.getCedula().equals(ced)) {
                res = true;
            }
        }
        return res;
    }
    public static void presentarPreguntas(ArrayList<PreguntasTerminadas> listaPreguntas) {
        String aux = "";
        String ced = JOptionPane.showInputDialog(null, "Ingrese Cedula para mostrar Examen", "UNL", JOptionPane.QUESTION_MESSAGE);
        boolean act = validarUsuario(listaPreguntas, ced);
        if (act) {
            aux = "";
            for (PreguntasTerminadas elemento : listaPreguntas) {
                if (elemento.getCedula().equals(ced)) {
                    aux = aux + elemento.toString() + ",Puntuancion Total: " + calificarPreguntas2(listaPreguntas, ced) + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, "Resultado Examen:" + ced + "\n" + aux, "UNL", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe", "UNL", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void guardarPreguntas(ArrayList<PreguntasTerminadas> listaPreguntas) {
        try {
            File file = new File("Archivo.txt");
            FileWriter escribir = new FileWriter(file, true);
            String aux = "";
            PreguntasTerminadas elemento;
            for (int i = 0; i < listaPreguntas.size(); i++) {
                elemento = listaPreguntas.get(i);
                aux = elemento.getCedula();
                escribir.write(elemento.toString() + ",Puntuancion Total: " + calificarPreguntas2(listaPreguntas, aux) + "\r\n");
            }
            escribir.close();
        } catch (Exception e) {
            System.out.println("no se encontro el archivo" + e);
        }
    }
    public static void calificarPreguntas(ArrayList<PreguntasTerminadas> listaPreguntas) {
        int calificacion = 0;
        String ced = JOptionPane.showInputDialog(null, "Ingrese Cedula para calificar Examen", "UNL", JOptionPane.QUESTION_MESSAGE);
        boolean act = validarUsuario(listaPreguntas, ced);
        if (act) {
            for (PreguntasTerminadas elemento : listaPreguntas) {
                if (elemento.getCedula().equals(ced) && elemento.isContestada() == true) {
                    calificacion++;
                }
            }
            JOptionPane.showMessageDialog(null, "Señor: " + ced + "\nCalificacion\n" + calificacion, "UNL", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe", "UNL", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String calificarPreguntas2(ArrayList<PreguntasTerminadas> listaPreguntas, String ced) {
        int calificacion = 0;
        for (PreguntasTerminadas elemento : listaPreguntas) {
            if (elemento.getCedula().equals(ced) && elemento.isContestada() == true) {
                calificacion++;
            }
        }
        return String.valueOf(calificacion);
    }
}
