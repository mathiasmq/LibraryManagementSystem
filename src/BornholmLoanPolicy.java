import java.time.LocalDate;
import java.util.List;

public class BornholmLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan (Resource resource, List<Loan> loans, Member member) {
        return true;

    }

    @Override
    public LocalDate calculateDueDate (Resource resource, LocalDate borrowedDate) {
        if (resource instanceof AudioBook) {
            return borrowedDate.plusDays(14);
        }
return borrowedDate.plusDays(30);
    }
}
