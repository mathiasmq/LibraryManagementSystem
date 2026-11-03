import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {
    private final Path path;
    private final Mapper mapper;

    public LibraryLoader(Path path, Mapper mapper) {
        this.path = path;
        this.mapper = mapper;

    }

    public List<Member> loadMembers() throws IOException {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = mapper.memberFromCsv(line);
                members.add(member);
            }
        }
        return members;
    }

    public List<Book> loadBooks() throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = mapper.bookFromCsv(line);
                books.add(book);
            }
        }
        return books;
    }

    public List<Movie> loadMovies() throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Movie movie = mapper.movieFromCsv(line);
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<AudioBook> loadAudioBooks() throws IOException {
        List<AudioBook> audioBooks = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                AudioBook audioBook = mapper.audioBookFromCsv(line);
                audioBooks.add(audioBook);
            }
        }
        return audioBooks;
    }

    public List<VideoGame> loadVideoGames() throws IOException {
        List<VideoGame> videoGames = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                VideoGame videoGame = mapper.videoGameFromCsv(line);
                videoGames.add(videoGame);
            }
        }
        return videoGames;
    }

    public List<Loan> loadLoans(Library library) throws IOException {
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Loan loan = mapper.loanFromCsv(line, library);
                loans.add(loan);
            }
        }
        return loans;
    }

}
