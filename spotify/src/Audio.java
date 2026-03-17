public class Audio {

    public int idAudio;
    public String titulo;
    public int duracion;
    public int reproducciones;

    public Audio(int idAudio, String titulo, int duracion, int reproducciones) {
        this.idAudio = idAudio;
        this.titulo = titulo;
        this.duracion = duracion;
        this.reproducciones = reproducciones;
    }

    public void reproducir(){
        reproducciones++;
    }

    public void mostrarInfo(){
        System.out.println(idAudio + " - " + titulo + " (" + reproducciones + ")");
    }
}