public class Resource {
    private String identifier;
    private String title;
    private String creator;

public Resource (String identifier, String title, String creator) {
    this.identifier = identifier;
    this.title = title;
    this.creator = title;

}

public String getIdentifier () {
    return identifier;
}

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }
}
