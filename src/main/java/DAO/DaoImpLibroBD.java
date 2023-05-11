/*
    Clase en la que se implementan los metodos de la interfaz IDaoLibro
 */

package DAO;

import Aplicacion.Libro;

import java.sql.*;
import java.util.ArrayList;

public class DaoImpLibroBD implements IDaoLibro {

    @Override
    public void creaLibro(String isbn, String titulo, String autor, int paginas) {
        boolean prestado = false;

        String consulta = "INSERT INTO libro VALUES ('" + isbn +"','" + titulo + "','" + autor + "'," + paginas + "," + prestado + ")";

        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement(consulta);

            pstmnt.executeUpdate(consulta);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void actualizaLibro(String isbn,String titulo , String autor, int paginas){
        String consulta = "update libro set titulo = '" + titulo + "', autor = '" + autor + "', paginas = " + paginas + " where isbn = " + isbn;

        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement(consulta);

            pstmnt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void PrestaLibros(String isbn){

        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement("Update libro set prestado = true where isbn =?");
            pstmnt.setString(1,isbn);

            pstmnt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DevolverLibro(String isbn){
        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement("Update libro set prestado = false where isbn =?");
            pstmnt.setString(1,isbn);

            pstmnt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Libro getLibroISBN(String isbn){

        String titulo = null, autor = null;
        int paginas = 0;
        boolean prestado = false;

        try {
            Connection connectionBD = ConectionManager.getConexion("biblioteca");
            PreparedStatement stmnt = connectionBD.prepareStatement("SELECT * FROM libro Where isbn = ?");
            stmnt.setString(1,isbn);

            ResultSet rs = stmnt.executeQuery();


            while (rs.next()){
                titulo = rs.getString(2);
                autor = rs.getString(3);
                paginas = rs.getInt(4);
                prestado = rs.getBoolean(5);
            }

            return new Libro(isbn,titulo,autor,paginas,prestado);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Libro> getLibroTitulo(String titulo){

        ArrayList<Libro> ArrayLibro = new ArrayList<>();

        String tituloLb, autor,  isbn;
        int paginas;
        boolean prestado;


        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement("SELECT * FROM libro where titulo like('%" + titulo +"%')");

            ResultSet rs = pstmnt.executeQuery();



            while (rs.next()){
                isbn = rs.getString(1);
                tituloLb = rs.getString(2);
                autor = rs.getString(3);
                paginas = rs.getInt(4);
                prestado = rs.getBoolean(5);

                ArrayLibro.add(new Libro(isbn,tituloLb,autor,paginas,prestado));
            }

            return  ArrayLibro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


    public static void eliminaLibro(String isbn){


        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement("DELETE from libro where isbn = ?");
            pstmnt.setString(1,isbn);

            pstmnt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Libro> muestraTodo(){
        ArrayList<Libro> ArrayLibro = new ArrayList<>();

        String tituloLb, autor,  isbn;
        int paginas;
        boolean prestado;


        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement("SELECT * FROM libro");

            ResultSet rs = pstmnt.executeQuery();



            while (rs.next()){
                isbn = rs.getString(1);
                tituloLb = rs.getString(2);
                autor = rs.getString(3);
                paginas = rs.getInt(4);
                prestado = rs.getBoolean(5);

                ArrayLibro.add(new Libro(isbn,tituloLb,autor,paginas,prestado));
            }

            return  ArrayLibro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void subeDatos(ArrayList<Libro> libros){

        try {
            Connection con = ConectionManager.getConexion("biblioteca");


            for (Libro lb : libros){
                String consulta = "INSERT INTO libro VALUES ('" + lb.getIsbn() +"','" + lb.getTitulo() + "','" + lb.getAutor() + "'," + lb.getPaginas() + "," + lb.isPrestado() + ")";
                PreparedStatement pstmnt = con.prepareStatement(consulta);
                pstmnt.executeUpdate(consulta);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
