package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;

public class VentanaEliminar extends JFrame {



    JTextField tfIsbn = new JTextField();
    JTextField tfTitulo = new JTextField();
    JTextField tfAutor = new JTextField();
    JTextField tfPaginas = new JTextField();
    JTextField tfBorrar = new JTextField();

    JButton btnEliminar = new JButton("Eliminar libro");
    JButton btnBuscar = new JButton("Buscar");

    JLabel lbBUscar = new JLabel("Introduce el isbn del libro:");
    JLabel lbEnunciado = new JLabel("Los parametros del libro que quieres elimnar son los siguientes");
    JLabel lbTituloVen = new JLabel("Introduzca el isbn para eliminar un libro");
    JLabel lbIsbn = new JLabel("isbn:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbPaginas = new JLabel("Paginas:");
    public VentanaEliminar(){
        super("Eliminar un libro");
        setSize(600,400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lbTituloVen.setBounds(60,40,350,30);
        lbBUscar.setBounds(60,80,150,30);

        tfBorrar.setBounds(60,110,150,30);
        btnBuscar.setBounds(250,110,80,30);

        lbEnunciado.setBounds(60,150,400,30);
        lbIsbn.setBounds(60,190,50,30);
        tfIsbn.setBounds(100,190,100,30);
        lbTitulo.setBounds(300,190,50,30);
        tfTitulo.setBounds(360,190,100,30);
        lbAutor.setBounds(60,220,50,30);
        tfAutor.setBounds(100,220,100,30);
        lbPaginas.setBounds(300,220,50,30);
        tfPaginas.setBounds(360,220,100,30);

        btnEliminar.setBounds(205,300,150,30);

        tfIsbn.setEditable(false);
        tfAutor.setEditable(false);
        tfTitulo.setEditable(false);
        tfPaginas.setEditable(false);

        add(lbTituloVen);
        add(lbBUscar);
        add(tfBorrar);
        add(btnBuscar);
        add(lbEnunciado);
        add(tfIsbn);
        add(lbIsbn);
        add(tfAutor);
        add(lbAutor);
        add(tfTitulo);
        add(lbTitulo);
        add(tfPaginas);
        add(lbPaginas);
        add(btnEliminar);

        setVisible(true);


        btnBuscar.addActionListener(e ->{
            Libro lb = DaoImpLibroBD.getLibroISBN(tfBorrar.getText());

            tfAutor.setText(lb.getAutor());
            tfIsbn.setText(lb.getIsbn());
            tfTitulo.setText(lb.getTitulo());
            tfPaginas.setText(String.valueOf(lb.getPaginas()));
        });


        btnEliminar.addActionListener(e ->{

            DaoImpLibroBD.eliminaLibro(tfBorrar.getText());
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamete el libro");
            tfBorrar.setText("");
            tfAutor.setText("");
            tfIsbn.setText("");
            tfTitulo.setText("");
            tfPaginas.setText("");
        });

    }

}
