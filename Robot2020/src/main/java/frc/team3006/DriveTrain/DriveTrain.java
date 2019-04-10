package frc.team3006.DriveTrain;
import frc.team3006.Mechanisms.Mechanism;
import frc.team3006.Sensors.VisionTracker;

public class DriveTrain extends Mechanism{

	private int leftVictor1, leftVictor2, rightVictor1, rightVictor2;
	private double maxSpeed, targetVisionSpeed;
	private VisionTracker visionTracker;

	public DriveTrain(int leftVictor1, int leftVictor2, int rightVictor1, int rightVictor2, double maxSpeed) {
		super(leftVictor1, leftVictor2, rightVictor1, rightVictor2);
	
		this.leftVictor1 = leftVictor1;
		this.leftVictor2 = leftVictor2;
		this.rightVictor1 = rightVictor1;
		this.rightVictor2 = rightVictor2;

		this.maxSpeed = maxSpeed;

		this.targetVisionSpeed = 0.5;

		visionTracker = VisionTracker.getInstance();
	}
	
	public void drive(double leftMotorMove, double rightMotorMove) {
		super.setVictorSpecific(leftVictor1, leftMotorMove * -1 * maxSpeed);
		super.setVictorSpecific(leftVictor2, leftMotorMove * -1 * maxSpeed);
		super.setVictorSpecific(rightVictor1, rightMotorMove * maxSpeed);
		super.setVictorSpecific(rightVictor2, rightMotorMove * maxSpeed);
	}

	public void boost(double leftMotorMove, double rightMotorMove) {
		if(Math.signum(leftMotorMove) * -1 == Math.signum(rightMotorMove)) {
			leftMotorMove *= maxSpeed;
			rightMotorMove *= maxSpeed;
		}
		super.setVictorSpecific(leftVictor1, leftMotorMove * -1);
		super.setVictorSpecific(leftVictor2, leftMotorMove * -1);
		super.setVictorSpecific(rightVictor1, rightMotorMove);
		super.setVictorSpecific(rightVictor2, rightMotorMove);
	}

	public void reverse(double leftMotorMove, double rightMotorMove) {
		super.setVictorSpecific(leftVictor1, rightMotorMove * -1);
		super.setVictorSpecific(leftVictor2, rightMotorMove * -1);
		super.setVictorSpecific(rightVictor1, leftMotorMove);
		super.setVictorSpecific(rightVictor2, leftMotorMove);
	}

	public void driveByVision() {
		//String direction = visionTracker.getDirection();
		double turnAmount = visionTracker.getTurnAmount();
		double leftMotorMove = targetVisionSpeed + turnAmount;
		double rightMotorMove = targetVisionSpeed - turnAmount;
		drive(leftMotorMove, rightMotorMove); 

		/*if(direction.equalsIgnoreCase("l")) {
			drive(.15, -.3);
		} else if(direction.equalsIgnoreCase("r")) {
			drive(.3, -.15);
		} else if(direction.equalsIgnoreCase("f")) {
			drive(.3, -.3);
		} else {
			stop();
		}*/
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	
}