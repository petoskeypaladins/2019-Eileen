/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
  // Robot.m_subsystem.leftMotor2.setInverted(true);
  // Robot.m_subsystem.leftMotor1.setInverted(true);
  
  // setInverted​(boolean isInverted)
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if((Robot.m_oi.xbox.getRawAxis(1) > 0.1 || Robot.m_oi.stick.getRawAxis(1) < -0.1) || (Robot.m_oi.stick.getRawAxis(0) > 0.1 || Robot.m_oi.stick.getRawAxis(0) < -0.1)) {
    //   driveTrain.arcadeDrive(-Robot.m_oi.stick.getRawAxis(1), Robot.m_oi.stick.getRawAxis(0));
    // } else {
    //   driveTrain.arcadeDrive(0, 0);
    // }
    // if(Robot.m_oi.stick.getRawAxis(2)>0.1||Robot.m_oi.stick.getRawAxis(2)<-0.1)
    // Robot.m_subsystem.center.set(-Robot.m_oi.stick.getRawAxis(2));else{Robot.m_subsystem.center.set(0);}    
    double rightThrottle = Robot.m_oi.xbox.getX(Hand.kRight);
    double leftThrottle = Robot.m_oi.xbox.getY(Hand.kLeft);
    rightThrottle = rightThrottle*Math.abs(rightThrottle);
    leftThrottle = leftThrottle*Math.abs(leftThrottle);
    driveTrain.arcadeDrive(.7*leftThrottle, .5*rightThrottle);
  
    double strafeLeft = Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft);
    double strafeRight = Robot.m_oi.xbox.getTriggerAxis(Hand.kRight);
    Robot.m_subsystem.center.set(.7*(strafeLeft-strafeRight));


    Robot.liftSubsystem.moveLiftMech(Robot.m_oi.stick.getY());
    if(Robot.m_oi.xbox.getStartButtonPressed()) Robot.liftSubsystem.clearEncoder();
    SmartDashboard.putNumber("Encoder Counts", Robot.liftSubsystem.getCounts());
    SmartDashboard.putNumber("Pot Value (Volts)", Robot.liftSubsystem.Pot.getVoltage());
    SmartDashboard.putNumber("Pot Value (Inches)", Robot.liftSubsystem.voltsToInches(Robot.liftSubsystem.Pot.getVoltage()));
    if(Robot.m_oi.xbox.getXButtonPressed()) Robot.m_subsystem.shifter.set(Value.kForward);
    if(Robot.m_oi.xbox.getBButtonPressed()) Robot.m_subsystem.shifter.set(Value.kReverse);
    if(Robot.m_subsystem.shifter.get() == Value.kForward) SmartDashboard.putString("Shift", "Low");
    else SmartDashboard.putString("Shift", "High");
    double rollerSpeed = 0;
    if (Robot.m_oi.stick.getRawButton(1))
    rollerSpeed = .9;
    else if (Robot.m_oi.stick.getRawButton(2))
      rollerSpeed = -.9;
    Robot.intakeSubsystem.rollerSpin(rollerSpeed);
    if(Robot.m_oi.xbox.getBumperPressed(Hand.kRight)) {
      if(Robot.crawlSubsystem.level2Solenoid.get() == Value.kForward) Robot.crawlSubsystem.level2Solenoid.set(Value.kReverse);
      else Robot.crawlSubsystem.level2Solenoid.set(Value.kForward);
    }
    if(Robot.m_oi.xbox.getBumperPressed(Hand.kLeft)) {
      if(Robot.crawlSubsystem.backLiftSolenoid.get() == Value.kForward) Robot.crawlSubsystem.backLiftSolenoid.set(Value.kReverse);
      else Robot.crawlSubsystem.backLiftSolenoid.set(Value.kForward);
    }
    double armspeed = 0;
    if (Robot.m_oi.xbox.getPOV(0)==180)
      armspeed = .25;
    else if (Robot.m_oi.xbox.getPOV(0)==0)
      armspeed = -.2;
    Robot.intakeSubsystem.armMove(armspeed);

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
