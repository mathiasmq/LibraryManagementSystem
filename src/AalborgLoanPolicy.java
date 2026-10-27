import java.time.LocalDate;
import java.util.ArrayList;

public class AalborgLoanPolicy implements LoanPolicy{

    private final int maximum = 3;
    private ArrayList<Loan> loans;

    public AalborgLoanPolicy (ArrayList<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean canLoan (Resource resource) {
            int count = 0;
            for (Loan loan : loans) {
                Resource currentResource = loan.getResource();
                if (resource instanceof Movie || resource instanceof VideoGame) {
                    count++;
                    if (count >= maximum)
                        return false;
                }

            }
        return true;
    }

    @Override
    public LocalDate calculateDueDate (Resource resource) {
        return LocalDate.now().plusDays(30);

    }
}
