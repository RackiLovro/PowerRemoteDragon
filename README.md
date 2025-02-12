# Power Remote Dragon - STB Remote Emulator

Power Remote Dragon is a proof of concept for an **STB (Set-Top Box) Remote Emulator** designed in the shape of a dragon, leveraging Java's Swing library to create a unique, interactive user interface. This project demonstrates the capability of controlling an STB remotely by simulating button presses using ADB commands.

## Features
- **Customizable UI**: The remote emulator is designed to mimic the shape of a dragon, with buttons placed around its body. You can customize the button placement and UI elements.
- **ADB Integration**: The emulator sends ADB commands to the connected device to simulate key presses like navigating through menus or adjusting volume.
- **Draggable Window**: The window is transparent and can be freely dragged across the screen.
- **Proof of Concept**: Currently, the application demonstrates basic functionality and can be extended for additional features.

## Requirements
- Java Development Kit (JDK) 8 or higher
- Android Debug Bridge (ADB) installed and set up
- A connected Android device for sending ADB commands

## Setup and Usage

### 1. Clone the repository:
```
git clone https://github.com/yourusername/power-remote-dragon.git
cd power-remote-dragon
```

##2. Build the project:
You can build the project using any Java IDE (e.g., IntelliJ IDEA, Eclipse) or via command line:

```
javac remote/Remote.java remote/Control.java remote/Configuration.java
```

##3. Run the application:
To run the Power Remote Dragon, simply execute the following:

```
java remote.Remote
```
This will launch the STB remote emulator, and you'll see a window with a transparent background shaped like a dragon.

##4. ADB Setup:
Make sure ADB is correctly installed and your device is connected:

Enable Developer Options and USB Debugging on your Android device.
Verify the connection with adb devices.

##5. Customizing the Remote:
You can modify the positions of the buttons by changing the x and y coordinates in the Configuration.getButtons() method.
You can add or remove buttons as needed to match the remote layout for your device.
Screenshots

TODO
Add support for more button actions.
Improve error handling and ADB command execution.
Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests for improvements.

License
This project is licensed under the MIT License - see the LICENSE file for details.
