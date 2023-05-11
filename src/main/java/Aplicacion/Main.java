package Aplicacion;

import DAO.ConectionManager;
import DAO.DaoImpLibroBD;
import GUI.VentaGestora;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentaGestora();

        });

    }

}
