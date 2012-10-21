
/*This is the same project from BasicRobot.java but
 *this time we'll discuss the Watchdog!
 *So what is the watchdog? 
 *The watchdog is there to make sure our robot operates
 *safely. Basically, every once in a while, we need to tell the 
 *watchdog that we are doing okay in our program, or the watchdog 
 *will shut down the robot. 
 *This is helpful, for instance if our program malfunctions and gets 
 *stuck, the watchdog will shut down the robot so that the motors or 
 *pneumantics don't go haywire!
 *Remember safety FIRST, and the watchdog is ALLLL about safety. 
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;

public class BasicRobot extends SimpleRobot {

    RobotDrive robotDrive = new RobotDrive(1,2);

    Joystick leftJoystick = new Joystick(1);
    Joystick rightJoystick = new Joystick(2);
    
    public BasicRobot(){
        /*
         * This is the first place we'll use the watchdog, now you'll
	 * need to write the below lines (they don't happen automatically).
	 * There are 2 things we can do with the watchdog:
 	 * 1. Turn it on and off
	 * 2. Feed it!
         */
	    //This is how we turn it off
        this.getWatchdog().setEnabled(false);
	    //This is how we turn it on
        this.getWatchdog().setEnabled(true);
	    //Let's leave it on for now
		
    }
    
    public void autonomous() {
        /*
         * Here we turn off the watchdog, but we'll cover why
         * we do this in the later tutorial on autonomous mode.
         */
	    this.getWatchdog().setEnabled(false);
    }

    public void operatorControl() {        
        this.getWatchdog().setEnabled(true); //ignore
        while(this.isEnabled() && this.isOperatorControl()) {
	    this.getWatchdog().feed(); //ignore
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
