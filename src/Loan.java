import java.time.LocalDate;

public class Loan {
// Gemmer bogen, medlemmet og datoen for lån
    private final Book book;
    private final Member member;
    private final LocalDate borrowedDate;

// Tilføjer book, member og borrowedDate til konstruktøren
    public Loan(Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

// Getters
// Bruges til at hente den bog som er blevet lånt
    public Book getBook() {
        return book;
    }

// Henter det medlem som har lånt bogen
    public Member getMember() {
        return member;
    }

// Finder datoen for aflevering, der bliver lagt 14 dage til dags dato
    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

// Tjekker om afleveringsdatoen er overskredet
    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return LocalDate.now().isAfter(getDueDate());
    }

// Retunerer information om lånet som tekst
    @Override
    public String toString() {
        String status = isOverdue() ? "Overdue" : "On loan";
        return String.format("""
            %s
            %s
            Due date: %s
            Status: %s
            """, book, member, getDueDate(), status);
    }
}
