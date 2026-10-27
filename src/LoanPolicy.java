import java.time.LocalDate;

public interface LoanPolicy {
    boolean canLoan (Resource resource);
    LocalDate calculateDueDate(Resource resource);
}
