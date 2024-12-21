package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, director, length); // Gọi constructor của lớp cha Disc
        this.artist = artist;
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Thêm track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" already exists.");
        }
    }

    // Xóa track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been removed.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" does not exist.");
        }
    }

    // Tính tổng độ dài CD
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Phương thức play() theo giao diện Playable
    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total length of CD: " + this.getLength() + " minutes");
        System.out.println("Tracks in this CD:");
        for (Track track : tracks) {
            track.play(); // Gọi phương thức play() của từng track trong danh sách
        }
    }

    @Override
    public String toString() {
        return "CompactDisc [id=" + getId() + 
               ", title=" + getTitle() + 
               ", category=" + getCategory() + 
               ", director=" + getDirector() + 
               ", artist=" + artist + 
               ", length=" + getLength() + 
               ", cost=" + getCost() + "]";
    }
}
