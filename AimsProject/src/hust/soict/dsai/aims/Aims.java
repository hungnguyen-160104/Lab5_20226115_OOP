package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.cart.*;

import java.util.Scanner;

public class Aims {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();  // Đây là đối tượng của Store
    private static Cart cart = new Cart();    // Đây là đối tượng của Cart

    public static void main(String[] args) {
        // Tạo một số media mẫu
        initializeStore();

        // Chạy ứng dụng console
        showMenu();
    }

    // Hàm hiển thị menu chính
    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng newline sau khi nhập

            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Hàm hiển thị menu của cửa hàng
    public static void storeMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cartMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Hàm xem chi tiết media
    public static void viewMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        // Tìm media trong store (không phải trong cart)
        Media media = store.searchMedia(title);

        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    // Hàm hiển thị menu chi tiết media
    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println(media.getTitle() + " has been added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Hàm thêm media vào giỏ hàng
    public static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        // Tìm media trong store (không phải trong cart)
        Media media = store.searchMedia(title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " has been added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // Hàm phát media
    public static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        // Tìm media trong store (không phải trong cart)
        Media media = store.searchMedia(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or does not exist.");
        }
    }

    // Hàm hiển thị menu cập nhật cửa hàng
    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Hàm thêm media vào cửa hàng
    public static void addMediaToStore() {
        System.out.print("Enter media type (DVD/CD/Book): ");
        String type = scanner.nextLine();
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        System.out.print("Enter media category: ");
        String category = scanner.nextLine();
        System.out.print("Enter media cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        Media media = null;
        switch (type.toLowerCase()) {
            case "dvd":
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                media = new DigitalVideoDisc(1, title, category, cost, director, length);
                break;
            case "cd":
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                media = new CompactDisc(1, title, category, cost, 0, "", artist);
                break;
            case "book":
                media = new Book(1, title, category, cost);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }

        store.addMedia(media);
        System.out.println(media.getTitle() + " has been added to the store.");
    }

    // Hàm xóa media khỏi cửa hàng
    public static void removeMediaFromStore() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        // Tìm media trong store (không phải trong cart)
        Media media = store.searchMedia(title);

        if (media != null) {
            store.removeMedia(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // Hàm hiển thị menu giỏ hàng
    public static void cartMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Hàm lọc media trong giỏ hàng
    public static void filterCart() {
        // Bạn có thể chọn lọc theo id hoặc title
        System.out.print("Enter a title to filter in cart: ");
        String title = scanner.nextLine();
        Media media = cart.searchMedia(title);

        if (media != null) {
            System.out.println("Filtered media: " + media);
        } else {
            System.out.println("No media found with the given title in the cart.");
        }
    }

    // Hàm sắp xếp media trong giỏ hàng
    public static void sortCart() {
        // Giả sử bạn sắp xếp theo title hoặc cost, đây là ví dụ sắp xếp theo title.
        cart.sortMediaByTitle();
        System.out.println("The media in your cart has been sorted by title.");
    }

    // Hàm xóa media khỏi giỏ hàng
    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove from cart: ");
        String title = scanner.nextLine();
        Media media = cart.searchMedia(title);

        if (media != null) {
            cart.removeMedia(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    // Hàm phát media từ giỏ hàng
    public static void playMediaFromCart() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchMedia(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or does not exist in the cart.");
        }
    }

    // Hàm đặt hàng
    public static void placeOrder() {
        if (cart.getItemsInCart().isEmpty()) {
            System.out.println("Your cart is empty. Please add media to your cart before placing an order.");
        } else {
            System.out.println("Your order has been placed successfully!");
            cart.clear();  // Xóa tất cả các media trong giỏ hàng sau khi đặt hàng
            System.out.println("Your cart has been cleared.");
        }
    }

    // Hàm khởi tạo cửa hàng với một số media mẫu
    public static void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        CompactDisc cd1 = new CompactDisc(2, "Abbey Road", "Music", 24.95f, 47, "George Martin", "The Beatles");
        Book book1 = new Book(3, "Harry Potter", "Fantasy", 29.99f);

        store.addMedia(dvd1);
        store.addMedia(cd1);
        store.addMedia(book1);
    }
}

