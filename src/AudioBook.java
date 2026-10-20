public class AudioBook extends Resource {
    private int audioBookLength;

    public AudioBook (String identifier, String title, String creator, int audioBookLength) {
        super (identifier, title, creator);
        this.audioBookLength = audioBookLength;
    }

    public int getAudioBookLength() {
        return audioBookLength;
    }
}
