package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    // Constructor
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);  // Gọi constructor của lớp Media
        this.director = director;
        this.length = length;
    }

    // Getter và Setter cho director và length
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Override phương thức toString()
    @Override
    public String toString() {
        return "Disc [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + 
                ", cost=" + getCost() + ", director=" + director + ", length=" + length + "]";
    }
}
