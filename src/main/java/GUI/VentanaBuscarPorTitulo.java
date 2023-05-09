package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaBuscarPorTitulo extends JFrame {

    JTextField tfBuscar = new JTextField();
    JButton btnBuscar = new JButton("Buscar libro");

    JLabel lbBUscar = new JLabel("Introduce el tiutlo o parte de este:");
    JLabel lbTituloVen = new JLabel("Rellene el formulario para buscar un libro");

    public VentanaBuscarPorTitulo(){
        super("Buscar libros");
        setSize(600,400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lbTituloVen.setBounds(60,20,350,30);
        lbBUscar.setBounds(60,50,190,30);

        tfBuscar.setBounds(60,80,100,30);

        btnBuscar.setBounds(200,80,150,30);


        btnBuscar.addActionListener(e ->{
            JTable tbResultado;

            ArrayList<Libro> listaLibros = DaoImpLibroBD.getLibroTitulo(tfBuscar.getText());

            String[] datos = new String[4];
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("ISBN");
            modelo.addColumn("Titulo");
            modelo.addColumn("Autor");
            modelo.addColumn("Paginas");

            for (Libro lb: listaLibros){
                datos[0] = lb.getIsbn();
                datos[1] = lb.getTitulo();
                datos[2] = lb.getAutor();
                datos[3] = String.valueOf(lb.getPaginas());
                modelo.addRow(datos);
            }

            tbResultado = new JTable(modelo);
            JScrollPane jsp = new JScrollPane(tbResultado);
            tbResultado.setEnabled(false);
            add(jsp);


            jsp.setBounds(60,120,480,230);
            repaint();
            btnBuscar.setEnabled(false);
        });


        add(lbTituloVen);
        add(lbBUscar);
        add(tfBuscar);
        add(btnBuscar);

        setVisible(true);
    }
}
