package Aplicacion;

import Inetfaz_Grafica.VentaGestora;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentaGestora();

        });
    }

}
