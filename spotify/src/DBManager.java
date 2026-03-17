import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {


    public List<Audio> getAudios() throws Exception {

        List<Audio> lista = new ArrayList<>();

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM audio";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Audio a = new Audio(
                rs.getInt("idAudio"),
                rs.getString("titulo"),
                rs.getInt("duracion"),
                rs.getInt("reproducciones")
            );
            lista.add(a);
        }

        return lista;
    }

  
    public void insertarAudio(String titulo, int duracion) throws Exception {
       
    }

  
    public void reproducirAudio(int idAudio) throws Exception {
      
    }

    
    public void crearPlaylist(String nombre) throws Exception {
       
    }

   
    public void agregarAudioAPlaylist(int playlistId, int audioId) throws Exception {
        
    }

 
    public List<Audio> getAudiosDePlaylist(int playlistId) throws Exception {
        return new ArrayList<>();
    }
}
