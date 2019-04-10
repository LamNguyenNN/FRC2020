package frc.team3006.Mechanisms;

import java.util.List;
import java.util.ArrayList;
import edu.wpi.first.wpilibj.Victor;

public class Mechanism {

    private static List<Integer> used_pwm = new ArrayList<Integer>();
    private List<Victor> mech_victor = new ArrayList<Victor>();

    public Mechanism(int... pwm_port) {
        for(int i : pwm_port) {
            if(used_pwm.contains(i)) {
                System.out.println("PWM: " + i + " is being used. Please choose a different pwm.");
            } else {
                used_pwm.add(i);
                mech_victor.add(new Victor(i));
            }
        }
    }
    
    public void setVictorAll(double motorVal) {
        for(Victor i : mech_victor) {
            i.set(motorVal);
        }
    }

    public void setVictorSpecific(int pwm_port, double motorVal) {
        mech_victor.get(pwm_port).set(motorVal);
    }

    public void stop() {
        for(Victor i : mech_victor) {
            i.set(0);
        }
    }

}