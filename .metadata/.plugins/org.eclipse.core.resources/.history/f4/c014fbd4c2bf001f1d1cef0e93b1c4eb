package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Comparator;

public class Cart {
    // Dùng ArrayList<Media> để chứa các đối tượng Media
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Phương thức thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println(media.getTitle() + " has been added to the cart.");
    }

    // Phương thức xóa Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    // Phương thức tính tổng giá trị của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Phương thức hiển thị giỏ hàng
    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in the cart:");
            for (Media media : itemsOrdered) {
                System.out.println(media);
            }
        }
    }

    // Phương thức tìm kiếm Media trong giỏ hàng theo tiêu đề
    public Media searchMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Phương thức lọc Media trong giỏ hàng theo ID hoặc tiêu đề
    public void filterCart(String filterType, String filterValue) {
        ArrayList<Media> filteredItems = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (filterType.equalsIgnoreCase("id") && Integer.toString(media.getId()).equals(filterValue)) {
                filteredItems.add(media);
            } else if (filterType.equalsIgnoreCase("title") && media.getTitle().equalsIgnoreCase(filterValue)) {
                filteredItems.add(media);
            }
        }

        if (filteredItems.isEmpty()) {
            System.out.println("No media found with the given filter.");
        } else {
            System.out.println("Filtered media:");
            for (Media media : filteredItems) {
                System.out.println(media);
            }
        }
    }

    // Phương thức sắp xếp Media trong giỏ hàng theo tiêu đề
    public void sortMediaByTitle() {
        itemsOrdered.sort(Comparator.comparing(Media::getTitle));
    }

    // Phương thức sắp xếp Media trong giỏ hàng theo giá
    public void sortMediaByCost() {
        itemsOrdered.sort(Comparator.comparing(Media::getCost));
    }

    // Lấy danh sách media trong giỏ hàng
    public ArrayList<Media> getItemsInCart() {
        return itemsOrdered;
    }

    // Phương thức xóa tất cả các media trong giỏ hàng (sau khi đặt hàng)
    public void clear() {
        itemsOrdered.clear();
    }
}
