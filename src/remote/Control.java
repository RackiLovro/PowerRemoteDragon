package remote;

public class Control {
    private final Runnable command;
    private final int x;
    private final int y;

    public Control(Runnable command, int x, int y) {
        this.command = command;
        this.x = x;
        this.y = y;
    }

    public void execute() {
        command.run();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
