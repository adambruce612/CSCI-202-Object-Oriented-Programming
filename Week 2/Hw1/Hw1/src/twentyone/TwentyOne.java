package twentyone;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import java.util.ArrayList;

public class TwentyOne extends Application
{
    private static final String IMG_PATH = "images/";

    private static final Image CARDS_IMG =
            new Image(IMG_PATH + "playingCards.png");

    private static final Image CARD_BACK_IMG =
            new Image(IMG_PATH + "playingCards_Back.png");

    private static final Image LOGO_IMG =
            new Image(IMG_PATH + "logo.png");

    private static final int CARD_IMG_WIDTH = 118;
    private static final int CARD_IMG_HEIGHT = 178;
    private static final int CARD_FIT_WIDTH = 90;
    private static final int CARD_FIT_HEIGHT = 136;

    // the spacing between elements
    private static final int SPACING = 10;

    private TwentyOneGame game;
    private Button newGameBtn;
    private Button hitBtn;
    private Button standBtn;
    private Label messageLbl;
    private Label houseScoreLbl;
    private Label playerScoreLbl;
    private FlowPane houseCardsPane;
    private FlowPane playerCardsPane;
    private int playerScore;

    @Override
    public void start(Stage stage)
    {
        Insets padding = new Insets(SPACING, SPACING, SPACING, SPACING);

        Font headingFont = Font.font(
                "sans-serif",
                FontWeight.BOLD,
                FontPosture.REGULAR,
                16);

        Font labelFont = Font.font(
                "sans-serif",
                FontWeight.NORMAL,
                FontPosture.REGULAR,
                16);

        newGameBtn = new Button("New Game");
        newGameBtn.setOnAction(e -> {
            if (!game.isOver())
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("New game?");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Are you sure you want to start a new game?");
                alert.getButtonTypes().setAll(
                        ButtonType.YES,
                        ButtonType.NO);
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.YES) newGame();
            }
            else
            {
                newGame();
            }
        });

        BorderPane topBar = new BorderPane();
        topBar.setPadding(padding);
        topBar.setStyle("-fx-background-color: #7BBEFF;");
        topBar.setLeft(newGameBtn);

        messageLbl = new Label();
        messageLbl.setFont(headingFont);
        topBar.setCenter(messageLbl);

        hitBtn = new Button("Hit");
        hitBtn.setOnAction(e -> hit());

        standBtn = new Button("Stand");
        standBtn.setOnAction(e -> stand());

        HBox bottomBar = new HBox(SPACING);
        bottomBar.setPadding(padding);
        bottomBar.setStyle("-fx-background-color: #7BBEFF;");
        bottomBar.getChildren().addAll(hitBtn, standBtn);

        houseCardsPane = new FlowPane();
        houseCardsPane.setPadding(new Insets(0, 0, 0, SPACING));
        houseCardsPane.setHgap(SPACING);
        houseCardsPane.setVgap(SPACING);

        playerCardsPane = new FlowPane();
        playerCardsPane.setPadding(new Insets(0, 0, 0, SPACING));
        playerCardsPane.setHgap(SPACING);
        playerCardsPane.setVgap(SPACING);

        VBox table = new VBox(SPACING*2);
        table.setPadding(padding);
        table.setStyle("-fx-background-color: #55AA55;");

        Label houseLbl = new Label("House");
        houseLbl.setFont(headingFont);

        houseScoreLbl = new Label();
        houseScoreLbl.setFont(labelFont);

        Label houseScoreTxtLbl = new Label("Score: ");
        houseScoreTxtLbl.setFont(labelFont);
        HBox houseScoreBox = new HBox();
        houseScoreBox.getChildren().addAll(houseScoreTxtLbl, houseScoreLbl);

        VBox houseInfoBox = new VBox();
        houseInfoBox.setPadding(padding);
        houseInfoBox.setStyle("-fx-background-color: #FFFFFF;");
        houseInfoBox.getChildren().addAll(houseLbl, houseScoreBox);

        Label playerLbl = new Label("Player 1");
        playerLbl.setFont(headingFont);

        playerScoreLbl = new Label();
        playerScoreLbl.setFont(labelFont);

        Label playerScoreTxtLbl = new Label("Score: ");
        playerScoreTxtLbl.setFont(labelFont);
        HBox playerScoreBox = new HBox();
        playerScoreBox.getChildren().addAll(playerScoreTxtLbl, playerScoreLbl);

        VBox playerInfoBox = new VBox();
        playerInfoBox.setPadding(padding);
        playerInfoBox.setStyle("-fx-background-color: #FFFFFF;");
        playerInfoBox.getChildren().addAll(playerLbl, playerScoreBox);

        BorderPane housePane = new BorderPane();
        housePane.setLeft(houseInfoBox);
        housePane.setCenter(houseCardsPane);

        BorderPane playerPane = new BorderPane();
        playerPane.setLeft(playerInfoBox);
        playerPane.setCenter(playerCardsPane);

        table.getChildren().addAll(housePane, playerPane);

        game = new TwentyOneGame();
        initGame();

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #7BBEFF;");
        root.getChildren().addAll(topBar, table, bottomBar);

        Scene scene = new Scene(root, 720, 404);
        stage.setTitle("Twenty-One");
        stage.getIcons().add(LOGO_IMG);
        stage.setScene(scene);
        stage.show();
    }

    private static ImageView newCardImageView(Card c)
    {
        ImageView iv = new ImageView();
        iv.setFitWidth(CARD_FIT_WIDTH);
        iv.setFitHeight(CARD_FIT_HEIGHT);
        showCard(iv, c);
        return iv;
    }

    private void updatePlayerScore()
    {
        playerScore = game.getPlayerScore();
        playerScoreLbl.setText(String.valueOf(playerScore));
    }

    private void initGame()
    {
        game.newGame();
        houseCardsPane.getChildren().clear();
        playerCardsPane.getChildren().clear();

        for (Card c : game.getHouseCards())
        {
            ImageView iv = newCardImageView(c);
            houseCardsPane.getChildren().add(iv);
        }

        for (Card c : game.getPlayerCards())
        {
            ImageView iv = newCardImageView(c);
            playerCardsPane.getChildren().add(iv);
        }

        houseScoreLbl.setText("   ");
        updatePlayerScore();
    }

    private void newGame()
    {
        game.newGame();
        initGame();
        messageLbl.setText("");
        hitBtn.setDisable(false);
        standBtn.setDisable(false);
    }

    private void hit()
    {
        if (!game.isOver())
        {
            Card c = game.hit();

            if (c != null)
            {
                ImageView iv = newCardImageView(c);
                playerCardsPane.getChildren().add(iv);
            }

            updatePlayerScore();

            if (game.isOver()) housePlay();
        }
    }

    private void housePlay()
    {
        ArrayList<Card> houseCards = game.getHouseCards();
        ObservableList<Node> children = houseCardsPane.getChildren();

        int i = 0;

        while (i < children.size())
        {
            showCard((ImageView)children.get(i), houseCards.get(i));
            i++;
        }

        while (i < houseCards.size())
        {
            ImageView iv = newCardImageView(houseCards.get(i));
            houseCardsPane.getChildren().add(iv);
            i++;
        }

        int houseScore = game.getHouseScore();
        houseScoreLbl.setText(String.valueOf(houseScore));

        if (game.isOver()) gameOverMsg();
    }


    private void stand()
    {
        if (game.isOver()) return;

        game.stand();
        housePlay();
    }

    private void gameOverMsg()
    {
        if (game.playerWins())
        {
            messageLbl.setText("Congratulations Player 1, you win!");
        }
        else
        {
            if (playerScore > TwentyOneGame.TARGET_SCORE)
            {
                messageLbl.setText("Player 1 went bust. The house wins.");
            }
            else
            {
                messageLbl.setText("The house wins.");
            }
        }

        hitBtn.setDisable(true);
        standBtn.setDisable(true);
    }

    private static int getCardImgCol(Card c) // 1st column is index 0
    {
        return c.getRank().getValue() - 1;
    }

    private static int getCardImgRow(Card c) // 1st row is index 0
    {
        switch (c.getSuit())
        {
            case SPADES: return 0;
            case HEARTS: return 1;
            case DIAMONDS: return 2;
            case CLUBS: return 3;
            default: return 0; // This case should never happen
        }
    }

    // get the rectangular portion of CARDS_IMG for Card c
    private static Rectangle2D getCardImgRect(Card c)
    {
        int hpos = (CARD_IMG_WIDTH + 1) * getCardImgCol(c) + 1;
        int vpos = (CARD_IMG_HEIGHT + 1) * getCardImgRow(c) + 1;
        return new Rectangle2D(hpos, vpos, CARD_IMG_WIDTH, CARD_IMG_HEIGHT);
    }

    // Show a card in an image view
    private static void showCard(ImageView iv, Card c)
    {
        if (c.isFaceUp())
        {
            iv.setImage(CARDS_IMG);
            iv.setViewport(getCardImgRect(c));
        }
        else
        {
            iv.setImage(CARD_BACK_IMG);
            iv.setViewport(
                    new Rectangle2D(0, 0, CARD_IMG_WIDTH, CARD_IMG_HEIGHT));
        }
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}