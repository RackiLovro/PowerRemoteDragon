package remote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Remote {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Remote::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("STB Remote Emulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setSize(1000, 1000);

        BackgroundPanel back = new BackgroundPanel(new ImageIcon("sm.png"));
        back.setBackground(new Color(0, 0, 0, 0));
        back.setLayout(null);

        // Add buttons
        Configuration.getButtons().forEach((text, button) -> addButton(back, text, button));

        // Enable window dragging
        makeWindowDraggable(frame);

        frame.setContentPane(back);
        frame.setVisible(true);
    }

    private static void addButton(JPanel panel, String text, Control remoteButton) {
        ImageIcon buttonIcon = new ImageIcon("button.png");  // Load the button image
        JButton button = new JButton(text);  // Keep the text as the button label
        button.setIcon(buttonIcon);  // Set the image as the button icon
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setBounds(remoteButton.getX(), remoteButton.getY(), 50, 50);  // Same size as before
        button.addActionListener(e -> {
            try {
            	throw new RuntimeException("This is a test error.");
                //remoteButton.execute();  // Try executing the ADB command or whatever logic you have
            } catch (Exception ex) {
                showErrorDialog(ex.getMessage());  // Show error if an exception occurs
            }
        });
        panel.add(button);
    }

    // Method to enable dragging
    private static void makeWindowDraggable(JFrame frame) {
        final Point[] initialClick = new Point[1];

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick[0] = e.getPoint();
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getX() - initialClick[0].x;
                int deltaY = e.getY() - initialClick[0].y;
                Point p = frame.getLocation();
                frame.setLocation(p.x + deltaX, p.y + deltaY);
            }
        });
    }

    // Method to display error in a floating window
    private static void showErrorDialog(String errorMessage) {
        JDialog errorDialog = new JDialog();
        errorDialog.setTitle("Error");
        errorDialog.setSize(300, 150);
        errorDialog.setLocationRelativeTo(null); // Center the dialog

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea(errorMessage);
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> errorDialog.dispose());
        panel.add(closeButton, BorderLayout.SOUTH);

        errorDialog.setContentPane(panel);
        errorDialog.setVisible(true);
    }

    static class BackgroundPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon icon;

        public BackgroundPanel(ImageIcon icon) {
            this.icon = icon;
            setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (this.icon != null) {
                g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}
