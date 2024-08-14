public class CommandPatternTest {
    public static void main(String[] args) {
        
        Light livingRoomLight = new Light();

        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Creating object of Remote Control
        RemoteControl remote = new RemoteControl();

        // Test turning on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Test turning off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
