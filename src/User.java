
import java.time.LocalDate;
import java.util.*;

public class User {

    private String name;
    private String libraryCardNumber;
    private List<Book> booksOnLoan;
    private Map<Book, LocalDate> loanedBooks;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
        this.loanedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public void loanBook(Book book) {
        if (!book.isOnLoan()) {
            booksOnLoan.add(book);
            book.setOnLoan(true);
            loanedBooks.put(book, LocalDate.now());
        }
    }

    public void returnBook(Book book) {
        if (booksOnLoan.contains(book)) {
            booksOnLoan.remove(book);
            book.setOnLoan(false);
            loanedBooks.remove(book);
        }
    }

    public double calculateLateFees() {
        double lateFeePerDay = 2.0;
        double totalLateFees = 0.0;
        LocalDate currentDate = LocalDate.now();

        for (Map.Entry<Book, LocalDate> entry : loanedBooks.entrySet()) {
            Book book = entry.getKey();
            LocalDate loanDate = entry.getValue();
            long daysOnLoan = currentDate.toEpochDay() - loanDate.toEpochDay();
            if (daysOnLoan > 14) {
                double lateFee = (daysOnLoan - 14) * lateFeePerDay;
                totalLateFees += lateFee;
            }
        }

        return totalLateFees;
    }
}

