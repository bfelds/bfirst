
//package tells the program what "package" of files has the
//robot code
package edu.wpi.first.wpilibj.templates;

//import tells the program which components we'll need information on
//import all information about "Joystick" for example
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;


//this is your robot, say hi to "BasicRobot"
//hmmm...maybe it needs a better name
//anyways extends is a quick way of saying BasicRobot has a
//parent named "SimpleRobot"
public class BasicRobot extends SimpleRobot {

    /*
     * after we've named our robot, it's time to 
     * say what parts it has:
     */
    
    /*
     * first it has a drive train, here called "RobotDrive"
     * our BasicRobot has 2 motors, it's left motor is plugged
     * into the digital sidecar port 1, and the right into port 2
     */
    RobotDrive robotDrive = new RobotDrive(1,2);
    /*
     * Later when we want to add more parts we'll put them here!
     */
    
    /*
     * Now that we know what the robot is made of, it's time
     * to tell our program how we will be controlling it!
     * We plugged in 2 joysticks into the computer in usb ports 1
     * and 2, so below we'll tell the program about them.
     */
    Joystick leftJoystick = new Joystick(1);
    Joystick rightJoystick = new Joystick(2);
    
    
    /*
     * Now it's time to get started!! Quite literally in fact.
     * When you turn on your robot, it likes to first thing about itself!
     * The below function is called a "constructor", but simply, it's
     * the first code to run when you start the robot.
     */
    public BasicRobot(){
        /*
         * What's a watchdog? What's going on? This is a safety
         * (SAFETY FIRST) thing. Let's cover it a little later. 
         */
        this.getWatchdog().setEnabled(true);
        this.getWatchdog().setExpiration(.5);
    }
    
    /**
     * Autonomous mode! Finally something that we've heard before!
     * 
     */
    public void autonomous() {
        /*
         * Once the referees start the match, the code inside of these curly
         * braces will run. 
         */
    }

    /**
     * Now that autonomous mode is over, it's time to start driving!
     * In Operator Control, we'll place all the code we need during
     * the rest of the round. 
     */
    public void operatorControl() {        
        while(this.isEnabled() && this.isOperatorControl()) {
            /*
             * "while" is a type of "loop"
             * so for now the above says:
             * "while the round is enabled and we're in operator control mode
             * lets keep running the code inside this block in a loop"
             */
            
            /* the first and most important part of a robot in operator
             * mode is to drive!
             * So the next line tells the drive train the current
             * positions of the left and right joystick.
             * So the next line says "Hey robotDrive, please drive
             * in the style of tankDrive (4-wheel drive), using the
             * current positions of the left and right joystick"
             */
            robotDrive.tankDrive(leftJoystick, rightJoystick);
            
            /*
             * So this while loop says...
             * "If the round is enabled and it we are in operator control
             * lets tell the robot to drive...
             * and if the round is enabled and if we are in operator control
             * lets tell the robot to drive...
             * and IF THE round is enabled and if we are in operator control
             * lets tell the robot to drive...
             * and so on and so forth, until the round is over! then
             * the loop is over and we're done!
             */
        }

    }
}
