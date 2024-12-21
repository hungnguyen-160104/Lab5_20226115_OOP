package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Phương thức play() theo giao diện Playable
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength() + " minutes");
    }

    // Override phương thức equals để so sánh title và length
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra nếu đối tượng truyền vào là đối tượng Track và cùng loại
        if (this == obj) {
            return true; // Nếu là cùng đối tượng (same object)
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Nếu obj là null hoặc không phải đối tượng cùng loại
        }

        // Ép kiểu obj thành Track
        Track otherTrack = (Track) obj;

        // So sánh title và length
        return this.title != null && this.title.equals(otherTrack.title) && this.length == otherTrack.length;
    }

    // Phương thức toString để hiển thị thông tin track
    @Override
    public String toString() {
        return "Track [title=" + title + ", length=" + length + "]";
    }
}
