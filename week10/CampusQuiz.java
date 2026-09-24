import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class CampusQuiz extends JFrame implements ActionListener {
    private final QuestionBank bank;
    private int index;
    private int score;
    private boolean locked;

    private JLabel progressLabel;
    private JLabel scoreLabel;
    private JLabel promptLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionGroup;
    private JButton checkButton;
    private JButton nextButton;
    private JTextArea feedbackArea;

    public CampusQuiz() {
        super("BIT1123 OOP Quiz - Hamza Gohar");
        bank = new QuestionBank();
        index = 0;
        score = 0;
        locked = false;
        buildWindow();
        showCurrentQuestion();
    }

    private void buildWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 460);
        setLocationRelativeTo(null);

        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBorder(BorderFactory.createEmptyBorder(12, 16, 8, 16));
        JLabel title = new JLabel("Campus OOP Quiz");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        progressLabel = new JLabel("Question");
        scoreLabel = new JLabel("Score: 0");
        JPanel status = new JPanel(new GridLayout(1, 2));
        status.add(progressLabel);
        status.add(scoreLabel);
        header.add(title);
        header.add(status);

        JPanel centre = new JPanel(new BorderLayout(0, 10));
        centre.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        promptLabel = new JLabel(" ");
        promptLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        centre.add(promptLabel, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(4, 1, 0, 6));
        optionButtons = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
            optionGroup.add(optionButtons[i]);
            options.add(optionButtons[i]);
        }
        centre.add(options, BorderLayout.CENTER);

        JPanel footer = new JPanel(new BorderLayout(0, 8));
        footer.setBorder(BorderFactory.createEmptyBorder(0, 16, 12, 16));
        JPanel buttons = new JPanel();
        checkButton = new JButton("Check answer");
        nextButton = new JButton("Next question");
        JButton restartButton = new JButton("Restart");
        checkButton.addActionListener(this);
        nextButton.addActionListener(this);
        restartButton.addActionListener(this);
        buttons.add(checkButton);
        buttons.add(nextButton);
        buttons.add(restartButton);
        feedbackArea = new JTextArea(3, 40);
        feedbackArea.setEditable(false);
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        footer.add(buttons, BorderLayout.NORTH);
        footer.add(feedbackArea, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);
        add(centre, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private void showCurrentQuestion() {
        Question question = bank.get(index);
        progressLabel.setText("Question " + (index + 1) + " of " + bank.size());
        scoreLabel.setText("Score: " + score + " / " + bank.size());
        promptLabel.setText(question.getPrompt());
        String[] options = question.getOptions();
        optionGroup.clearSelection();
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText((char) ('A' + i) + ". " + options[i]);
            optionButtons[i].setEnabled(true);
        }
        locked = false;
        checkButton.setEnabled(true);
        nextButton.setEnabled(false);
        feedbackArea.setText("Pick one answer, then press Check answer.");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Check answer")) {
            checkAnswer();
        } else if (command.equals("Next question")) {
            goNext();
        } else if (command.equals("Restart")) {
            index = 0;
            score = 0;
            showCurrentQuestion();
        }
    }

    private void checkAnswer() {
        if (locked) {
            return;
        }
        int selected = selectedIndex();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "Select an answer first.");
            return;
        }

        Question question = bank.get(index);
        locked = true;
        checkButton.setEnabled(false);
        for (JRadioButton button : optionButtons) {
            button.setEnabled(false);
        }

        if (question.isCorrect(selected)) {
            score++;
            feedbackArea.setText("Correct.");
        } else {
            char letter = (char) ('A' + question.getCorrectIndex());
            feedbackArea.setText("Not quite. The answer is " + letter + ".");
        }
        scoreLabel.setText("Score: " + score + " / " + bank.size());

        if (index == bank.size() - 1) {
            nextButton.setEnabled(false);
            JOptionPane.showMessageDialog(
                    this,
                    "Quiz finished.\nScore: " + score + " out of " + bank.size() + ".",
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            nextButton.setEnabled(true);
        }
    }

    private void goNext() {
        if (index < bank.size() - 1) {
            index++;
            showCurrentQuestion();
        }
    }

    private int selectedIndex() {
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CampusQuiz quiz = new CampusQuiz();
                quiz.setVisible(true);
            }
        });
    }
}
