import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {
    private final Mapper mapper;

    public LibraryLoader(Mapper mapper) {
        this.mapper = mapper;

    }

    public List<Member> loadMembers(String filename) throws IOException {
        List<Member> members = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = mapper.memberFromCsv(line);
                members.add(member);
            }
        }
        return members;
    }

    public List<Book> loadBooks(String filename) throws IOException {
        List<Book> books = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = mapper.bookFromCsv(line);
                books.add(book);
            }
        }
        return books;
    }

    public List<Movie> loadMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Movie movie = mapper.movieFromCsv(line);
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<AudioBook> loadAudioBooks(String filename) throws IOException {
        List<AudioBook> audioBooks = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                AudioBook audioBook = mapper.audioBookFromCsv(line);
                audioBooks.add(audioBook);
            }
        }
        return audioBooks;
    }

    public List<VideoGame> loadVideoGames(String filename) throws IOException {
        List<VideoGame> videoGames = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                VideoGame videoGame = mapper.videoGameFromCsv(line);
                videoGames.add(videoGame);
            }
        }
        return videoGames;
    }

    public List<LoanId> loadLoans(String filename) throws IOException {
        List<LoanId> loansWithId = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                LoanId loanId = mapper.loanWithIdFromCsv(line);
                loansWithId.add(loanId);
            }
        }
        return loansWithId;
    }

}
