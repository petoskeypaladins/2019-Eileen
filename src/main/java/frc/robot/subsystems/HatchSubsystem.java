/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.telliopCommand;

/**
 * Add your docs here.
 */
public class HatchSubsystem extends Subsystem {
  public DoubleSolenoid hatch = new DoubleSolenoid(RobotMap.HATCH_SOLENOID_PCM,RobotMap.HATCH_SOLENOID_IN, RobotMap.HATCH_SOLENOID_OUT);
  public DoubleSolenoid pin = new DoubleSolenoid(RobotMap.PIN_SOLENOID_PCM, RobotMap.PIN_SOLENOID_IN, RobotMap.PIN_SOLENOID_OUT);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  @Override
  public void initDefaultCommand() {
  }
    public void HatchOut() {
      hatch.set(DoubleSolenoid.Value.kForward);

 }
    public void HatchIn() {
      hatch.set(DoubleSolenoid.Value.kReverse);

    }
    public void PinOut() {
      pin.set(DoubleSolenoid.Value.kForward);

    }
    public void PinIn() {
      pin.set(DoubleSolenoid.Value.kReverse);

    }
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

