import java.util.HashMap;

public class Hashmatique 
{
    HashMap<String, String> songList = new HashMap<String, String>();

    public void setTracks()
    {
        songList.put("Good Day", "Good morning");
        songList.put("Bye", "Byebye");
        songList.put("Lunch", "I'm pretty hungry");
        songList.put("Dinner", "I'm hungry again");
    }

    public void findSong()
    {
        setTracks();

        String checkTrack = songList.get("Lunch");

        System.out.println(checkTrack);
    }

    public void seeAllTracks()
    {
        setTracks();

        for (String key : songList.keySet()) 
        {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, songList.get(key)));
        }
    }
}