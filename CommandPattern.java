/**
 * The Command Pattern encapsulates a request as an object, thereby letting you parameterize
 * other objects with different requests, queue or log requests, and support undoable operations.
 */

interface Command {
    public void execute();
}

class Light {
    public void on() {
	System.out.println("Light is on.");
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
	this.light = light;
    }

    public void execute() {
	light.on();
    }
}

class SimpleRomoteControl {
    Command slot;

    public SimpleRomoteControl() {}

    public void setCommand(Command command) {
	slot = command;
    }

    public void buttonWasPressed() {
	slot.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
	SimpleRomoteControl remote = new SimpleRomoteControl();
	LightOnCommand lightOn = new LightOnCommand(new Light());
	remote.setCommand(lightOn);
	remote.buttonWasPressed();
    }
}
