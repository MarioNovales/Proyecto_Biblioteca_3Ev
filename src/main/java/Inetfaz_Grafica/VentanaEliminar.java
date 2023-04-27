package Inetfaz_Grafica;

import javax.swing.*;

public class VentanaEliminar extends JFrame {
    JButton btnAñadir = new JButton("Añadir libro");
    JButton btnEliminar = new JButton("Borrar un libro");
    JButton btnBuscar = new JButton("Buscar libro");
    JButton btnActualizar = new JButton("Actualizar libro");

    JLabel lbTitulo = new JLabel("Eliminar un libro");
    public VentanaEliminar(){
        super("Eliminar un libro");
        setSize(400,400);
        setLayout(null);

        lbTitulo.setBounds(160,50,150,30);

        btnAñadir.setBounds(130,100,150,30);
        btnEliminar.setBounds(130,140,150,30);
        btnBuscar.setBounds(130,180,150,30);
        btnActualizar.setBounds(130,220,150,30);

        add(lbTitulo);
        add(btnAñadir);
        add(btnEliminar);
        add(btnBuscar);
        add(btnActualizar);

        setVisible(true);

    }

}
