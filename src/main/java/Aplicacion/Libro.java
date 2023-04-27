package Aplicacion;

public class Libro {

    private int isbn;
    private String titulo;
    private String autor;
    private int paginas;

    public Libro(int isbn, String titulo, String autor, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libro: isbn=" + isbn + ", titulo=" + titulo + '\'' + ", autor=" + autor + '\'' + ", paginas=" + paginas;
    }
}
