import java.util.ArrayList;
import java.util.List;

public class Playlist {

    public int idPlaylist;
    public String nombre;

    public List<Audio> audios = new ArrayList<>();

    public Playlist(int idPlaylist, String nombre) {
        this.idPlaylist = idPlaylist;
        this.nombre = nombre;
    }

    public void agregarAudio(Audio a){
        audios.add(a);
    }

    public void mostrar(){
        System.out.println("Playlist: " + nombre);

        for(Audio a : audios){
            a.mostrarInfo();
        }
    }
}