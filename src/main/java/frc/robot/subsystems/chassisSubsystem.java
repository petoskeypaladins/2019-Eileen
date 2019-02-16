/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


//import org.graalvm.compiler.nodes.calc.LeftShiftNode;

import edu.wpi.first.wpilibj.MotorSafety;
// import edu.wpi.first.wpilibj.CANSparkMax;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.telliopCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class chassisSubsystem extends Subsystem {
  public CANSparkMax leftMotor1 = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax leftMotor2 = new CANSparkMax(15, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax rightMotor1 = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax rightMotor2 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax center = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  public SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1 , leftMotor2) ;
  public SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1 , rightMotor2) ;

  //public DifferentialDrive driveTrain = new DifferentialDrive(left, right);  

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
   right.setInverted(true);
    setDefaultCommand(new telliopCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    // rightMotor1.setInverted(true);
  }
}
