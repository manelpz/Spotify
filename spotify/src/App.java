import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        DBManager db = new DBManager();

        List<Audio> audios = db.getAudios();

        for(Audio a : audios){
            a.mostrarInfo();
        }



    }
}