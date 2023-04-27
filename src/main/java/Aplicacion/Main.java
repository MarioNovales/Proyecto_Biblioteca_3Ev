package Aplicacion;

import DAO.ConectionManager;
import Inetfaz_Grafica.VentaGestora;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentaGestora();

        });

        Connection con = ConectionManager.getConexion("biblioteca");


        ConectionManager.closeConexion();
    }

}
