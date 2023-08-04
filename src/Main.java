import java.util.*;

public class Main {
    private static void play(LinkedList<song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<song> listiterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("This playlist has no songs");
        }
        else{
            System.out.println("Now playing "+listiterator.next().toString());
            print_menu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listiterator.hasNext()){
                            listiterator.next();
                        }
                        forward = true;
                    }
                    if(listiterator.hasNext()){
                        System.out.println("Now playing "+listiterator.next().toString());
                    }
                    else {
                        System.out.println("No songs left.");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if (listiterator.hasPrevious()) {
                            listiterator.previous();
                        }
                        forward = false;
                    }
                    if (listiterator.hasPrevious()){
                        System.out.println("Now playing "+ listiterator.previous().toString());
                    }
                    else {
                        System.out.println("We are the fist song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listiterator.hasPrevious()){
                            System.out.println("Now playing "+listiterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("WE are the start of the list");
                        }
                    }
                    else{
                        if(listiterator.hasNext()){
                            System.out.println("Now playing "+listiterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    list(playlist);
                    break;
                case 5:
                    print_menu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listiterator.remove();
                        if(listiterator.hasNext()){
                            System.out.println("Now playing: "+listiterator.next().toString());

                        }
                        else{
                            if(listiterator.hasPrevious()){
                                System.out.println("Now playing: "+listiterator.previous().toString());
                            }
                        }
                    }
                    break;
            }

        }
    }

    private static void print_menu(){
        System.out.println("--------Available options--------");
        System.out.println(" 0 - quit\n"+
                " 1 - to play next song\n"+
                " 2 - to play the previous song\n"+
                " 3- to replay the current song\n"+
                " 4 - list of all songs\n"+
                " 5 - print all available options\n" +
                " 6 - to delete the current song from the playlist\n");
    }

    private static void list(LinkedList<song> playlist){
        Iterator<song> iterator = playlist.iterator();
        System.out.println("-----------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------");
    }
    private static ArrayList<album> albums = new ArrayList<>();
    public static void main(String[] args) {

        album a = new album("album1", "AC/DC");
        a.add_song("TNT", 4.5);
        a.add_song("Highway To Hell", 5.5);
        a.add_song("ThunderStruck", 6.5);
        albums.add(a);

        album a2 = new album("album2", "Eminem");
        a2.add_song("Rap God", 5);
        a2.add_song("Not afraid", 5.8);
        a2.add_song("Lose yourself", 6.5);
        albums.add(a2);

        LinkedList<song> playlist1 = new LinkedList<>();
        albums.get(0).add_to_playlist("TNT", playlist1);
        albums.get(0).add_to_playlist("High To Hell", playlist1);
        albums.get(1).add_to_playlist("Rap God", playlist1);
        albums.get(1).add_to_playlist("Lose yourself", playlist1);

        play(playlist1);
    }
}