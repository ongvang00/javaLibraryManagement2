import java.util.*;
public class Main {
        public static void main(String[] args) {
            // Create books
            Book book1 = new Book("My first book title", "Author 1", 2023, 57, "Technology");
            Book book2 = new Book("My second book title", "Author 2", 2023, 58, "Anime");
            Book book3 = new Book("My third book title", "Author 3", 2023, 57, "Technology");
            Book book4 = new Book("My fourth book title", "Author 4", 2021, 67, "Romance");
            Book book5 = new Book("My fifth book title", "Author 5", 2020, 47, "Technology");
            Book book6 = new Book("My six book title", "Author 6", 2023, 37, "Non-fiction");

            // Create library
            Library mylibrary = new Library();

            // Add books to the library
            mylibrary.addBook(book1);
            mylibrary.addBook(book2);
            mylibrary.addBook(book3);
            mylibrary.addBook(book4);
            mylibrary.addBook(book5);
            mylibrary.addBook(book6);

            //remove books from the library
            mylibrary.removeBook(String.valueOf(book6));


            // Find books by publication year
            List<Book> booksByYear = mylibrary.findBooksByPublicationYear(2023);
            System.out.println("Books published in 2023:");
            booksByYear.forEach(book -> System.out.println(book.getTitle()));


            // Find book with the most pages
            Book bookWithMostPages = mylibrary.findBookWithMostPages();
            System.out.println("Book with the most pages:");
            System.out.println(bookWithMostPages.getTitle());

            // Find books by author
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
            user1.loanBook(book1);
            user1.loanBook(book4);
            user2.loanBook(book5);

            // Return a book
            user1.returnBook(book4);

            // Calculate late fees for a user
            double lateFees = user2.calculateLateFees();
            System.out.println("Late fees for User 2: $" + lateFees);
        }
    }
