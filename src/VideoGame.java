public class VideoGame extends Resource {
    private String platform;

    public VideoGame (String identifier, String title, String creator, String platform) {
        super (identifier, title, creator);
        this.platform = platform;
    }

    @Override
    public String toString () {
        return "EAN: " + getIdentifier() + "\nTitle: " + getTitle() + "\nCreator: " + getCreator() + "\nPlatform: " + platform;
    }
}
