import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {
    public FortuneTellerFrame() {
        JTextArea textArea = new JTextArea();
        setTitle("Fortune Teller");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new TopPanel();
        JPanel middlePanel = new MiddlePanel(textArea);
        JPanel bottomPanel = new BottomPanel(textArea);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static class TopPanel extends JPanel {
        public TopPanel() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Fortune Teller!", JLabel.CENTER);
            ImageIcon icon = new ImageIcon("src/download.jpg");
            label.setIcon(icon);

            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            add(label, BorderLayout.CENTER);
        }
    }

    public static class MiddlePanel extends JPanel {
        public MiddlePanel(JTextArea textArea) {
            setLayout(new BorderLayout());
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            add(scrollPane, BorderLayout.CENTER);
        }
    }

    public static class BottomPanel extends JPanel {
        public BottomPanel(JTextArea textArea) {
            setLayout(new FlowLayout());
            JButton fortuneButton = new JButton("Read my fortune!");
            JButton quitButton = new JButton("Quit!");

            fortuneButton.addActionListener(e -> {
                textArea.append(getRandomFortune() + System.lineSeparator());
                textArea.setCaretPosition(textArea.getDocument().getLength());
            });
            quitButton.addActionListener(e -> {
                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to quit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });

            add(fortuneButton);
            add(quitButton);
        }

        private String getRandomFortune() {
            String[] fortunes = {
                    "You will have a great day!",
                    "A surprise is waiting for you.",
                    "Good news is on the way.",
                    "You will meet someone special.",
                    "Your hard work will pay off.",
                    "An exciting opportunity is coming.",
                    "You will find something you lost.",
                    "A new adventure awaits you.",
                    "You will achieve your goals.",
                    "Happiness is around the corner.",
                    "You will make a new friend soon.",
                    "Your dreams will come true.",
                    "You will receive a compliment today.",
                    "A pleasant surprise is in store for you.",
                    "You will discover a hidden talent.",
                    "Your positive attitude will attract good things.",
                    "You will have a chance to travel.",
                    "You will find joy in simple things.",
                    "Your kindness will be rewarded.",
                    "You will have a lucky day!",
                    "You will trip over nothing and laugh about it.",
                    "You will find a new hobby that you love.",
                    "You will have a delicious meal soon.",
                    "You will receive an unexpected gift.",
                    "You will have a great conversation with a stranger.",
                    "You will find beauty in the world around you.",
                    "You will have a moment of clarity that leads to success.",
                    "You will make a positive impact on someone's life."
            };
            int index = (int) (Math.random() * fortunes.length);
            return fortunes[index];
        }
    }

    public static void main(String[] args) {
        new FortuneTellerFrame();
    }
}
