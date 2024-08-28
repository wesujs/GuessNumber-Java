package objectz.testingGrounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import objectz.testedObjects.RandomNumber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{

    // Holds randomly Generated Answer
    int answer;
    String guessEntry = "0";
    int strikesCount = 0;
    RandomNumber rng = new RandomNumber();

    private JLabel label1;
    private JLabel label2;
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JButton button1;
    private JButton button2;

    public GUI() {

        answer = rng.randNumberGen();
        // frame specifications
        frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calculate the new font size based on the window's width and height
                int frameWidth = frame.getWidth();
                int frameHeight = frame.getHeight();
                int newSize = Math.min(frameWidth, frameHeight) / 20;
    
                // Update the label's font size
                label1.setFont(new Font("Arial", Font.PLAIN, newSize));
                label2.setFont(new Font("Arial", Font.PLAIN, newSize));
                textField.setFont(new Font("Arial", Font.PLAIN, newSize));
            }
        });

        panel = new JPanel();

        button1 = new JButton("Guess");
        button1.addActionListener(this);

        // button2 = new JButton("Start");
        // button2.addActionListener(this);
        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);

        label1 = new JLabel("Strikes: 0", SwingConstants.CENTER);
        label2 = new JLabel("Lets get the guesses going.", SwingConstants.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(4, 1));
        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(button1);
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Testing GUI");
        frame.setVisible(true);

        // Array of messages to display with delays
        String[] messages = {
            "Boom! you guessed it right!",
            "Restarting.",
            "Restarting..",
            "Restarting...",
            "Let's get this started again."
        };

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        int convertGuess = Integer.parseInt(guessEntry);

        guessEntry = textField.getText();
        strikesCount++;
        label1.setText("Strikes: " + strikesCount);

        if (convertGuess < answer) {
            label2.setText("Your guess is lower than the right number.");
        }

        if (convertGuess > answer) {
            label2.setText("Your guess is higher than the right number.");
        }
        if (convertGuess == answer) {
            strikesCount = 0;
            label1.setText("Strikes: " + strikesCount);
            
    
                label2.setText("Boom! you guessed it right!");

    


                label2.setText("Restarting.");

            

                label2.setText("Restarting..");

            

                label2.setText("Restarting...");



                label2.setText("Lets get this started again.");

            answer = rng.randNumberGen();
        } 
        if (strikesCount == 3 & convertGuess != answer) {
            label2.setText("Out of guesses! Answer was: " + answer);

            strikesCount = 0;
            answer = rng.randNumberGen();
            label1.setText("Strikes: " + strikesCount);
            label2.setText("Let's try again! Enter a new guess.");
        }

        textField.setText("");
    }
}
