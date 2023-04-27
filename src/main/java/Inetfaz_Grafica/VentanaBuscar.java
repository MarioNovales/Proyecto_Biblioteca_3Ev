package Inetfaz_Grafica;

import javax.swing.*;

public class VentanaBuscar extends JFrame {
    JButton btnAñadir = new JButton("Añadir libro");
    JButton btnEliminar = new JButton("Borrar un libro");
    JButton btnBuscar = new JButton("Buscar libro");
    JButton btnActualizar = new JButton("Actualizar libro");

    JLabel lbMenu = new JLabel("Menu:");
    public VentanaBuscar(){
        super("Buscar libros");
        setSize(400,400);
        setLayout(null);

        lbMenu.setBounds(180,50,50,30);

        btnAñadir.setBounds(130,100,150,30);
        btnEliminar.setBounds(130,140,150,30);
        btnBuscar.setBounds(130,180,150,30);
        btnActualizar.setBounds(130,220,150,30);

        add(lbMenu);
        add(btnAñadir);
        add(btnEliminar);
        add(btnBuscar);
        add(btnActualizar);

        setVisible(true);


    }

}
