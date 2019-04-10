package frc.team3006.Sensors;
import frc.team3006.Network.*;

public class VisionTracker {

	private static VisionTracker visionTracker = null;

	private VisionTracker() {}
	
	public static VisionTracker getInstance() {
		if(visionTracker == null) {
			visionTracker = new VisionTracker();
		}
		return visionTracker;
	}

	public double getTurnAmount() {
		/*String direction = RobotNetwork.direction.getString("no direction - very bad");
		if(direction.equalsIgnoreCase("l")) {
	  		return "l";
		} else if(direction.equalsIgnoreCase("r")) {
	    	return "r";
		} else if(direction.equalsIgnoreCase("f")) {
	     	return "f";
		} else {
			return "";
		}*/
		double turnAmount = RobotNetwork.direction.getDouble(0);
		return turnAmount;
	}
	
}