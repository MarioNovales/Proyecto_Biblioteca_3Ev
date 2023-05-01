package Aplicacion;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int paginas;

    public Libro(String  isbn, String titulo, String autor, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "Libro: isbn=" + isbn + ", titulo=" + titulo + '\'' + ", autor=" + autor + '\'' + ", paginas=" + paginas;
    }
}
