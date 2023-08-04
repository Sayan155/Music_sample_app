import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String name;
    private String artist;
    private ArrayList<song> songs;

    public album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }
    public album(){
    }

    public song find_song(String title){
        for(song checked: songs){
            if(checked.getTitle()==title)
                return checked;
        }
        return null;
    }

    public boolean add_song(String title, double duration){
        if(find_song(title)==null){
            songs.add(new song(title, duration));
            //System.out.println("song added! \n The title is "+ title+ " the duration is "+duration);
            return true;
        }
        else {
            //System.out.println("Song with the name "+title+" already exists in the list");
            return false;
        }
    }

    public boolean add_to_playlist(int tracknumber, LinkedList<song> playlist){
        int index = tracknumber - 1;
        if(index>0 && index<=this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }
        //System.out.println("This album does not have a track number "+tracknumber);
        return false;
    }

    public boolean add_to_playlist(String title, LinkedList<song> playlist){
        for(song checksong: this.songs) {
            if (checksong.getTitle() == title) {
                playlist.add(checksong);
                return true;
            }
        }
            //System.out.println(title + " ,there is no such song");
        return false;
    }
}
