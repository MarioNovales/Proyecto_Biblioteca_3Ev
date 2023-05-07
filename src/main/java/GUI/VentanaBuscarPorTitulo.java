package GUI;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

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
        lbBUscar.setBounds(60,50,190,30);

        tfBuscar.setBounds(60,80,100,30);

        btnBuscar.setBounds(200,80,150,30);




        btnBuscar.addActionListener(e ->{
            Object columnas[] = {"ISBN","TITULO","AUTOR","PAGINAS"};
            DefaultTableModel modelo = new DefaultTableModel(columnas,0);
            tbResultado = new JTable(modelo);
            Object[] ob = new Object[4];

            for (int i = 0; i < DaoImpLibroBD.getLibroTitulo(tfBuscar.getText()).size(); i++){
                ob[0] = DaoImpLibroBD.getLibroTitulo(tfBuscar.getText()).get(i).getIsbn();
                ob[1] = DaoImpLibroBD.getLibroTitulo(tfBuscar.getText()).get(i).getTitulo();
                ob[2] = DaoImpLibroBD.getLibroTitulo(tfBuscar.getText()).get(i).getAutor();
                ob[3] = DaoImpLibroBD.getLibroTitulo(tfBuscar.getText()).get(i).getPaginas();
                modelo.addRow(ob);
            }

            tbResultado.setModel(modelo);
            JScrollPane scroll1;

            scroll1 = new JScrollPane(tbResultado);
            add(scroll1);
        });

        add(lbTituloVen);
        add(lbBUscar);
        add(tfBuscar);
        add(tbResultado);
        add(btnBuscar);

        setVisible(true);
    }
}
