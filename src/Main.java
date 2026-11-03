 void main() {

// Vi opretter biblioteket
    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);


// Her opretter vi ConsoleUI og giver den adgang til biblioteket.
    ConsoleUI consoleUI = new ConsoleUI(library);

// Vi opretter lister med bøger, film, videospil og lydbøger og tilføjer dem til biblioteket
    List<Book> books = new ArrayList<>(List.of(
            new Book("9781492072508", "Think Java", "Allan B. Downey", 150),
            new Book("9788763851664", "Omrids", "Rachel Cusk", 200),
            new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 400)));

    for (Book book : books) {
        library.addResource(book);
    }

    List<Movie> movies = new ArrayList<>(List.of(
            new Movie("5701234567890", "Digger", "Legendary Pictures", 129, "Alejandro G. Iñárritu"),
            new Movie("5701234567899", "Dobbeltfejl", "Nordisk Film", 105, "Amalie Næsby Fick"),
            new Movie("5701234567898", "Den fremmede", "Nordisk Film", 110, "Francois Ozon"),
            new Movie("5701234567897", "Druk", "Nordisk Film", 130, "Thomas Vinterberg")));

    for (Movie movie : movies) {
        library.addResource(movie);
    }

    List<VideoGame> videoGames = new ArrayList<>(List.of(
            new VideoGame("5701234567892", "Minecraft", "Mojang Studios", "PC, mobile devices, console"),
            new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC")));

    for (VideoGame videoGame : videoGames) {
        library.addResource(videoGame);
    }

    List<AudioBook> audioBooks = new ArrayList<>(List.of(
            new AudioBook("9781492072505", "Ringenes Herre: Eventyret om ringen", "Tolkien", 1260),
            new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600)));

    for (AudioBook audioBook : audioBooks) {
        library.addResource(audioBook);
    }

    List<Member> members = new ArrayList<>(List.of(
            new Member("Thorkild Hansen", 111),
            new Member("Lise Andersen", 222),
            new Member("Rojin Atci", 333)));

    for (Member member : members) {
        library.addMember(member);
    }

    List<Loan> loans = new ArrayList<>(List.of(
            new Loan(new Book("9781492072508", "Think Java", "Allan B. Downey", 150), new Member("Thorkild Hansen", 111), LocalDate.of(2026, 11, 3), LocalDate.of(2026, 12, 3))));

    for (Loan loan : loans) {
        library.addLoan(loan);
    }


//// Tilføjer medlemmerne til biblioteket
//    library.addMember(member1);
//    library.addMember(member2);
//    library.addMember(member3);
//
//// Tilføjer alle materialerne til biblioteket
//// (polymorfi alle 4 matrialer arver fra Resource med samme metode hvis det giver mening?)
//    library.addResource(book1);
//    library.addResource(book2);
//    library.addResource(book3);
//
//    library.addResource(movie1);
//    library.addResource(movie2);
//    library.addResource(movie3);
//    library.addResource(movie4);
//
//    library.addResource(videoGame1);
//    library.addResource(videoGame2);
//
//    library.addResource(audioBook1);
//    library.addResource(audioBook2);

     LibrarySaver librarySaver = new LibrarySaver();

     try {
         librarySaver.saveMembers(members, "members.csv");
         librarySaver.saveBooks(books,"books.csv");
         librarySaver.saveAudioBooks(audioBooks,"audiobooks.csv");
         librarySaver.saveMovies(movies, "movies.csv");
         librarySaver.saveVideoGames(videoGames,"videogames.csv");
         librarySaver.saveLoans(loans,"loans.csv");
     } catch (IOException e) {
         IO.println("An error occurred: " + e.getLocalizedMessage());
     }

// Starter ConesoleUI så brugerne kan bruge vores system
    consoleUI.run();
}