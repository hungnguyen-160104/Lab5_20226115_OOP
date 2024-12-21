package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Khởi tạo tổng = 0

    public SwingAccumulator() {
        // Lấy content pane của JFrame
        Container cp = getContentPane();
        // Thiết lập layout dạng lưới 2x2
        cp.setLayout(new GridLayout(2, 2));

        // Thêm Label
        cp.add(new JLabel("Enter an Integer: "));

        // Tạo JTextField để nhập số
        tfInput = new JTextField(10);
        cp.add(tfInput);
        // Thêm sự kiện
        tfInput.addActionListener(new TFInputListener());

        // Thêm Label cho tổng tích lũy
        cp.add(new JLabel("The Accumulated Sum is: "));

        // Tạo JTextField để hiển thị tổng, đặt read-only
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        // Thiết lập tiêu đề, kích thước và hiển thị JFrame
        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Tạo đối tượng SwingAccumulator
        new SwingAccumulator();
    }

    // Lớp lắng nghe sự kiện
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}

