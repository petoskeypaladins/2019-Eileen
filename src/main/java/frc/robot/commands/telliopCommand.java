/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * An example command.  You can replace me with your own command.
 */
public class telliopCommand extends Command {
 
  public DifferentialDrive driveTrain = new DifferentialDrive(Robot.m_subsystem.left , Robot.m_subsystem.right); 
  public telliopCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  Robot.m_subsystem.rightMotor2.setInverted(true);
  Robot.m_subsystem.rightMotor1.setInverted(true);
  
  // setInverted​(boolean isInverted)
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if((Robot.m_oi.stick.getRawAxis(1) > 0.1 || Robot.m_oi.stick.getRawAxis(1) < -0.1) || (Robot.m_oi.stick.getRawAxis(0) > 0.1 || Robot.m_oi.stick.getRawAxis(0) < -0.1)) {
      driveTrain.arcadeDrive(-Robot.m_oi.stick.getRawAxis(1), Robot.m_oi.stick.getRawAxis(0));
    } else {
      driveTrain.arcadeDrive(0, 0);
    }
    if(Robot.m_oi.stick.getRawAxis(2)>0.1||Robot.m_oi.stick.getRawAxis(2)<-0.1)
    Robot.m_subsystem.center.set(-Robot.m_oi.stick.getRawAxis(2));else{Robot.m_subsystem.center.set(0);}    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

/*
if(condition) {
  do thing
} else {
  do other thing
}
*/

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
