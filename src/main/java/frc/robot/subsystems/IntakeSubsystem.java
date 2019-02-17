/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  public TalonSRX arm = new TalonSRX(RobotMap.INTAKE_ARM_MOTOR);
  public TalonSRX roller = new TalonSRX(RobotMap.INTAKE_ROLLER_MOTOR);   
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void rollerSpin (double speed){
    roller.set(ControlMode.PercentOutput, speed);
  }

  public void armMove( double speed){
    arm.set(ControlMode.PercentOutput, .05 );
  }
}
