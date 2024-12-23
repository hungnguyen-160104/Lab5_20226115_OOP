package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.exception.LimitExceededException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20; // Giới hạn số lượng media trong cart
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Thêm Media vào giỏ hàng
 // Trong Cart
    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }


    // Các phương thức khác, ví dụ:
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public ObservableList<Media> getItemsInCart() {
        return itemsOrdered;
    }

    public void clear() {
        itemsOrdered.clear();
    }
}
