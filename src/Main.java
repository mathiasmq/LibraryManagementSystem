void main(String[] args) {

// Vi opretter biblioteket
    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);

    Mapper mapper = new Mapper();
    LibraryLoader libraryLoader = new LibraryLoader(mapper);

    String libraryPath = args[0];

    //Medlemmer og materialer hentes fra csv-filerne

    try {
        List<Member> loadMembers = libraryLoader.loadMembers("members.csv");

        List<Book> loadBooks = libraryLoader.loadBooks("books.csv");

        List<Movie> loadMovies = libraryLoader.loadMovies("movies.csv");

        List<AudioBook> loadAudioBooks = libraryLoader.loadAudioBooks("audiobooks.csv");

        List<VideoGame> loadVideoGames = libraryLoader.loadVideoGames("videogames.csv");

        // De tlføjes til biblioteket

        for (Member member : loadMembers) {
            library.addMember(member);
        }

        for (Book book : loadBooks) {
            library.addResource(book);
        }

        for (Movie movie : loadMovies) {
            library.addResource(movie);
        }

        for (AudioBook audioBook : loadAudioBooks) {
            library.addResource(audioBook);
        }

        for (VideoGame videoGame : loadVideoGames) {
            library.addResource(videoGame);
        }

        List<LoanId> loadLoans = libraryLoader.loadLoans("loans.csv");

        for (LoanId loanWithId : loadLoans) {
            Member member = library.getMember(loanWithId.getMemberId());
            Resource resource = library.getResourceByIdentifier(loanWithId.getResourceIdentifier());
            Loan loan = new Loan(resource, member, loanWithId.getBorrowedDate(), loanWithId.getDueDate());
            library.addLoan(loan);
        }

    } catch (IOException e) {
        IO.println("An error occured: " + e.getLocalizedMessage());
    }

    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();


//// Vi opretter lister med bøger, film, videospil og lydbøger og tilføjer dem til biblioteket
//    List<Book> books = new ArrayList<>(List.of(
//            new Book("9781492072508", "Think Java", "Allan B. Downey", 150),
//            new Book("9788763851664", "Omrids", "Rachel Cusk", 200),
//            new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 400)));
//
//    for (Book book : books) {
//        library.addResource(book);
//    }
//
//    List<Movie> movies = new ArrayList<>(List.of(
//            new Movie("5701234567890", "Digger", "Legendary Pictures", 129, "Alejandro G. Iñárritu"),
//            new Movie("5701234567899", "Dobbeltfejl", "Nordisk Film", 105, "Amalie Næsby Fick"),
//            new Movie("5701234567898", "Den fremmede", "Nordisk Film", 110, "Francois Ozon"),
//            new Movie("5701234567897", "Druk", "Nordisk Film", 130, "Thomas Vinterberg")));
//
//    for (Movie movie : movies) {
//        library.addResource(movie);
//    }
//
//    List<VideoGame> videoGames = new ArrayList<>(List.of(
//            new VideoGame("5701234567892", "Minecraft", "Mojang Studios", "PC, mobile devices, console"),
//            new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC")));
//
//    for (VideoGame videoGame : videoGames) {
//        library.addResource(videoGame);
//    }
//
//    List<AudioBook> audioBooks = new ArrayList<>(List.of(
//            new AudioBook("9781492072505", "Ringenes Herre: Eventyret om ringen", "Tolkien", 1260),
//            new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600)));
//
//    for (AudioBook audioBook : audioBooks) {
//        library.addResource(audioBook);
//    }
//
//    List<Member> members = new ArrayList<>(List.of(
//            new Member("Thorkild Hansen", 111),
//            new Member("Lise Andersen", 222),
//            new Member("Rojin Atci", 333)));
//
////    for (Member member : members) {
////        library.addMember(member);
////    }
//
//    List<Loan> loans = new ArrayList<>();
//
//    for (Loan loan : loans) {
//        library.addLoan(loan);
//    }
//

//
//
////// Tilføjer medlemmerne til biblioteket
////    library.addMember(member1);
////    library.addMember(member2);
////    library.addMember(member3);
////
////// Tilføjer alle materialerne til biblioteket
////// (polymorfi alle 4 matrialer arver fra Resource med samme metode hvis det giver mening?)
////    library.addResource(book1);
////    library.addResource(book2);
////    library.addResource(book3);
////
////    library.addResource(movie1);
////    library.addResource(movie2);
////    library.addResource(movie3);
////    library.addResource(movie4);
////
////    library.addResource(videoGame1);
////    library.addResource(videoGame2);
////
////    library.addResource(audioBook1);
////    library.addResource(audioBook2);
//
//
//
//     LibrarySaver librarySaver = new LibrarySaver(mapper);
//
//
//     try {
//         librarySaver.saveMembers(members, "C:\\Users\\louis\\Documents\\members.csv");
//         librarySaver.saveBooks(books,"C:\\Users\\louis\\Documents\\books.csv");
//         librarySaver.saveAudioBooks(audioBooks,"C:\\Users\\louis\\Documents\\audiobooks.csv");
//         librarySaver.saveMovies(movies, "C:\\Users\\louis\\Documents\\movies.csv");
//         librarySaver.saveVideoGames(videoGames,"C:\\Users\\louis\\Documents\\videogames.csv");
//         librarySaver.saveLoans(loans,"C:\\Users\\louis\\Documents\\loans.csv");
//     } catch (IOException e) {
//         IO.println("An error occurred: " + e.getLocalizedMessage());
//     }
//
}