package Aplicacion;

import GUI.VentaGestora;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentaGestora();

        });
/*
        Connection con = ConectionManager.getConexion("biblioteca");


        ConectionManager.closeConexion();

 */
    }

}
