import java.time.LocalDate;

public class Mapper {

    private final String delimiter = ",";


    // ---------- Member: memberId, name ----------

    //Konverterer en CSV-linje til et Member-objekt:
    public Member memberFromCsv(String line) {
        String[] parts = line.split(",");

        int memberId = Integer.parseInt(parts[0]);
        String name = parts[1];

        return new Member(name, memberId);

    }


    //Konverterer et Member-objekt til en CSV-linje:
    public String memberToCsv(Member member) {
        return member.getMemberId() + delimiter + member.getName();

    }

    // ---------- Book: identifier,title, creator,pages ----------

    //Konverterer en CSV-linje til et Book-objekt:
    public Book bookFromCsv(String line) {
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        int pages = Integer.parseInt(parts[3]);

        return new Book(identifier, title, creator, pages);
    }

    //Konverterer et Book-objekt til en CSV-linje:
    public String bookToCsv(Book book) {
        return book.getIdentifier() + delimiter
                + book.getTitle() + delimiter
                + book.getCreator() + delimiter
                + book.getPages();
    }


    // ---------- AudioBook: identifier, title, creator, audioBookLength ----------

    //Konverterer en CSV-linje til et AudioBook-objekt:
    public AudioBook audioBookFromCsv(String line) {
        String[] parts = line.split(delimiter);

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        int audioBookLength = Integer.parseInt(parts[3]);

        return new AudioBook(identifier, title, creator, audioBookLength);


    }

    //Konverterer et AudioBook-objekt til en CSV-linje:
    public String audioBookToCsv(AudioBook audioBook) {
        return audioBook.getIdentifier() + delimiter
                + audioBook.getTitle() + delimiter
                + audioBook.getCreator() + delimiter
                + audioBook.getAudioBookLength();
    }


    // ---------- VideoGame: identifier, title, creator, platform) ----------

    //Konverterer en CSV-linje til et VideoGame-objekt:
    public VideoGame videoGameFromCsv(String line) {
        String[] parts = line.split(delimiter);

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        String platform = parts[3];

        return new VideoGame(identifier, title, creator, platform);
    }

    //Konverterer et VideoGame-objekt til en CSV-linje:
    public String videoGameToCsv(VideoGame videoGame) {
        return videoGame.getIdentifier() + delimiter
                + videoGame.getTitle() + delimiter
                + videoGame.getCreator() + delimiter
                + videoGame.getPlatform();
    }


    // ---------- Loan: resource,member,borrowedDate,dueDate ----------

    // Lånet skal finde det rigtige medlem og materiale i biblioteket,
    // derfor får metoden library med

    //Konverterer en CSV-linje til et Loan-objekt:
    public Loan loanFromCsv(String line, Library library) {
        String[] parts = line.split(delimiter);

        Member member = library.getMember(Integer.parseInt(parts[0]));
        Resource resource = library.getResourceByIdentifier(parts[1]);
        LocalDate borrowedDate = LocalDate.parse(parts[2]);
        LocalDate dueDate = LocalDate.parse(parts[3]);

        return new Loan(resource, member, borrowedDate, dueDate);
    }

    //Konverterer et Loan-objekt til en CSV-linje:
    public String loanToCsv(Loan loan) {
        return loan.getMember().getMemberId() + delimiter
                + loan.getResource().getIdentifier() + delimiter
                + loan.getBorrowedDate() + delimiter
                + loan.getDueDate();
    }


}
