public class Book {
    private String title;
    private boolean isAvailable;

    public Book(String title){
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private List<Book> booksBorrowed;

    public Patron(String name){
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public void borrowBook(Book book){
        if (book.isAvailable()){
            booksBorrowed.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book){
        if (booksBorrowed.remove(book)){
            book.setAvailable(true);
            System.out.println(name + " returned " + book.getTitle());
        }else {
            System.out.println(name + " did not borrow " + book.getTitle());
        }
    }
}import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    public void listBooks(){
        System.out.println("Books in the library:");
        for (Book book : books){
            System.out.println("*" + book.getTitle() + " Available books: " + book.isAvailable());
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found: " + title);
        return null;
    }
}public class App {
    public static void main(String[] args) {
        Library library = new Library();

        Patron Anneta = new Patron("Anneta");


        library.addBook(new Book("The boy who lost hope"));
        library.addBook(new Book("Reginald in the land of idiots"));
        library.addBook(new Book("No Sweetness Here"));

        System.out.println("---------------------");

        library.listBooks();

        System.out.println("---------------------");

        Book bookToBorrow = library.findBook("The boy who lost hope");
        if (bookToBorrow != null) {
            Anneta.borrowBook(bookToBorrow);
        }

        Book bookToBorrow1 = library.findBook("No Sweetness Here");
        if (bookToBorrow != null) {
            Anneta.borrowBook(bookToBorrow1);
        }

        System.out.println("---------------------");

        library.listBooks();

        System.out.println("---------------------");

        if (bookToBorrow != null){
            Anneta.returnBook(bookToBorrow);
        }

        System.out.println("---------------------");

        library.listBooks();
    }
}
