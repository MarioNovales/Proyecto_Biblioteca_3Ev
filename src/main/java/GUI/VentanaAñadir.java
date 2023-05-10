package GUI;

import DAO.DaoImpLibroBD;

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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lbTituloVen.setBounds(60,40,350,30);

        lbIsbn.setBounds(60,100,50,30);
        tfIsbn.setBounds(100,100,100,30);
        lbTitulo.setBounds(300,100,50,30);
        tfTitulo.setBounds(360,100,100,30);
        lbAutor.setBounds(60,160,50,30);
        tfAutor.setBounds(100,160,100,30);
        lbPaginas.setBounds(300,160,50,30);
        tfPaginas.setBounds(360,160,100,30);

        btnAñadir.setBounds(205,250,150,30);


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

        btnAñadir.addActionListener(e ->{

             new DaoImpLibroBD().creaLibro(tfIsbn.getText(),tfTitulo.getText(),tfAutor.getText(), Integer.parseInt(tfPaginas.getText()));
            JOptionPane.showMessageDialog(null,"Se ha guardado correctamente");

        });
    }

}
