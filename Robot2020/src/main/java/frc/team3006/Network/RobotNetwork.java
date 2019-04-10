package frc.team3006.Network;
import edu.wpi.first.networktables.*;

public class RobotNetwork {
	private static NetworkTable table;
	public static NetworkTableEntry camMode, direction;

	private static RobotNetwork network = null;
	
	private RobotNetwork() {}
	
	public static RobotNetwork initNetwork() {
		if(network == null) {
			network = new RobotNetwork();
			table = NetworkTableInstance.getDefault().getTable("SmartDashboard");
			direction = table.getEntry("dir");
		}
		return network;

	}
	
}