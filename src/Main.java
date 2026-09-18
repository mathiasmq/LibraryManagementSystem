void main() {

// Vi opretter biblioteket
    Library library = new Library();

// Her opretter vi ConsoleUI og giver den adgang til biblioteket
    ConsoleUI consoleUI = new ConsoleUI(library);

// Her opretter vi bøgerne
    Book book1 = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
    Book book2 = new Book("Rachel Cusk", "Omrids", "9788763851664", 2);
    Book book3 = new Book("Yuval Noah Harari", "Sapiens", "9780062316097", 3);

// Her opretter vi medlemmerne
    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Lise Andersen", 222);
    Member member3 = new Member("Rojin Atci", 333);

// Tilføjer medlemmerne til biblioteket
    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

// Tilføjer bøgerne til biblioteket
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

// Starter ConesoleUI så brugerne kan bruge vores system
    consoleUI.run();
}