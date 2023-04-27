package Inetfaz_Grafica;

import javax.swing.*;

public class VentanaAñadir extends JFrame {

    JTextField tfIsbn = new JTextField();
    JTextField tfTitulo = new JTextField();
    JTextField tfAutor = new JTextField();
    JTextField tfPaginas = new JTextField();

    JButton btnAñadir = new JButton("Añadir libro");

    JLabel lbTituloVen = new JLabel("Rellene el siguiente formulario para añadir un libro");
    JLabel lbIsbn = new JLabel("isbn:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbPaginas = new JLabel("Paginas:");

    public VentanaAñadir(){

        super("Añadir Libro");
        setSize(600,400);
        setLayout(null);
        setResizable(false);

        lbTituloVen.setBounds(60,40,350,30);

        lbIsbn.setBounds(60,190,50,30);
        tfIsbn.setBounds(100,190,100,30);
        lbTitulo.setBounds(265,190,50,30);
        tfTitulo.setBounds(320,190,100,30);
        lbAutor.setBounds(60,220,50,30);
        tfAutor.setBounds(100,220,100,30);
        lbPaginas.setBounds(265,220,50,30);
        tfPaginas.setBounds(320,220,100,30);

        btnAñadir.setBounds(220,300,150,30);


        add(lbTituloVen);

        add(tfIsbn);
        add(lbIsbn);
        add(tfAutor);
        add(lbAutor);
        add(tfTitulo);
        add(lbTitulo);
        add(tfPaginas);
        add(lbPaginas);
        add(btnAñadir);

        setVisible(true);

    }

}
