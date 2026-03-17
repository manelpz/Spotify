public class Cancion extends Audio {

    public String artista;
    public String album;
    public String genero;

    public Cancion(int idAudio, String titulo, int duracion, int reproducciones,
                   String artista, String album, String genero) {
        super(idAudio, titulo, duracion, reproducciones);
        this.artista = artista;
        this.album = album;
        this.genero = genero;
    }

    public void cambiarGenero(String genero){
        this.genero = genero;
    }

    @Override
    public void mostrarInfo(){
        System.out.println(titulo + " - " + artista + " [" + genero + "]");
    }
}