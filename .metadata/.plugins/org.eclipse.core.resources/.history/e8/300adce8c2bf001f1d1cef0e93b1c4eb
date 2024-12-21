package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Danh sách các sản phẩm trong cửa hàng
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Thêm một Media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) { // Kiểm tra nếu sản phẩm chưa tồn tại
            itemsInStore.add(media); // Thêm sản phẩm vào danh sách
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println(media.getTitle() + " already exists in the store.");
        }
    }

    // Xóa một Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) { // Kiểm tra nếu sản phẩm tồn tại
            itemsInStore.remove(media); // Xóa sản phẩm khỏi danh sách
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " was not found in the store.");
        }
    }

    // Hiển thị tất cả các item trong cửa hàng
    public void displayItemsInStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Items in store:");
            for (Media media : itemsInStore) {
                System.out.println(media); // Gọi phương thức toString() của Media
            }
        }
    }

    // Tìm kiếm Media trong cửa hàng theo tiêu đề
    public Media searchMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; // Trả về Media nếu tìm thấy
            }
        }
        System.out.println("No media found with title: " + title);
        return null; // Trả về null nếu không tìm thấy
    }

    // Kiểm tra sự tồn tại của một Media trong cửa hàng
    public boolean isMediaInStore(Media media) {
        return itemsInStore.contains(media);
    }

    // Lấy danh sách sản phẩm trong cửa hàng
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
