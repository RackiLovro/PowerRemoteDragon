package remote;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public static Map<String, Control> getButtons() {
        Map<String, Control> buttons = new HashMap<>();
        buttons.put("⚡", new Control(() -> executeADBCommand("adb shell am start -a android.intent.action.ACTION_REQUEST_SHUTDOWN"), 412, 330));
        buttons.put("⚙", new Control(() -> executeADBCommand("adb shell am start -a android.settings.SETTINGS"), 532, 330));
        
        buttons.put("↑", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_UP"), 412, 390));
        buttons.put("↓", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_DOWN"), 472, 390));
        buttons.put("←️", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_LEFT"), 532, 390));

        buttons.put("→️", new Control(() -> executeADBCommand("adb shell input keyevent DPAD_RIGHT"), 412, 470));
        buttons.put("✓", new Control(() -> executeADBCommand("adb shell input keyevent ENTER"), 472, 470));
        buttons.put("⌂", new Control(() -> executeADBCommand("adb shell input keyevent HOME"), 532, 470));

        buttons.put("1", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_1"), 412, 550));
        buttons.put("2", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_2"), 472, 550));
        buttons.put("3", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_3"), 532, 550));

        buttons.put("4", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_4"), 412, 630));
        buttons.put("5", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_5"), 472, 630));
        buttons.put("6", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_6"), 532, 630));

        buttons.put("7", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_7"), 412, 710));
        buttons.put("8", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_8"), 472, 710));
        buttons.put("9", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_9"), 532, 710));

        buttons.put("0", new Control(() -> executeADBCommand("adb shell input keyevent KEYCODE_0"), 412, 790));
        buttons.put("🔊", new Control(() -> executeADBCommand("adb shell input keyevent VOLUME_UP"), 472, 790));
        buttons.put("🔉", new Control(() -> executeADBCommand("adb shell input keyevent VOLUME_DOWN"), 532, 790));
        
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
