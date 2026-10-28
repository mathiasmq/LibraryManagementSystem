import java.time.LocalDate;
import java.util.List;

public interface LoanPolicy {
    boolean canLoan (Resource resource, List<Loan> loans, Member member);
    LocalDate calculateDueDate(Resource resource, LocalDate borrowedDate);
}
