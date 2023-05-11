package XML;

import Aplicacion.Libro;
import DAO.DaoImpLibroBD;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class Escritura {

    public static void escrituraXml(){

        ArrayList<Libro> libros;

        libros = DaoImpLibroBD.muestraTodo();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.newDocument();
            Node root = documento.createElement("Biblioteca");
            documento.appendChild(root);

            for (Libro lb: libros){

                Node libro = documento.createElement("Libro");
                Node isbn = documento.createElement("isbn");
                Node titulo = documento.createElement("titulo");
                Node autor = documento.createElement("autor");
                Node paginas = documento.createElement("paginas");

                root.appendChild(libro);
                ((Element)libro).setAttribute("Prestado", String.valueOf(lb.isPrestado()));

                libro.appendChild(isbn);
                isbn.appendChild(documento.createTextNode(lb.getIsbn()));
                libro.appendChild(titulo);
                titulo.appendChild(documento.createTextNode(lb.getTitulo()));
                libro.appendChild(autor);
                autor.appendChild(documento.createTextNode(lb.getAutor()));
                libro.appendChild(paginas);
                paginas.appendChild(documento.createTextNode(String.valueOf(lb.getPaginas())));

                TransformerFactory tf = TransformerFactory.newInstance();

                Transformer transformer = tf.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(new DOMSource(documento),new StreamResult("src/main/resources/biblioteca.xml"));
            }

            JOptionPane.showMessageDialog(null,"Los datos han sido guardados con exito");

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}
