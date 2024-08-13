import java.util.List;

public class Library {

    private String name;
    private List<Book> availableBooks;
    private Address location;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public Address getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void setLocation(Address location) {
        this.location = location;
    }
}
