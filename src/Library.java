
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(b -> b.getTitle().equals(title));
    }

    public List<Book> findBooksByPublicationYear(int year) {
        return books.stream()
                .filter(b -> b.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksByMinPages(int minPages) {
        return books.stream()
                .filter(b -> b.getPages() > minPages)
                .collect(Collectors.toList());
    }

    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(b -> b.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public void loanBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null && !book.isOnLoan()) {
            book.setOnLoan(true);
        }
    }

    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null && book.isOnLoan()) {
            book.setOnLoan(false);
        }
    }

    private Book findBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
