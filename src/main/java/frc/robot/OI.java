/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public XboxController xbox = new XboxController(0);
  public Joystick stick = new Joystick(1);
  
  //button behaviors
  public Button pinInBtn = new JoystickButton(stick, 5);
  public Button pinOutBtn = new JoystickButton(stick, 6);
  public Button hatchInBtn = new JoystickButton(stick, 3);
  public Button hatchOutBtn = new JoystickButton(stick, 4);
  public Button hatchRocketBtn = new JoystickButton(stick, 2);
public OI(){
  pinInBtn.whenPressed(new RetractPinCommand());
  pinOutBtn.whenPressed(new ExtendPinCommand());
  hatchInBtn.whenPressed(new RetractHatchCommand());
  hatchOutBtn.whenPressed(new ExtendHatchCommand());
  hatchRocketBtn.whenPressed(new DropHatchRocketCommandGroup());

  }
}