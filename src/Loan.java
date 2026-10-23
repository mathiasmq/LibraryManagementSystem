import java.time.LocalDate;

public class Loan {

    // Gemmer materialet, medlemmet og datoen for lånet
    private final Resource resource;
    private final Member member;
    private final LocalDate borrowedDate;

    // Tilføjer resource, member og borrowedDate til konstruktøren
    public Loan(Resource resource, Member member, LocalDate borrowedDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    // Henter det materiale som er blevet lånt
    public Resource getResource() {
        return resource;
    }

    // Henter det medlem som har lånt materialet
    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowedDate () {
        return borrowedDate;
    }

    // Finder afleveringsdatoen ved at lægge 14 dage til lånedatoen
    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    // Tjekker om afleveringsdatoen er overskredet
    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(getDueDate());
    }

    // Returnerer information om lånet som tekst
    @Override
    public String toString() {
        String status = isOverdue() ? "Overdue" : "On loan";

        return String.format("""
                %s
                %s
                Due date: %s
                Status: %s
                """, resource, member, getDueDate(), status);
    }
}
