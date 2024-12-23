package hust.soict.dsai.swing;

import java.awt.*;           
import java.awt.event.*;     

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Khởi tạo tổng = 0

    public AWTAccumulator() {
        // Thiết lập layout cho Frame là dạng lưới 2x2
        setLayout(new GridLayout(2, 2));

        // Thêm Label đầu tiên
        add(new Label("Enter an Integer: "));

        // Tạo TextField để nhập số
        tfInput = new TextField(10);
        add(tfInput);
        // Thêm ActionListener để xử lý sự kiện khi người dùng nhấn Enter
        tfInput.addActionListener(new TFInputListener());

        // Thêm Label cho tổng tích lũy
        add(new Label("The Accumulated Sum is: "));

        // Tạo TextField để hiển thị tổng, đặt là read-only
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        // Thiết lập tiêu đề, kích thước và hiển thị cửa sổ
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    // Điểm vào chương trình, tạo đối tượng AWTAccumulator
    public static void main(String[] args) {
        new AWTAccumulator();
    }

    // Lớp lắng nghe sự kiện nhập (nội lớp)
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy số người dùng nhập
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn; // Cộng dồn vào sum
            tfInput.setText(""); // Xóa nội dung ô nhập
            tfOutput.setText(sum + ""); // Hiển thị tổng ra output
        }
    }
}
