import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy{

    @Override
    public boolean canLoan () {
        return true;
    }

    @Override
    public LocalDate calculateDueDate () {
        return LocalDate.now().plusDays(30);


    }
}
