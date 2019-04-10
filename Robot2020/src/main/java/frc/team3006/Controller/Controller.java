package frc.team3006.Controller;
import edu.wpi.first.wpilibj.*;
import frc.team3006.DriveTrain.*;
import frc.team3006.Mechanisms.*;

public class Controller {
	
	private Joystick joystick;
	
	//Controller Variables
	final private int buttonA = 1;
	final private int buttonY = 4;
	final private int buttonX = 3;
	final private int buttonB = 2;
	final private int buttonLeftBumper = 5;
	final private int buttonRightBumper = 6;
	final private int leftXAxis = 0;
	final private int leftYAxis = 1;
	final private int rightXAxis = 4;
	final private int rightYAxis = 5;
	final private int leftTrigger = 2;
	final private int rightTrigger = 3;
	final private double triggerDeadZone = 0.05;

	//Drive Train Variables
	private DriveTrain driveTrain;
	private int driveTrainLeft1 = 1;
	private int driveTrainLeft2 = 2;
	private int driveTrainRight1 = 3;
	private int driveTrainRight2 = 4;
	private double maxSpeed = 0.6;
	private static boolean isDriver = false;
	
	//Linear slider
	private LinearSlider linearSlider;
	private int linearSliderPort = 5;

	public Controller(int port, boolean isDriver) {

		joystick = new Joystick(port);

		if(!Controller.isDriver && isDriver) {
			Controller.isDriver = isDriver;
		} else if (Controller.isDriver) {
			isDriver = false;
			System.out.println("Driver controller already created. This controller is connected to port: " + 
				port + " and will not have driver control");
		}

		if(isDriver) { 
			//Define only drive train here//
			driveTrain = new DriveTrain(driveTrainLeft1, driveTrainLeft2, driveTrainRight1, driveTrainRight2, maxSpeed);
		} else { 
			//Define all other mechanisms here
			driveTrain = null;
			linearSlider = new LinearSlider(linearSliderPort);
		}
	}
	
	public void drive() {
		if(isDriver) {
			double leftMotorMove = joystick.getRawAxis(leftYAxis);
			double rightMotorMove = joystick.getRawAxis(rightYAxis);
			if(joystick.getRawAxis(rightTrigger) > triggerDeadZone) {
				driveTrain.boost(leftMotorMove, rightMotorMove);
			} else {
				driveTrain.drive(leftMotorMove, rightMotorMove);
			}
		} else {
			System.out.println("Wrong controller. This is not the driver controller");
		}
	}

	public void driveByVision() {
		driveTrain.driveByVision();
	}

	public void runSlider() {
		if(!isDriver) {
			double sliderMotorMove = joystick.getRawAxis(rightYAxis);
			linearSlider.slide(sliderMotorMove);
		} else {
			System.out.println("Wrong controller. This is not the mechanisms controller");
		}
	}

	public void setMaxDriveSpeed(double val) {
		driveTrain.setMaxSpeed(val);
	}

}