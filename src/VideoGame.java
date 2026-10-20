public class VideoGame extends Resource {
    private String platform;

    public VideoGame (String identifier, String title, String creator, String platform) {
        super (identifier, title, creator);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
