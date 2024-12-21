package hust.soict.dsai.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Override equals() để so sánh đối tượng Media dựa trên title
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra nếu đối tượng truyền vào là đối tượng Media và cùng loại
        if (this == obj) {
            return true; // Nếu là cùng đối tượng (same object)
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Nếu obj là null hoặc không phải đối tượng cùng loại
        }

        // Ép kiểu obj thành Media
        Media otherMedia = (Media) obj;

        // So sánh title
        return this.title != null && this.title.equals(otherMedia.title);
    }

    // Phương thức toString abstract - sẽ được ghi đè trong các lớp con
    public abstract String toString();
}
