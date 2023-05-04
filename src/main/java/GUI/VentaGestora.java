package GUI;

import javax.swing.*;

public class VentaGestora extends JFrame {

    JButton btnAñadir = new JButton("Añadir libro");
    JButton btnEliminar = new JButton("Borrar un libro");
    JButton btnBuscarIsbn = new JButton("Buscar libro por ISBN");
    JButton btnBuscarTitulo = new JButton("Buscar libro por titulo");
    JButton btnActualizar = new JButton("Actualizar libro");

    JLabel lbMenu = new JLabel("Menu:");
    public VentaGestora(){

        super("Gesion de la biblioteca");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        lbMenu.setBounds(180,50,50,30);

        btnAñadir.setBounds(110,100,180,30);
        btnEliminar.setBounds(110,140,180,30);
        btnBuscarIsbn.setBounds(110,180,180,30);
        btnBuscarIsbn.setBounds(110,180,180,30);
        btnBuscarTitulo.setBounds(110,220,180,30);
        btnActualizar.setBounds(110,260,180,30);

        add(lbMenu);
        add(btnAñadir);
        add(btnEliminar);
        add(btnBuscarIsbn);
        add(btnBuscarTitulo);
        add(btnActualizar);

        setVisible(true);


        btnAñadir.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaAñadir();
            });
        });

        btnEliminar.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaEliminar();
            });
        });

        btnActualizar.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaActualizar();
            });
        });

        btnBuscarIsbn.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaBuscarPorIsbn();
            });
        });

        btnBuscarTitulo.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaBuscarPorTitulo();
            });
        });

    }
}
