/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // chassisSubSystem
  public static final int LEFT_MOTOR_1 = 0;
  public static final int LEFT_MOTOR_2 = 1;
  public static final int RIGHT_MOTOR_1 = 14;
  public static final int RIGHT_MOTOR_2 = 15;
  public static final int H_MOTOR = 2;

  // LiftSubsystem
  public static final int LIFT_MOTOR = 13;

  // CrawlSubsystem
  public static final int CRAWL_MOTOR = 12;
  public static final int CRAWL_SOLENOID = 0;

  // IntakeSubsystem
  public static final int INTAKE_ARM_MOTOR = 3;
  public static final int INTAKE_ROLLER_MOTOR = 4;
  
}
