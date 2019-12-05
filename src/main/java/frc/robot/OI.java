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
  // public Button pinInBtn = new JoystickButton(stick, 5);
  // public Button pinOutBtn = new JoystickButton(stick, 6);
  public Button hatchInBtn = new JoystickButton(stick, 3);
  public Button hatchOutBtn = new JoystickButton(stick, 5);
  public Button hatchRocketBtn = new JoystickButton(stick, 6);
  public Button liftAutoButtonOne = new JoystickButton(stick, 7);
  public Button liftAutoButtonTwo = new JoystickButton(stick, 9);
  public Button liftAutoButtonThree = new JoystickButton(stick, 11);
  public Button liftAutoButtonFour = new JoystickButton(stick, 8);
  public Button liftAutoButtonFive = new JoystickButton(stick, 10);
  public Button liftAutoButtonSix = new JoystickButton(stick, 12); 
  
public OI(){
  // pinInBtn.whenPressed(new RetractPinCommand());
  // pinOutBtn.whenPressed(new ExtendPinCommand());
  hatchInBtn.whenPressed(new RetractHatchCommand());
  hatchOutBtn.whenPressed(new ExtendHatchCommand());
  hatchRocketBtn.whenPressed(new DropHatchRocketCommandGroup());
  liftAutoButtonOne.whenPressed(new AutoLiftCommand(76.25));
  liftAutoButtonTwo.whenPressed(new AutoLiftCommand(47.75));
  liftAutoButtonThree.whenPressed(new AutoLiftCommand(19.75));
  liftAutoButtonFour.whenPressed(new AutoLiftCommand(70));
  liftAutoButtonFive.whenPressed(new AutoLiftCommand(41.5));
  liftAutoButtonSix.whenPressed(new AutoLiftCommand(5.9+6.25));
  }
}