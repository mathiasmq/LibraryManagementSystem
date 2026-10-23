public class Movie extends Resource {
    private int movieLength;
    private String director;

    public Movie (String identifier, String title, String creator, int movieLength, String director) {
        super(identifier, title, creator);
        this.movieLength = movieLength;
        this.director = director;
    }


    @Override
    public String toString () {
        return "EAN: " + getIdentifier() + "\nTitle: " + getTitle() + "\nProduction: " + getCreator() + "\nLength: " + movieLength + " minutes" + "\nDirector: " + director;

    }
}

