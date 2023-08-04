public class song {
    String title;
    double duration;

    public song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public song(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void duration(){

    }

    @Override
    public String toString() {
        return "song{ "+"title= " + title + '\'' + ",duration= " +duration + " }";
    }
}
