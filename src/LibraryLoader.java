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
                Member member = Mapper.fromCsv(line);
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
                Book book = Mapper.fromCsv(line);
                books.add(book);
            }
        }
        return books;
    }


}
