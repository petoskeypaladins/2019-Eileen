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
  public static final int LEFT_MOTOR_1 = 10;
  public static final int LEFT_MOTOR_2 = 1;
  public static final int RIGHT_MOTOR_1 = 14;
  public static final int RIGHT_MOTOR_2 = 15;
  public static final int H_MOTOR = 2;

  // LiftSubsystem
  public static final int LIFT_MOTOR = 13;

  public static final int CRAWL_MOTOR = 12;

  // IntakeSubsystem
  public static final int INTAKE_ARM_MOTOR = 3;
  public static final int INTAKE_ROLLER_MOTOR = 4;

  //Solenoids
  public static final int CRAWL_SOLENOID_OUT = 4;
  public static final int CRAWL_SOLENOID_IN = 5;
  public static final int PIN_SOLENOID_OUT = 1;
  public static final int PIN_SOLENOID_IN = 0;
  public static final int PIN_SOLENOID_PCM = 0;
  //hatch solenoids
  public static final int HATCH_SOLENOID_OUT = 2;
  public static final int HATCH_SOLENOID_IN = 3;
  public static final int HATCH_SOLENOID_PCM = 0;
  
  public static final int SHIFT_SOLENOID_OUT = 6;
  public static final int SHIFT_SOLENOID_IN = 7;
  public static final int SHIFT_SOLENOID_PCM = 0;
  //DIO
  public static final int LIFT_ZERO = 1;


  
}
