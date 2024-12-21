package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();


    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }


    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) { 
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" has been added.");
        } else {
            System.out.println("Author \"" + authorName + "\" already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) { 
            authors.remove(authorName);
            System.out.println("Author \"" + authorName + "\" has been removed.");
        } else {
            System.out.println("Author \"" + authorName + "\" does not exist.");
        }
    }

    @Override
    public String toString() {
        return "Book [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() +
                ", cost=" + getCost() + ", authors=" + authors + "]";
    }
}
