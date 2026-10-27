import java.time.LocalDate;

public class BornholmLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan (Resource resource) {
        return true;

    }

    @Override
    public LocalDate calculateDueDate (Resource resource) {
        if (resource instanceof AudioBook) {
            return LocalDate.now().plusDays(14);
        }
return LocalDate.now().plusDays(30);
    }
}
