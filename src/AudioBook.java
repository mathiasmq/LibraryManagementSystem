public class AudioBook extends Resource {
    private int audioBookLength;

    public AudioBook (String identifier, String title, String creator, int audioBookLength) {
        super(identifier, title, creator);
        this.audioBookLength = audioBookLength;
    }


    @Override
    public String toString () {
        return "ISBN: " + getIdentifier() + "\nTitle: " + getTitle() + "\nAuthor: " + getCreator() + "\nLength: " + audioBookLength + " minutes";
    }
}
