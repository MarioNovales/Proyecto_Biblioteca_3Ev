package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;

public class VentanaBuscarPorTitulo extends JFrame {

    JTextField tfBuscar = new JTextField();
    JButton btnBuscar = new JButton("Buscar libro");

    JLabel lbBUscar = new JLabel("Introduce el tiutlo o parte de este:");
    JLabel lbTituloVen = new JLabel("Rellene el formulario para buscar un libro");

    JTable tbResultado = new JTable();

    public VentanaBuscarPorTitulo(){
        super("Buscar libros");
        setSize(600,400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lbTituloVen.setBounds(60,20,350,30);
        lbBUscar.setBounds(60,50,150,30);

        tfBuscar.setBounds(60,80,100,30);

        btnBuscar.setBounds(200,80,150,30);


        add(lbTituloVen);
        add(lbBUscar);
        add(tfBuscar);
        add(tbResultado);
        add(btnBuscar);

        setVisible(true);

        btnBuscar.addActionListener(e ->{
            Libro lb = DaoImpLibroBD.getLibro(tfBuscar.getText());

        });

    }
}
