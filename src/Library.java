import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {
    // Opretter ArrayLists til at holde styr på bibliotekets materialer, medlemmer og lån
    private List<Resource> resources = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private LoanPolicy loanPolicy;

    public Library (LoanPolicy loanPolicy) {
        this.loanPolicy = loanPolicy;
    }

    // Setters
// Tilføjer et materiale til bibliotekets liste over materialer
    public void addResource(Resource resource) {
        resources.add(resource);
    }

    // Tilføjer et medlem til bibliotekets liste over medlemmer
    public void addMember(Member member) {
        members.add(member);
    }

    // Getters
// Henter array listen med alle medlemmer i biblioteket
    public List<Member> getMembers() {
        return members;
    }

    // Henter array listen med alle aktive lån
    public List<Loan> getLoans() {
        return loans;
    }

    // Printers
// Går igennem array listen og printer alle materialer i biblioteket
    public void printResources() {
        for (Resource resource : resources) {
            IO.println(resource);
        }
    }

    // Går igennem array listen og printer alle medlemmer i biblioteket
    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }

    // Finder et bestemt materiale ud fra dets titel
    public Resource getResource(String title) {
        for (Resource resource : resources) {
            if (title.equals(resource.getTitle())) {
                return resource;
            }
        }

        // Returnerer null hvis der ikke findes et materiale med det identifier
        return null;
    }

    // Finder et bestemt medlem ud fra deres medlems ID
    public Member getMember(int memberId) {
        for (Member member : members) {
            if (memberId == member.getMemberId()) {
                return member;
            }
        }

        // Returnerer null hvis der ikke findes et medlem med det ID
        return null;
    }

    // Forsøger at låne et materiale til et medlem og returnerer resultatet
    public LoanResult loan(String title, int memberId) {
        Member member = getMember(memberId);

        // Stopper hvis medlemmet ikke findes
        if (member == null) {
            return LoanResult.MEMBER_NOT_FOUND;
        }

        Resource resource = getResource(title);

        // Stopper hvis materialet ikke findes
        if (resource == null) {
            return LoanResult.RESOURCE_NOT_FOUND;
        }



        // Stopper hvis materialet allerede er lånt ud
        for (Loan loan : loans) {
            if (loan.getResource() == resource) {
                return LoanResult.ALREADY_LOANED;
            }
        }

        if (!loanPolicy.canLoan(resource, loans, member)) {
            return LoanResult.CAN_NOT_LOAN;
        }

        LocalDate today = LocalDate.now();
        LocalDate dueDate = loanPolicy.calculateDueDate(resource, today);

        // Opretter et nyt lån med dags dato og tilføjer det til listen
        Loan newLoan = new Loan(resource, member, today, dueDate);
        loans.add(newLoan);

        return LoanResult.SUCCESS;
    }

    // Forsøger at aflevere et materiale ud fra dets titel
    public boolean returnLoan(String title) {
        Resource resource = getResource(title);

        // Stopper hvis materialet ikke findes
        if (resource == null) {
            return false;
        }

        // Finder materialets lån og fjerner det fra listen
        for (Loan loan : loans) {
            if (loan.getResource() == resource) {
                loans.remove(loan);
                return true;
            }
        }

        // Returnerer false hvis materialet ikke var lånt ud
        return false;
    }

    // Finder alle lån der tilhører et bestemt medlem
    public ArrayList<Loan> findLoansByMemberId(int memberId) {

        // Her opretter vi en ny ArrayList som er tom til de lån vi finder
        ArrayList<Loan> foundLoans = new ArrayList<>();

        // Går igennem alle aktive lån
        for (Loan loan : loans) {

            // Tjekker om lånet tilhører det valgte medlem
            if (loan.getMember().getMemberId() == memberId) {

                // Tilføjer lånet til array listen hvis medlems ID'et er korrekt
                foundLoans.add(loan);
            }
        }

        // Returnerer array listen med medlemmets lån
        return foundLoans;
    }
}