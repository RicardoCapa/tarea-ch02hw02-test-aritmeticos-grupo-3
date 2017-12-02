
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
public class PreguntaAlmacenadas {

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
        String ced = JOptionPane.showInputDialog(null, "Ingrese Cedula para mostrar Examen", "UNL", JOptionPane.QUESTION_MESSAGE);
        boolean act = validarUsuario(listaPreguntas, ced);
        if (act) {
            String aux = "";
            for (PreguntasTerminadas elemento : listaPreguntas) {
                if (elemento.getCedula().equals(ced)) {
                    aux = aux + elemento.toString() + "\n";
                }

            }
            JOptionPane.showMessageDialog(null, "Resultado Examen:" + ced + "\n" + aux, "UNL", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe", "UNL", JOptionPane.ERROR_MESSAGE);
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
}
