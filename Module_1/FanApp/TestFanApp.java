package Module_1.FanApp;

public class TestFanApp {
    public static void main(String[] args) {
        //default fan is STOPPED
        Fan defaultFan = new Fan();
        //I wanted to use all the constants I declared in the assignment, I was not sure if it is supposed to be randomized or not
        Fan slowFan = new Fan(Fan.SLOW, true, 7, "Green");
        Fan mediumFan = new Fan(Fan.MEDIUM, true, 8, "Blue");
        Fan fastFan = new Fan(Fan.FAST, true, 10, "Red");

        //show results
        System.out.println(defaultFan.toString());
        System.out.println(slowFan.toString());
        System.out.println(mediumFan.toString());
        System.out.println(fastFan.toString());

    }
}
