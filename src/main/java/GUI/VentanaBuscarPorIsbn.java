package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;

public class VentanaBuscarPorIsbn extends JFrame {


    JTextField tfBuscar = new JTextField();
    JTextField tfIsbn = new JTextField();
    JTextField tfTitulo = new JTextField();
    JTextField tfAutor = new JTextField();
    JTextField tfPaginas = new JTextField();

    JButton btnBuscar = new JButton("Buscar libro");

    JLabel lbBUscar = new JLabel("Introduce el isbn del libro:");
    JLabel lbEnunciado = new JLabel("Los parametros del libro buscado son los siguientes");
    JLabel lbTituloVen = new JLabel("Rellene el formulario para buscar un libro");
    JLabel lbIsbn = new JLabel("isbn:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbPaginas = new JLabel("Paginas:");
    public VentanaBuscarPorIsbn(){
        super("Buscar libros");
        setSize(600,400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lbTituloVen.setBounds(60,40,350,30);
        lbBUscar.setBounds(60,80,150,30);

        tfBuscar.setBounds(60,110,100,30);

        lbEnunciado.setBounds(60,150,400,30);
        lbIsbn.setBounds(60,190,50,30);
        tfIsbn.setBounds(100,190,100,30);
        lbTitulo.setBounds(300,190,50,30);
        tfTitulo.setBounds(360,190,100,30);
        lbAutor.setBounds(60,220,50,30);
        tfAutor.setBounds(100,220,100,30);
        lbPaginas.setBounds(300,220,50,30);
        tfPaginas.setBounds(360,220,100,30);

        btnBuscar.setBounds(205,300,150,30);

        tfIsbn.setEditable(false);
        tfAutor.setEditable(false);
        tfTitulo.setEditable(false);
        tfPaginas.setEditable(false);

        add(lbTituloVen);
        add(lbBUscar);
        add(tfBuscar);
        add(lbEnunciado);
        add(tfIsbn);
        add(lbIsbn);
        add(tfAutor);
        add(lbAutor);
        add(tfTitulo);
        add(lbTitulo);
        add(tfPaginas);
        add(lbPaginas);
        add(btnBuscar);

        setVisible(true);

        btnBuscar.addActionListener(e ->{
            Libro lb = DaoImpLibroBD.getLibroISBN(tfBuscar.getText());

            tfIsbn.setText(lb.getIsbn());
            tfAutor.setText(lb.getAutor());
            tfTitulo.setText(lb.getTitulo());
            tfPaginas.setText(String.valueOf(lb.getPaginas()));
        });

    }

}
