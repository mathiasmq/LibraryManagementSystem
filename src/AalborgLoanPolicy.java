import java.time.LocalDate;
import java.util.List;

public class AalborgLoanPolicy implements LoanPolicy{

    private final int maximum = 3;

    @Override
    public boolean canLoan (Resource resource, List<Loan> loans, Member member) {
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
    public LocalDate calculateDueDate (Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);

    }
}
