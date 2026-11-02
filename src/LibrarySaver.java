import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LibrarySaver {

    private String delimiter = ",";


    public void saveMembers(List<Member> members, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(member.getMemberId() + delimiter + member.getName()); //mapper
                writer.newLine();
            }
        }
    }

    public void saveBooks(List<Book> books, String filename) throws IOException {
        Path path = Path.of(filename);
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (Book book : books) {
                    writer.write(book.getIdentifier() + delimiter + book.getTitle() + delimiter + book.getCreator() + delimiter + book.getPages()); // mapper
                    writer.newLine();
                }
        }

    }

    public void saveMovies(List<Movie> movies, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                writer.write(movie.getIdentifier() + delimiter + movie.getTitle() + delimiter + movie.getCreator() + delimiter + movie.getMovieLength() + delimiter + movie.getDirector()); //mapper
                writer.newLine();
            }

        }

    }

    public void saveAudioBooks(List<AudioBook> audioBooks, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for (AudioBook audioBook : audioBooks) {
                writer.write(audioBook.getIdentifier() + delimiter + audioBook.getTitle() + delimiter + audioBook.getCreator() + delimiter + audioBook.getAudioBookLength()); //mapper
                writer.newLine();
            }
        }
    }

    public void saveVideoGames(List<VideoGame> videoGames, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (VideoGame videoGame : videoGames) {
                writer.write(videoGame.getIdentifier() + delimiter + videoGame.getTitle() + delimiter + videoGame.getCreator() + delimiter + videoGame.getPlatform()); //mapper
                writer.newLine();
            }
        }
    }

    public void saveLoans(List<Loan> loans, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                writer.write(loan.getMember().getMemberId() + delimiter + loan.getResource().getIdentifier() + delimiter + loan.getBorrowedDate() + delimiter + loan.getDueDate());
                writer.newLine();
            }
        }

    }
}


