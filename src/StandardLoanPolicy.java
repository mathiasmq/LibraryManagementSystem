import java.time.LocalDate;
import java.util.ArrayList;

public class StandardLoanPolicy implements LoanPolicy{

    @Override
    public boolean canLoan (Resource resource, ArrayList<Loan> loans, Member member) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate (Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);


    }
}
