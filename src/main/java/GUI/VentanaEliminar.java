package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VentanaEliminar extends JFrame {

    JTextField tfBorrar = new JTextField();

    JButton btnEliminar = new JButton("Eliminar libro");
    JLabel lbTituloVen = new JLabel("Introduzca el isbn para eliminar un libro");


    public VentanaEliminar(){
        super("Eliminar un libro");
        setSize(600,400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lbTituloVen.setBounds(60,20,350,30);

        tfBorrar.setBounds(50,325,150,30);


        btnEliminar.setBounds(205,325,150,30);


        add(lbTituloVen);
        add(tfBorrar);
        add(btnEliminar);

        setVisible(true);



        JTable tbResultado;

        ArrayList<Libro> listaLibros = DaoImpLibroBD.muestraTodo();

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


        jsp.setBounds(25,60,550,250);



        btnEliminar.addActionListener(e ->{

            DaoImpLibroBD.eliminaLibro(tfBorrar.getText());
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamete el libro");
        });

    }

}
