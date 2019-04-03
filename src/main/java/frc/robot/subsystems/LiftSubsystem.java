/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
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
  public AnalogInput Pot = new AnalogInput(3);
  public TalonSRX liftMotor = new TalonSRX(RobotMap.LIFT_MOTOR);
  DigitalInput liftdown = new DigitalInput(RobotMap.LIFT_ZERO);
  int encoderCounts;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,10);

   
  }
  public void moveLiftMech(double speed){
    SmartDashboard.putBoolean("Limit switch value", liftdown.get());
    if (liftdown.get()==false && speed < 0) {
      liftMotor.set(ControlMode.PercentOutput, 0);
      clearEncoder();
    }else if(getCounts() < -17888 && speed > 0) {
      liftMotor.set(ControlMode.PercentOutput, 0);
    } else
      liftMotor.set(ControlMode.PercentOutput, speed);

    
  }
  
  public void clearEncoder() {
    encoderCounts = liftMotor.getSensorCollection().getPulseWidthPosition();
  }

  public int getCounts() {
    return encoderCounts - liftMotor.getSensorCollection().getPulseWidthPosition();
  }
  
  public double inchesToVolts(double inches) {
    return 0.51*inches-0.016;
  }

  public double voltsToInches(double volts) {
    return 19.674*volts+.316;
  }
}
