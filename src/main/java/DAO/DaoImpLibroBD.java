/*
    Clase en la que se implementan los metodos de la interfaz IDaoLibro
 */

package DAO;

import Aplicacion.Libro;

import java.sql.*;
import java.util.ArrayList;

public class DaoImpLibroBD implements IDaoLibro {
    @Override
    public void creaLibro(Libro l) {
    }

    public static void guradaLibro(String isbn,String titulo , String autor, int paginas){

        String consulta = "INSERT INTO libro VALUES ('" + isbn +"','" + titulo + "','" + autor + "'," + paginas +")";

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

    public static String[] sacaIsbn(){
        String[] array = new String[0];
        String consulta = "SELECT isbn FROM libro;";
        String consulta1 = "SELECT count(isbn) as 'cantidad' FROM libro;";

        try(Connection con = ConectionManager.getConexion("biblioteca")) {

            try(Statement stmnt = con.createStatement()) {
                ResultSet rs = stmnt.executeQuery(consulta1);

                array = new String[rs.getInt("cantidad")];

                rs.close();
                ResultSet rs1 = stmnt.executeQuery(consulta);

                for (int i = 0; i < array.length;i++){
                    String isbn = rs1.getString("isbn");
                    array[i] = isbn;
                    System.out.println(isbn);
                    System.out.println("hola");
                }

                rs1.close();

            } catch (SQLException e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return array;
    }

    public static Libro getLibroISBN(String isbn){

        String titulo = null, autor = null;
        int paginas = 0;

        try {
            Connection connectionBD = ConectionManager.getConexion("biblioteca");
            PreparedStatement stmnt = connectionBD.prepareStatement("SELECT * FROM libro Where isbn = ?");
            stmnt.setString(1,isbn);

            ResultSet rs = stmnt.executeQuery();



            while (rs.next()){
                titulo = rs.getString(2);
                autor = rs.getString(3);
                paginas = rs.getInt(4);
            }

            return new Libro(isbn,titulo,autor,paginas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Libro> getLibroTitulo(String titulo){

        ArrayList<Libro> ArrayLibro = new ArrayList<>();

        String tituloLb, autor,  isbn;
        int paginas = 0;


        try {
            Connection con = ConectionManager.getConexion("biblioteca");
            PreparedStatement pstmnt = con.prepareStatement("SELECT * FROM libro where titulo like('%" + titulo +"%')");

            ResultSet rs = pstmnt.executeQuery();



            while (rs.next()){
                isbn = rs.getString(1);
                tituloLb = rs.getString(2);
                autor = rs.getString(3);
                paginas = rs.getInt(4);

                ArrayLibro.add(new Libro(isbn,tituloLb,autor,paginas));
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

}
