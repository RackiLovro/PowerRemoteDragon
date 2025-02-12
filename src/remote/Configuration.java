package remote;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public static Map<String, Control> getButtons() {
        Map<String, Control> buttons = new HashMap<>();
        buttons.put("↑", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_UP"), 410, 400));
        buttons.put("↓", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_DOWN"), 470, 400));
        buttons.put("←️", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_LEFT"), 530, 400));

        buttons.put("→️", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_RIGHT"), 410, 480));
        buttons.put("✓", new Control(() -> executeADBCommand("adb shell input keyevent ENTER"), 470, 480));
        buttons.put("⌂", new Control(() -> executeADBCommand("adb shell input keyevent HOME"), 530, 480));

        buttons.put("1", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_1"), 410, 560));
        buttons.put("2", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_2"), 470, 560));
        buttons.put("3", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_3"), 530, 560));

        buttons.put("4", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_4"), 410, 640));
        buttons.put("5", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_5"), 470, 640));
        buttons.put("6", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_6"), 530, 640));

        buttons.put("7", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_7"), 410, 720));
        buttons.put("8", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_8"), 470, 720));
        buttons.put("9", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_9"), 530, 720));

        buttons.put("0", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_0"), 410, 800));
        buttons.put("🔊", new Control(() -> executeADBCommand("adb shell input keyevent VOLUME_UP"), 470, 800));
        buttons.put("🔉", new Control(() -> executeADBCommand("adb shell input keyevent VOLUME_DOWN"), 530, 800));

        return buttons;
    }
    
    private static void executeADBCommand(String command) {
        try {
            System.out.println("Executing: " + command);
            //Process process = Runtime.getRuntime().exec(command);
            //process.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
