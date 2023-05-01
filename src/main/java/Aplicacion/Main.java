package Aplicacion;

import DAO.ConectionManager;
import GUI.VentaGestora;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentaGestora();

        });


    }

}
