package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Label totalLabel;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                loader.setController(this);
                Parent root = loader.load();

                // Set up Scene
                fxPanel.setScene(new Scene(root));

                // Initialize TableView
                colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
                colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
                colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));


                // Update total cost
                updateTotalCost();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void updateTotalCost() {
        totalLabel.setText(String.format("%.2f $", cart.totalCost()));
    }
} 
