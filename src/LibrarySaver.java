import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LibrarySaver {

    private final Mapper mapper;

    public LibrarySaver(Mapper mapper) {
        this.mapper = mapper;
    }


    public void saveMembers(List<Member> members, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(mapper.memberToCsv(member));
                writer.newLine();
            }
        }
    }

    public void saveBooks(List<Book> books, String filename) throws IOException {
        Path path = Path.of(filename);
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (Book book : books) {
                    writer.write(mapper.bookToCsv(book));
                    writer.newLine();
                }
        }

    }

    public void saveMovies(List<Movie> movies, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                writer.write(mapper.movieToCsv(movie));
                writer.newLine();
            }

        }

    }

    public void saveAudioBooks(List<AudioBook> audioBooks, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for (AudioBook audioBook : audioBooks) {
                writer.write(mapper.audioBookToCsv(audioBook));
                writer.newLine();
            }
        }
    }

    public void saveVideoGames(List<VideoGame> videoGames, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (VideoGame videoGame : videoGames) {
                writer.write(mapper.videoGameToCsv(videoGame));
                writer.newLine();
            }
        }
    }

    public void saveLoans(List<Loan> loans, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                writer.write(mapper.loanToCsv(loan));
                writer.newLine();
            }
        }

    }
}


