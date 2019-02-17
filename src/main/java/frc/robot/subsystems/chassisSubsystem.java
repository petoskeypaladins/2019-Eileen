/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.telliopCommand;

public class chassisSubsystem extends Subsystem {
  public CANSparkMax leftMotor1 = new CANSparkMax(RobotMap.LEFT_MOTOR_1, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax leftMotor2 = new CANSparkMax(RobotMap.LEFT_MOTOR_2, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax rightMotor1 = new CANSparkMax(RobotMap.RIGHT_MOTOR_1, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax rightMotor2 = new CANSparkMax(RobotMap.RIGHT_MOTOR_2, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax center = new CANSparkMax(RobotMap.H_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
  public SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1 , leftMotor2) ;
  public SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1 , rightMotor2) ;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new telliopCommand());
  }
}
