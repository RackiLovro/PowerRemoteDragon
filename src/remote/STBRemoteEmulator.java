package remote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class STBRemoteEmulator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(STBRemoteEmulator::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("STB Remote Emulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 3));

        String[][] buttonLayout = {
                {"", "UP", ""},
                {"LEFT", "OK", "RIGHT"},
                {"", "DOWN", ""},
                {"VOL-", "HOME", "VOL+"},
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"", "0", ""}
        };

        for (String[] row : buttonLayout) {
            for (String label : row) {
                if (!label.isEmpty()) {
                    JButton button = new JButton(label);
                    button.addActionListener(new ButtonActionListener(label));
                    frame.add(button);
                } else {
                    frame.add(new JLabel());
                }
            }
        }

        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(e -> System.out.println("adb shell input text '" + inputField.getText() + "'"));

        frame.add(inputField);
        frame.add(sendButton);

        frame.pack();
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    private static class ButtonActionListener implements ActionListener {
        private final String command;

        public ButtonActionListener(String command) {
            this.command = command;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String adbCommand = "adb shell input keyevent " + getADBKey(command);
            System.out.println(adbCommand);
            //this.executeADBCommand(adbCommand);
        }

        private String getADBKey(String button) {
            switch (button) {
                case "UP": return "DPAD_UP";
                case "DOWN": return "DPAD_DOWN";
                case "LEFT": return "DPAD_LEFT";
                case "RIGHT": return "DPAD_RIGHT";
                case "OK": return "ENTER";
                case "HOME": return "HOME";
                case "VOL+": return "VOLUME_UP";
                case "VOL-": return "VOLUME_DOWN";
                case "1": return "KEYCODE_1";
                case "2": return "KEYCODE_2";
                case "3": return "KEYCODE_3";
                case "4": return "KEYCODE_4";
                case "5": return "KEYCODE_5";
                case "6": return "KEYCODE_6";
                case "7": return "KEYCODE_7";
                case "8": return "KEYCODE_8";
                case "9": return "KEYCODE_9";
                case "0": return "KEYCODE_0";
                default: return "UNKNOWN";
            }
        }
        
        private void executeADBCommand(String command) {
            try {
                System.out.println("Executing: " + command); // Debugging output
                Process process = Runtime.getRuntime().exec(command);
                process.waitFor(); // Wait for the command to complete

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
