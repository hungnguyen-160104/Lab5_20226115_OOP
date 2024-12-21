package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media; // Đối tượng Media được hiển thị trong ô

    /**
     * Constructor của MediaStore, khởi tạo giao diện hiển thị thông tin Media.
     * @param media Đối tượng Media cần hiển thị.
     */
    public MediaStore(Media media) {
        this.media = media;

        // Thiết lập layout chính cho MediaStore
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tạo JLabel hiển thị tiêu đề sản phẩm
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Tạo JLabel hiển thị giá sản phẩm
        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Tạo JPanel chứa các nút
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Nút "Add to cart"
        JButton addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);

        // Nếu Media là Playable, thêm nút "Play"
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);

            // Xử lý sự kiện khi nhấn nút "Play"
            playButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle(), 
                                              "Play Media", JOptionPane.INFORMATION_MESSAGE);
            });
        }

        // Xử lý sự kiện khi nhấn nút "Add to cart"
        addToCartButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, media.getTitle() + " added to cart.", 
                                          "Add to Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        // Thêm các thành phần vào MediaStore
        this.add(Box.createVerticalGlue()); // Thêm khoảng trắng phía trên
        this.add(title);                    // Thêm tiêu đề sản phẩm
        this.add(cost);                     // Thêm giá sản phẩm
        this.add(Box.createVerticalGlue()); // Thêm khoảng trắng phía dưới
        this.add(container);                // Thêm các nút vào dưới cùng

        // Thêm viền cho ô MediaStore
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
    }
}
