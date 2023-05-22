import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
        public static <mylibrary> void main(String[] args) {
            // Create books
            Supplier<Book> book1 = () -> new Book("My first book title", "Author 1", 2023, 57, "Technology");
            Supplier<Book> book2 = () -> new Book("My second book title", "Author 2", 2023, 58, "Anime");
            Supplier<Book> book3 = () -> new Book("My third book title", "Author 3", 2023, 57, "Technology");
            Supplier<Book> book4 = () -> new Book("My fourth book title", "Author 4", 2021, 67, "Romance");
            Supplier<Book> book5 = () -> new Book("My fifth book title", "Author 5", 2020, 47, "Technology");
            Supplier<Book> book6 = () -> new Book("My six book title", "Author 6", 2023, 37, "Non-fiction");

            // Create library
            Library mylibrary = new Library();

            //Add a book to the library.
            Consumer<Book> addBook = mylibrary ::addBook;
            addBook.accept(book1.get());
            addBook.accept(book2.get());
            addBook.accept(book3.get());
            addBook.accept(book4.get());
            addBook.accept(book5.get());
            addBook.accept(book6.get());

            //Remove a book from the library by title.
            Consumer<String> removeBook = mylibrary ::removeBook;
            removeBook.accept("My six book title");


            //Find all books published in a specific year.
            List<Book> booksByYear = mylibrary.findBooksByPublicationYear(2023);
            System.out.println("Books published in 2023:");
            booksByYear.forEach(book -> System.out.println(book.getTitle()));

            //Find the book with the most pages.
            Book bookWithMostPages = mylibrary.findBookWithMostPages();
            System.out.println("Book with the most pages:");
            System.out.println(bookWithMostPages.getTitle());

            //Find all books by a specific author.
            List<Book> booksByAuthor = mylibrary.findBooksByAuthor("Author 1");
            System.out.println("Books by Author 1:");
            booksByAuthor.forEach(book -> System.out.println(book.getTitle()));

            // Print all book titles in the library, sorted alphabetically
            List<String> sortedTitles = mylibrary.getAllBookTitlesSorted();
            System.out.println("Library Books: ");
            sortedTitles.forEach(System.out::println);

            // Find books with more than n pages
            List<Book> booksWithMoreThanPages = mylibrary.findBooksByMinPages(57);
            System.out.println("Books with more than 57 pages:");
            booksWithMoreThanPages.forEach(book -> System.out.println(book.getTitle()));


            // Find books by category
            List<Book> booksByCategory = mylibrary.findBooksByCategory("Technology");
            System.out.println("Books in the Technology category:");
            booksByCategory.forEach(book -> System.out.println(book.getTitle()));

            // Create users
            User user1 = new User("User 1", "001");
            User user2 = new User("User 2", "002");

            // Loan books to users
            Consumer<Book> user1CheckedOut = user1::loanBook;
            user1CheckedOut.accept(book3.get());
            user1CheckedOut.accept(book6.get());

            // Return a book
            Consumer<Book> user1ReturnBook = user1::returnBook;
            user1ReturnBook.accept(book3.get());

            // Calculate late fees for a user
            double lateFees = user2.calculateLateFees();
            System.out.println("Late fees for User 2: $" + lateFees);
        }
    }
