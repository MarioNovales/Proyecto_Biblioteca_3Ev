/*
    Clase en la que se establece la conexion con la base de datos. Se ha utilizado el estilo singelton
 */

package DAO;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionManager {
    private static Connection con;
    private static ConectionManager conexionBD;

    private ConectionManager(String bd){

        try {
            con = DriverManager.getConnection("jdbc:mysql://bd-mysql.c9riw8ew65p8.us-east-1.rds.amazonaws.com:3306/" + bd ,"admin",getContraseña());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion(String bd){

        if(conexionBD == null)
            conexionBD = new ConectionManager(bd);
        return con;
    }

    public static void closeConexion(){

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getContraseña(){

        String pwd;
        File archivo = new File("src/main/resources/pwd.txt");

        try(FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)) {

            pwd = br.readLine();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pwd;
    }
}
