package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    // Constructor với đầy đủ tham số
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost); // Gọi constructor của Media
        this.director = director;
        this.length = length;
    }

    // Constructor không có director và length
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.director = "";  // Đặt giá trị mặc định cho director nếu không có
        this.length = 0;     // Đặt giá trị mặc định cho length nếu không có
    }

    // Constructor chỉ có id và title
    public DigitalVideoDisc(int id, String title) {
        super(id, title, "", 0); // Gọi constructor của Media với giá trị mặc định
        this.director = "";
        this.length = 0;
    }

    // Getter cho director
    public String getDirector() {
        return director;
    }

    // Setter cho director
    public void setDirector(String director) {
        this.director = director;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Setter cho length
    public void setLength(int length) {
        this.length = length;
    }

    // Phương thức play() theo giao diện Playable
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    // Phương thức toString() để in thông tin đối tượng ra màn hình
    @Override
    public String toString() {
        return "DigitalVideoDisc [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + 
               ", cost=" + getCost() + ", director=" + director + ", length=" + length + "]";
    }
}
