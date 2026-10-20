public class Movie extends Resource {
    private int movieLength;
    private String director;

    public Movie (String identifier, String title, String creator, int movieLength, String director) {
        super (identifier, title, creator);
        this.movieLength = movieLength;
        this.director = director;
    }

    public int getMovieLength () {
        return movieLength;
    }

    public String getDirector() {
        return director;
    }
}
