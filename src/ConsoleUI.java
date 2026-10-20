import java.util.ArrayList;

public class ConsoleUI {
// Gemmer biblioteket som ConsoleUI skal arbejde med
    private Library library;

// Tilføjer library til konstruktøren
    public ConsoleUI(Library library) {
        this.library = library;
    }

// Starter ConsoleUI
    public void run() {
        boolean running = true;

    // Forsætter med at vise menuen så længe programmet kører
        while (running) {

        // Viser menuen til brugeren
            showMenu();

        // Modtager valg fra brugeren
            int choice = Integer.parseInt(IO.readln("Choose an option: "));

        // Bestemmer hvad der skal ske ud fra brugerens valg
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 4 -> registerMember();
                case 0 -> running = false;
                default -> IO.println("Invalid choice. Please try again.");
            }
        }
    }

// Viser de forskellige valgmuligheder i Menu
    private void showMenu() {
        IO.println();
        IO.println("1. Borrow a book");
        IO.println("2. Return a book");
        IO.println("3. Show all loans");
        IO.println("4. register a new member");
        IO.println("0. Exit");
        IO.println();
    }

// Lader brugeren låne en bog ved hjælp af loanBook fra Library-klassen
    private void borrowBook() {

        IO.println();
        IO.println("--- Borrow a Book ---");

    // Modtager bogens ID fra brugeren
        int bookId = Integer.parseInt(
                IO.readln("Enter book ID: ")
        );

    // Modtager medlemmets ID fra brugeren
        int memberId = Integer.parseInt(
                IO.readln("Enter member id: ")
        );

        IO.println();

    // Bruger metoden fra Library-klassen ved at sende bog og medlems ID
        library.loanBook(bookId, memberId);
    }

// Lader brugeren aflevere en bog
    private void returnBook() {

        IO.println();
        IO.println("--- Return a Book ---");

    // Modtager bog ID fra brugeren
        int bookId = Integer.parseInt(IO.readln("Enter book ID: "));

    // Forsøger at aflevere bogen gennem Library metoden returnBook og gemmer om det lykkedes
        boolean returned = library.returnBook(bookId);

    // Fortæller brugeren om afleveringen lykkedes
        if (returned) {
            IO.println();
            IO.println("Book successfully returned.");
        } else {
            IO.println();
            IO.println("A mistake has been made.");
        }
    }

// Lader brugeren se alle lån for et bestemt medlem
    private void showLoans() {

        IO.println();
        IO.println("--- Show Member Loans ---");

    // Modtager member ID fra brugeren
        int memberId = Integer.parseInt(IO.readln("Enter member ID: "));

    // Finder alle lån for medlemmets gennem Library metoden og gemmer dem i en liste
        ArrayList<Loan> loans = library.findLoansByMemberId(memberId);

    // Tjekker om array listen er tom og fortæller brugeren hvis der ikke er nogle aktive lån
        if (loans.isEmpty()) {
            IO.println();
            IO.println("No active loans found.");
        } else {
            IO.println();
        }

    // Går igennem array listen og viser hvert lån
        for (Loan loan : loans) {
            IO.println(loan);
        }
    }

    //User story 1:
    //som bibliotekar ønsker jeg at registrere en ny låner med lånernummer,
    // så låneren kan låne materialer på biblioteket. (Kan godt slettes igen, bare for overblik)


    //Lader bibliotekaren registrere en ny låner:
    private void registerMember(){
        IO.println();
        IO.println("--- Register a New member ---");

        //Modtager navnet fra brugeren:
        String name = IO.readln("Enter name: ");

        //Modtager lånernummeret fra brugeren:
        int memberId = Integer.parseInt(IO.readln("Enter member ID: "));

        //Opretter et nyt medlem med navn og lånernummer:
        Member member = new Member(name, memberId);

        //Tilføjer medlemmet til biblioteket:
        library.addMember(member);

        IO.println();
        IO.println("Member successfully registered: " + member);

    }

}