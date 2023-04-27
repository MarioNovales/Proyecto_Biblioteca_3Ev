package Inetfaz_Grafica;

import javax.swing.*;

public class VentanaBuscar extends JFrame {


    JButton btnBuscar = new JButton("Añadir libro");

    JLabel lbTitulo = new JLabel("Buscar libro");
    public VentanaBuscar(){
        super("Buscar libros");
        setSize(400,400);
        setLayout(null);
        setResizable(false);

        lbTitulo.setBounds(160,50,150,30);

        btnBuscar.setBounds(130,180,150,30);

        add(lbTitulo);
        add(btnBuscar);

        setVisible(true);


    }

}
