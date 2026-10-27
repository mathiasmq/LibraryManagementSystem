import java.time.LocalDate;
import java.util.ArrayList;

public interface LoanPolicy {
    boolean canLoan (Resource resource, ArrayList<Loan> loans, Member member);
    LocalDate calculateDueDate(Resource resource, LocalDate borrowedDate);
}
