/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX liftMotor = new TalonSRX(RobotMap.LIFT_MOTOR);
  DigitalInput liftdown = new DigitalInput(RobotMap.LIFT_ZERO);
 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void moveLiftMech(double speed){
    SmartDashboard.putBoolean("Limit switch value", liftdown.get());
    if (liftdown.get()==false && speed < 0)
      liftMotor.set(ControlMode.PercentOutput, 0);
    else 
      liftMotor.set(ControlMode.PercentOutput, speed);

    
  }
}
