package hust.soict.dsai.swing; // Đổi tên package theo yêu cầu

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // Các nút số từ 0-9
    private JButton btnDelete, btnReset;           // Nút DEL và C
    private JTextField tfDisplay;                 // Ô hiển thị số

    public NumberGrid() {
        // Tạo ô hiển thị
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setEditable(false);

        // Tạo panel chứa các nút
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons); // Thêm các nút vào panel

        // Thiết lập layout của JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Thiết lập JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 400); // Kích thước cửa sổ
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Tạo các nút số từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Tạo nút DEL
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Tạo nút 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Tạo nút C
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    // Lớp xử lý sự kiện khi nhấn nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand(); // Lấy nhãn của nút được nhấn

            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                // Trường hợp nhấn nút số
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // Trường hợp nhấn nút DEL
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (button.equals("C")) {
                // Trường hợp nhấn nút C
                tfDisplay.setText(""); // Xóa toàn bộ nội dung
            }
        }
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        new NumberGrid();
    }
}
