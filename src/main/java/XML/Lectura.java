package XML;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Lectura {

    public static ArrayList<Libro> lecturaXml(){

        ArrayList<Libro> listaLibros = new ArrayList<>();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse("src/main/resources/biblioteca.xml");

            NodeList libros = documento.getElementsByTagName("Libro");

            for (int i =0; i < libros.getLength(); i++){

                Node libro = libros.item(i);
                NodeList hijos = libro.getChildNodes();

                String BolPrestado = String.valueOf(libro.getAttributes());
                String isbn = hijos.item(1).getFirstChild().getNodeValue();
                String titulo = hijos.item(3).getFirstChild().getNodeValue();
                String autor = hijos.item(5).getFirstChild().getNodeValue();
                String strPaginas = hijos.item(7).getFirstChild().getNodeValue();

                int paginas = Integer.parseInt(strPaginas);
                boolean prestado = Boolean.parseBoolean(BolPrestado);

                listaLibros.add(new Libro(isbn,titulo,autor,paginas,prestado));


            }

            DaoImpLibroBD.subeDatos(listaLibros);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        return listaLibros;
    }
}
