 void main() {

// Vi opretter biblioteket
     LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);


// Her opretter vi ConsoleUI og giver den adgang til biblioteket
    ConsoleUI consoleUI = new ConsoleUI(library);

// Her opretter vi bøgerne
    Book book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 150);
    Book book2 = new Book("9788763851664", "Omrids", "Rachel Cusk", 200);
    Book book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 400);

    Movie movie1 = new Movie("5701234567890", "Digger", "Legendary Pictures", 129, "Alejandro G. Iñárritu");
    Movie movie2 = new Movie("5701234567899", "Dobbeltfejl", "Nordisk Film", 105, "Amalie Næsby Fick");

    VideoGame videoGame1 = new VideoGame("5701234567892", "Minecraft", "Mojang Studios", "PC, mobile devices, console");
    VideoGame videoGame2 = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC");

    AudioBook audioBook1 = new AudioBook("9781492072505", "Ringenes Herre: Eventyret om ringen", "Tolkien", 1260);
    AudioBook audioBook2 = new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600);

// Her opretter vi medlemmerne
    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Lise Andersen", 222);
    Member member3 = new Member("Rojin Atci", 333);

// Tilføjer medlemmerne til biblioteket
    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

// Tilføjer alle materialerne til biblioteket
// (polymorfi alle 4 matrialer arver fra Resource med samme metode hvis det giver mening?)
    library.addResource(book1);
    library.addResource(book2);
    library.addResource(book3);

    library.addResource(movie1);
    library.addResource(movie2);

    library.addResource(videoGame1);
    library.addResource(videoGame2);

    library.addResource(audioBook1);
    library.addResource(audioBook2);

// Starter ConesoleUI så brugerne kan bruge vores system
    consoleUI.run();
}