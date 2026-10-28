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
                case 1 -> borrowResource();
                case 2 -> returnResource();
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
        IO.println("1. Borrow a material");
        IO.println("2. Return a material");
        IO.println("3. Show loans for a member");
        IO.println("4. Register a new member");
        IO.println("0. Exit");
        IO.println();
    }

    // Lader brugeren låne et materiale ved hjælp af loan fra Library-klassen
    private void borrowResource() {

        IO.println();
        IO.println("--- Borrow a Material ---");


        // Modtager materialets title fra brugeren
        String title = IO.readln("Enter title: ");


        // Modtager medlemmets ID fra brugeren
        int memberId = Integer.parseInt(
                IO.readln("Enter member id: "));

        IO.println();

        // Forsøger at låne materialet og gemmer resultatet
        LoanResult result = library.loan(title, memberId);

        IO.println();


        // Viser en besked til brugeren ud fra resultatet
        switch (result) {
            case SUCCESS -> IO.println("Material successfully borrowed.");
            case MEMBER_NOT_FOUND -> IO.println("The member is not registered in the library.");
            case RESOURCE_NOT_FOUND -> IO.println("The material is not registered in the library.");
            case CAN_NOT_LOAN -> IO.println("Sorry. You can only borrow 3 movies or video games at a time");
            case ALREADY_LOANED -> IO.println("The material is already on loan.");
        }
    }

    // Lader brugeren aflevere et materiale
    private void returnResource() {

        IO.println();
        IO.println("--- Return a Material ---");

        // Modtager materialets title fra brugeren
        String title = IO.readln("Enter title: ");

        // Forsøger at aflevere materialet gennem Library metoden returnLoan og gemmer om det lykkedes
        boolean returned = library.returnLoan(title);

        // Fortæller brugeren om afleveringen lykkedes
        IO.println();
        if (returned) {
            IO.println("Material successfully returned.");
        } else {
            IO.println("The material could not be returned. Check that it exists and is on loan.");
        }
    }

    // Lader brugeren se alle lån for et bestemt medlem
    private void showLoans() {

        IO.println();
        IO.println("--- Show Member Loans ---");

        // Modtager member ID fra brugeren
        int memberId = Integer.parseInt(IO.readln("Enter member ID: "));

        // Finder alle lån for medlemmet gennem Library metoden og gemmer dem i en liste
        ArrayList<Loan> loans = library.findLoansByMemberId(memberId);

        // Tjekker om array listen er tom og fortæller brugeren hvis der ikke er nogle aktive lån
        if (loans.isEmpty()) {
            IO.println();
            IO.println("No active loans found.");
        }

        // Går igennem array listen og viser hvert lån
        for (Loan loan : loans) {
            IO.println(loan);
        }
    }

    //User story 1:
    //Lader bibliotekaren registrere en ny låner:
    private void registerMember() {
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