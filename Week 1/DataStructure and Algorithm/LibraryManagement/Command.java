import java.util.Scanner;

interface Command {
    void execute();
}
class AddBookCommand implements Command {
    private LibraryManagementSystem library;
    private Scanner scanner;
    public AddBookCommand(LibraryManagementSystem library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        library.addBook(new Book(bookId, title, author));
    }
}

class LinearSearchByTitleCommand implements Command {
    private LibraryManagementSystem library;
    private Scanner scanner;

    public LinearSearchByTitleCommand(LibraryManagementSystem library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Title to Search (Linear Search): ");
        String title = scanner.nextLine();
        Book book = library.linearSearchByTitle(title);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}

class LinearSearchByAuthorCommand implements Command {
    private LibraryManagementSystem library;
    private Scanner scanner;

    public LinearSearchByAuthorCommand(LibraryManagementSystem library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Author to Search (Linear Search): ");
        String author = scanner.nextLine();
        Book book = library.linearSearchByAuthor(author);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}

class BinarySearchByTitleCommand implements Command {
    private LibraryManagementSystem library;
    private Scanner scanner;

    public BinarySearchByTitleCommand(LibraryManagementSystem library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Title to Search (Binary Search): ");
        String title = scanner.nextLine();
        Book book = library.binarySearchByTitle(title);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}

class BinarySearchByAuthorCommand implements Command {
    private LibraryManagementSystem library;
    private Scanner scanner;

    public BinarySearchByAuthorCommand(LibraryManagementSystem library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Author to Search (Binary Search): ");
        String author = scanner.nextLine();
        Book book = library.binarySearchByAuthor(author);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}

class ExitCommand implements Command {
    private Scanner scanner;

    public ExitCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Exiting...");
        scanner.close();
        System.exit(0);
    }
}