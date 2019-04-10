package frc.team3006.Mechanisms;

public class LinearSlider extends Mechanism{
	
	private int limitedSlide;
	private double limit;
	
	public LinearSlider(int pwm_port) {
		super(pwm_port);
		limitedSlide = 0;
		limit = 0.025;
	}
	
	public void slide(double slideMotorVal) {
		double change = 0.0;
	    change = slideMotorVal - limitedSlide;
	    if (Math.abs(change) > limit)
	    {
	      int sign = (int)Math.signum(change);
	      change = limit * sign;
	    }

	    limitedSlide += change;
	    super.setVictorAll(limitedSlide);
	}
	
}