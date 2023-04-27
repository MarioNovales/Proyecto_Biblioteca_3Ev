package Inetfaz_Grafica;

import javax.swing.*;

public class VentanaActualizar extends JFrame {

    JTextField tfBuscar = new JTextField();
    JTextField tfIsbn = new JTextField();
    JTextField tfTitulo = new JTextField();
    JTextField tfAutor = new JTextField();
    JTextField tfPaginas = new JTextField();

    JButton btnActualizar = new JButton("Actualizar libro");
    JButton btnBuscar = new JButton("Buscar");

    JLabel lbBUscar = new JLabel("Introduce el isbn del libro:");
    JLabel lbEnunciado = new JLabel("Introduce los nuevos parametros para el libro");
    JLabel lbTituloVen = new JLabel("Rellene el siguiente formulario para actualizar el libro");
    JLabel lbIsbn = new JLabel("isbn:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbPaginas = new JLabel("Paginas:");
    public VentanaActualizar(){
        super("Actualizar un libro");
        setSize(600,400);
        setLayout(null);
        setResizable(false);

        lbTituloVen.setBounds(60,40,350,30);
        lbBUscar.setBounds(60,80,150,30);

        tfBuscar.setBounds(60,110,100,30);
        btnBuscar.setBounds(200,110,80,30);

        lbEnunciado.setBounds(60,150,300,30);
        lbIsbn.setBounds(60,190,50,30);
        tfIsbn.setBounds(100,190,100,30);
        lbTitulo.setBounds(300,190,50,30);
        tfTitulo.setBounds(360,190,100,30);
        lbAutor.setBounds(60,220,50,30);
        tfAutor.setBounds(100,220,100,30);
        lbPaginas.setBounds(300,220,50,30);
        tfPaginas.setBounds(360,220,100,30);

        btnActualizar.setBounds(205,300,150,30);


        add(lbTituloVen);
        add(lbBUscar);
        add(tfBuscar);
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
        add(btnActualizar);

        setVisible(true);

    }


}
