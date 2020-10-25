package TicTacToee;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton resetBtn = new JButton();

    JButton button[][] = new JButton[4][4];
    String turn = "Zero";
    JOptionPane jOptionPane = new JOptionPane();

    // Constructuor
    TicTacToe() {
        frame.setSize(1000, 1030);
        label.setText("Tic Tac Toe");
        label.setFont(label.getFont().deriveFont(24f));
        label.setBounds(300, 10, 200, 30);
        resetBtn.setText("Reset");
        resetBtn.setBounds(600, 10, 100, 30);
        // height = 30 + x
        int x = 25;
        int y = 55; // -30
        int width = 300;
        int heignt = 300;
        for (int i = 1; i <= 3; i++) {
            x = 25;
            for (int j = 1; j <= 3; j++) {
                button[i][j] = new JButton();
                button[i][j].setText("Empty");
                button[i][j].setBounds(x, y, width, heignt);
                button[i][j].setFont(button[i][j].getFont().deriveFont(36f));
                button[i][j].addActionListener(buttonClick);
                x += 325;
                frame.add(button[i][j]);
            }
            y += 325;
        }

        // adding items
        frame.add(label);
        frame.add(resetBtn);
        resetBtn.addActionListener(resetGameListener);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    // Action Listeners
    ActionListener resetGameListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetGame();
        }

    };

    ActionListener buttonClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("Zero") || b.getText().equals("Cross"))
                return;
            b.setText(turn);
            boolean turnWin = checkWinningCondition(turn);
            if (turnWin == true) {
                System.out.println("Win Win");
                jOptionPane.showMessageDialog(frame, turn + " has won");
                resetGame();
            }
            if (turn.equals("Zero"))
                turn = "Cross";
            else
                turn = "Zero";

        }

    };

    // Game Necessary Functions
    private void resetGame() {
        turn = "Zero";
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++)
                button[i][j].setText("Empty");
        }
    }

    private boolean checkWinningCondition(String turn) {
        int count = 0;
        for (int j = 1; j <= 3; j++) {
            count = 0;
            for (int i = 1; i <= 3; i++) {
                if (button[j][i].getText().equals(turn))
                    count++;
            }
            if (count == 3)
                return true;
            count = 0;
            for (int i = 1; i <= 3; i++) {
                if (button[i][j].getText().equals(turn))
                    count++;
            }
            if (count == 3)
                return true;
        }
        count = 0;
        for (int i = 1; i <= 3; i++) {
            if (button[i][i].getText().equals(turn))
                count++;
        }
        if (count == 3)
            return true;
        if (button[1][3].getText().equals(turn) && button[2][2].getText().equals(turn)
                && button[3][1].getText().equals(turn))
            return true;

        return false;
    }

}
