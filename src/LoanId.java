import java.time.LocalDate;

public class LoanId {

    // Gemmer materialet, medlemmet og datoen for lånet
    private final String resourceIdentifier;
    private final int memberId;
    private final LocalDate borrowedDate;
    private final LocalDate dueDate;

    // Tilføjer resource, member og borrowedDate til konstruktøren
    public LoanId(String resourceIdentifier, int memberId, LocalDate borrowedDate, LocalDate dueDate) {
        this.resourceIdentifier = resourceIdentifier;
        this.memberId = memberId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    // Henter det materiale som er blevet lånt
    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    // Henter det medlem som har lånt materialet
    public int getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowedDate () {
        return borrowedDate;
    }

    // Finder afleveringsdatoen ved at lægge 14 dage til lånedatoen
    public LocalDate getDueDate() {
        return dueDate;
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
                """, resourceIdentifier, memberId, getDueDate(), status);
    }
}

