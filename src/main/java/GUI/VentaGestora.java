package GUI;

import XML.Escritura;
import XML.Lectura;

import javax.swing.*;

public class VentaGestora extends JFrame {

    JButton btnAñadir = new JButton("Añadir libro");
    JButton btnEliminar = new JButton("Borrar un libro");
    JButton btnBuscarIsbn = new JButton("Buscar libro por ISBN");
    JButton btnBuscarTitulo = new JButton("Buscar libro por titulo");
    JButton btnActualizar = new JButton("Actualizar libro");
    JButton btnPrestarLibro = new JButton("Prestar Libro");
    JButton btnDevolver = new JButton("Devolver Libro");
    JButton btnXML = new JButton("Escribir XML");
    JButton btnSubirXml = new JButton("subir XML");

    JLabel lbMenu = new JLabel("Menu:");
    public VentaGestora(){

        super("Gesion de la biblioteca");
        setSize(400,500);
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
        btnPrestarLibro.setBounds(110,300,180,30);
        btnDevolver.setBounds(110,340,180,30);
        btnXML.setBounds(110,380,180,30);
        btnSubirXml.setBounds(110,420,180,30);

        add(lbMenu);
        add(btnAñadir);
        add(btnEliminar);
        add(btnBuscarIsbn);
        add(btnBuscarTitulo);
        add(btnActualizar);
        add(btnPrestarLibro);
        add(btnDevolver);
        add(btnXML);
        add(btnSubirXml);

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

        btnPrestarLibro.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaPrestarLibro();
            });
        });

        btnDevolver.addActionListener(e ->{
            javax.swing.SwingUtilities.invokeLater(() ->{
                new VentanaDevolverLibro();
            });
        });

        btnXML.addActionListener(e ->{
            Escritura.escrituraXml();
        });

        btnSubirXml.addActionListener(e ->{
            Lectura.lecturaXml();
        });

    }
}
