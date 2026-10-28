import java.time.LocalDate;
import java.util.List;

public class TestDoubleLoanPolicy implements LoanPolicy{

    public boolean canLoanCalled = false;
    public boolean calculateDueDateCalled = false;

    @Override
    public boolean canLoan (Resource resource, List<Loan> loans, Member member) {
        canLoanCalled = true;
        return true;
    }

    @Override
    public LocalDate calculateDueDate (Resource resource, LocalDate borrowedDate) {
        calculateDueDateCalled = true;
        return borrowedDate;
    }
}
