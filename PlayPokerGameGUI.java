import PJ3.Card;
import PJ3.VideoPoker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayPokerGameGUI {
    private VideoPoker game = new VideoPoker();
    private JFrame frame =new JFrame();
    private JLabel balanceText = new JLabel();
    private JLabel resultText = new JLabel();
    private JTextField betInput = new JTextField();

    private JCheckBox[] cardCheckboxes = new JCheckBox[5];

    public PlayPokerGameGUI() {
        frame.setSize(400,500);
        frame.setLayout(null);

        // balance text
        balanceText.setBounds(30,50,100, 40);
        frame.add(balanceText);

        // result text
        resultText.setBounds(280,50,100, 40);
        resultText.setText("new game");
        frame.add(resultText);

        // bet input field
        JLabel betLabel = new JLabel();
        betLabel.setBounds(130,50,60, 40);
        betLabel.setText("Bet:");
        frame.add(betLabel);
        betInput.setBounds(160,50,100, 40);
        frame.add(betInput);

        for (int i = 0; i < 5; i++) {
            cardCheckboxes[i] = new JCheckBox();
            cardCheckboxes[i].setBounds(10, 200 + 50 * i, 150, 40);
            cardCheckboxes[i].setText("card " + (i+1));
            frame.add(cardCheckboxes[i]);
        }

        // start button
        JButton resetButton = new JButton("start");
        resetButton.setBounds(30,100,100, 40);
        resetButton.addActionListener((e) -> {
            game.start(Integer.parseInt(betInput.getText()));
            show();
        });
        frame.add(resetButton);

        // replace button
        JButton playButton = new JButton("replace");
        playButton.setBounds(130,100,100, 40);
        playButton.addActionListener((e) -> {
            List<Integer> keep = new ArrayList<>();
            for (int i = 0; i < cardCheckboxes.length; i++) {
                if (cardCheckboxes[i].isSelected()) {
                    keep.add(i);
                }
            }
            String result = game.replace(keep);
            show();
            resultText.setText(result);
        });
        frame.add(playButton);
    }

    public void show() {
        balanceText.setText("Balance: " + game.getBalance());
        List<Card> cards = game.getCards();
        for (int i = 0; i < cardCheckboxes.length; i++) {
            cardCheckboxes[i].setText(cards.get(i).toString());
        }
    }

    public void run() {
        frame.setVisible(true);

        // show balance
        balanceText.setText("Balance: " + game.getBalance());

    }

    public static void main(String[] args) {
        PlayPokerGameGUI ui = new PlayPokerGameGUI();
        ui.run();
    }
}