/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team3006.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.team3006.Controller.*;
import frc.team3006.Network.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  Controller driver, mech;
  RobotNetwork network;

  @Override
  public void robotInit() {
    driver = new Controller(0, true);
    mech = new Controller(1, false);
    network = RobotNetwork.initNetwork(); //Singleton should not allow manual object initalization. Must call init function
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    driver.driveByVision();
  }

  @Override
  public void autonomousPeriodic() {
   
  }

  @Override
  public void teleopPeriodic() {

    driver.drive();
    mech.runSlider();

  }

  @Override
  public void testPeriodic() {
  }
}
