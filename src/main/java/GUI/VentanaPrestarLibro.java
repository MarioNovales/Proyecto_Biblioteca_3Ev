package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VentanaPrestarLibro extends JFrame {

    JButton btnBuscar = new JButton("Buscar");
    JButton btnPrestar = new JButton("Prestar libro");

    JTextField tfBuscar = new JTextField();
    JTextField tfPrestar = new JTextField();

    JLabel lbPrestar = new JLabel("Introduce el isbn del libro que quieres prestar");
    JLabel lbEnunciado = new JLabel("Introduce el titulo o parte para ver los libros");
    public VentanaPrestarLibro(){

        super("Prestar libros");
        setSize(600,400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        lbEnunciado.setBounds(60,20,400,30);
        tfBuscar.setBounds(60,60,80,30);
        btnBuscar.setBounds(150,60,80,30);
        lbPrestar.setBounds(60,300,400,30);
        tfPrestar.setBounds(60,330,80,30);
        btnPrestar.setBounds(170,330,200,30);

        btnBuscar.addActionListener(e ->{
            JTable tbResultado;

            ArrayList<Libro> listaLibros = DaoImpLibroBD.getLibroTitulo(tfBuscar.getText());

            String[] datos = new String[5];
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("ISBN");
            modelo.addColumn("Titulo");
            modelo.addColumn("Autor");
            modelo.addColumn("Paginas");
            modelo.addColumn("Prestado");

            for (Libro lb: listaLibros){
                datos[0] = lb.getIsbn();
                datos[1] = lb.getTitulo();
                datos[2] = lb.getAutor();
                datos[3] = String.valueOf(lb.getPaginas());
                datos[4] = String.valueOf(lb.isPrestado());
                modelo.addRow(datos);
            }

            tbResultado = new JTable(modelo);
            JScrollPane jsp = new JScrollPane(tbResultado);
            tbResultado.setEnabled(false);
            add(jsp);
            jsp.setBounds(60,100,480,200);
            repaint();
            btnBuscar.setEnabled(false);
        });

        add(lbEnunciado);
        add(tfBuscar);
        add(btnBuscar);
        add(lbPrestar);
        add(tfPrestar);
        add(btnPrestar);


        setVisible(true);

        btnPrestar.addActionListener(e ->{

            DaoImpLibroBD.PrestaLibros(tfPrestar.getText());

            JOptionPane.showMessageDialog(null,"El libro ha sido prestado correctamente");
            btnPrestar.setEnabled(false);

        });
    }



}
