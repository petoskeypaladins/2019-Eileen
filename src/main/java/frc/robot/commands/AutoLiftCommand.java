/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class AutoLiftCommand extends Command {
  double goalHeight;
  public AutoLiftCommand(double height) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    goalHeight = height;
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putNumber("Goal (Inches)",goalHeight);
    SmartDashboard.putNumber("Goal (Volts", Robot.liftSubsystem.inchesToVolts(goalHeight));
    SmartDashboard.putNumber("TEST", Robot.liftSubsystem.voltsToInches(Robot.liftSubsystem.inchesToVolts(goalHeight)));
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if(Robot.liftSubsystem.getCounts() > goalHeight) {
    //   Robot.liftSubsystem.moveLiftMech(0.5);
    // } else {
    //   Robot.liftSubsystem.moveLiftMech(-0.5);
    // }
      
    if(Robot.liftSubsystem.Pot.getVoltage() > Robot.liftSubsystem.inchesToVolts(goalHeight)) Robot.liftSubsystem.moveLiftMech(-0.7);
    if(Robot.liftSubsystem.Pot.getVoltage() < Robot.liftSubsystem.inchesToVolts(goalHeight)) Robot.liftSubsystem.moveLiftMech(0.7);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // if(goalHeight == 0) {return (Robot.liftSubsystem.getCounts() == 0);}
    // else if(goalHeight > 17000) return Robot.liftSubsystem.getCounts() > goalHeight;
    // else return goalHeight+200 > Robot.liftSubsystem.getCounts() && goalHeight - 200 < Robot.liftSubsystem.getCounts(); 
    return (Robot.liftSubsystem.voltsToInches(Robot.liftSubsystem.Pot.getVoltage()) > goalHeight-0.5 && Robot.liftSubsystem.voltsToInches(Robot.liftSubsystem.Pot.getVoltage()) < goalHeight+0.5) || Robot.m_oi.stick.getRawButton(4);
    }

  // Called once after isFitnished returns true
  @Override
  protected void end() {
    Robot.liftSubsystem.moveLiftMech(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
