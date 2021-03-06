/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Counter.Mode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CrawlSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TalonSRX crawlMotor = new TalonSRX(RobotMap.CRAWL_MOTOR);
  // public Solenoid crawlLatch = new Solenoid(RobotMap.CRAWL_SOLENOID_OUT);
  public DoubleSolenoid level2Solenoid = new DoubleSolenoid(RobotMap.LEVEL2_SOLENOID_OUT,RobotMap.LEVEL2_SOLENOID_IN);
  public DoubleSolenoid backLiftSolenoid = new DoubleSolenoid(RobotMap.BACK_SOLENOID_PCM, RobotMap.BACK_LIFT_IN, RobotMap.BACK_LIFT_OUT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void unlatch(){
    // crawlLatch.set(true);
  }
  public void crawlForward(){
    crawlMotor.set(ControlMode.PercentOutput, .5);
  }
  public void crawlStop(){
    crawlMotor.set(ControlMode.PercentOutput, 0);
  }
}

