import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    // Opretter ArrayLists til at holde styr på bibliotekets bøger, medlemmer og lån
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

// Setters
// Tilføjer en bog til bibliotekets liste over bøger
    public void addBook(Book book) {
        books.add(book);
    }

// Tilføjer et medlem til bibliotekets liste over medlemmer
    public void addMember(Member member) {
        members.add(member);
    }

// Getters
// Henter array listen med alle vores bøger i biblioteket
    public ArrayList<Book> getBooks() {
        return books;
    }

// Henter array listen med alle medlemmer i biblioteket
    public ArrayList<Member> getMembers() {
        return members;
    }

// Henter array listen med alle aktive lån
    public ArrayList<Loan> getLoans() {
        return loans;
    }

// Printers
// Går igennem array listen og printer alle bøger i biblioteket
    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

// Går igennem array listen og printer alle medlemmer i biblioteket
    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }

// Finder en bestemt bog ud dens ID
    public Book getBook(int bookId) {
        for (Book book : books) {
            if (bookId == book.getBookId()) {
                return book;
            }
        }

    // Returnerer null hvis der ikke findes en bog med det ID
        return null;
    }

// Finder et bestemt medlem ud fra deres medlems ID
    public Member getMember(int memberId) {
        for (Member member : members) {
            if (memberId == member.getMemberId()) {
                return member;
            }
        }

    // Returnerer null hvis der ikke findes et medlem med det ID
        return null;
    }

// Forsøger at låne en bog til medlem ud fra deres bog ID og medlems ID
    public boolean loanBook(int bookId, int memberId) {
        Book book = getBook(bookId);
        Member member = getMember(memberId);

    // Stopper udlånnet hvis medlemmet ikke findes
        if (member == null) {
            // IO.println("The member ID doesn't exist");
            return false;
        }

    // Stopper hvis bogen ikke findes
        if (book == null) {
            //IO.println("The book ID doesn't exist");
            return false;
        }

    // Sender medlem og bog videre for at oprette et lån
        return loanBook(book, member);
    }

// Opretter et lån hvis bogen ikke allerede er lånt
    private boolean loanBook(Book book, Member member) {
    // Går igennem lånene for at se om nogen allerede har lånt bogen
        for (Loan loan : loans) {
            if (loan.getBook() == book) {
                IO.println("This book is already borrowed and cannot be loaned.");
                return false;
            }
        }

    // Opretter et nyt lån med dags dato
        LocalDate borrowedDate = LocalDate.now();
        Loan loan = new Loan(book, member, borrowedDate);

    // Tilføjer der nye lån til array listen med lån
        loans.add(loan);

    // Printer information for det nye lån
        IO.println("Book successfully borrowed:");
        IO.println(loan);

    // Returnerer true hvis lånet lykkedes
        return true;
    }

// Forsøger at aflevere en bog ud fra dens ID
    public boolean returnBook(int bookId) {
        Book book = getBook(bookId);

    // Den stopper hvis bogen ikke findes
        if (book == null) {
            return false;
        }

    // Finder bogens lån og fjerner det fra ArrayList
        for (Loan loan : loans) {
            if (loan.getBook().getBookId() == bookId) {
                loans.remove(loan);
                return true;
            }
        }

    // Retunerer false hvis bogen ikke var lånt
        return false;
    }

// Finder alle lån der tilhører et bestemt medlem
    public ArrayList<Loan> findLoansByMemberId(int memberId) {

    // Her opretter vi en ny ArrayList som er tom til de lån vi finder
        ArrayList<Loan> foundLoans = new ArrayList<>();

    // Går igennem alle aktive lån
        for (Loan loan : loans) {

        // Tjekker om lånet tilhører det valgte medlem
            if (loan.getMember().getMemberId() == memberId) {

            // Tilføjer lånet til array listen hvis medlems ID'et er korrekt
                foundLoans.add(loan);

            }
        }

    // Returnerer array listen med medlemmets lån
        return foundLoans;
    }
}