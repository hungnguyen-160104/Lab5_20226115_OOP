package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;

    public StoreScreen(Store store) {
        this.store = store;

        // Thiết lập layout cho JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Thêm các thành phần vào layout
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Cài đặt JFrame
        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Tạo khu vực phía trên (Menu Bar và Header)
     */
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    /**
     * Tạo Menu Bar cho giao diện
     */
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    /**
     * Tạo Header với tiêu đề "AIMS" và nút "View Cart"
     */
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    /**
     * Tạo lưới hiển thị danh sách sản phẩm
     */
    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2)); // Lưới 3x3

        ArrayList<Media> mediaInStore = store.getItemsInStore(); // Lấy danh sách sản phẩm từ Store
        for (int i = 0; i < mediaInStore.size(); i++) { // Hiển thị tất cả sản phẩm
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    /**
     * Phương thức main để chạy giao diện
     */
    public static void main(String[] args) {
        // Tạo Store và thêm sản phẩm mẫu
        Store store = new Store();
        store.addMedia(new Book(1, "Book1's Title", "Fiction", 50.0f));
        store.addMedia(new CompactDisc(2, "CD1's Title", "Music", 40.0f, 60, "Director1", "Artist1"));
        store.addMedia(new DigitalVideoDisc(3, "DVD1's Title", "Movie", 30.0f));


        // Hiển thị giao diện
        new StoreScreen(store);
    }
}
