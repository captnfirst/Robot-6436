// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.Drive.JoystickDrive;
import frc.robot.commands.Intake.RunIntake;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Subsystemlerimizi ve joysticklerimizi RobotContainer a çektiğimiz yer

  //Joystick
  public Joystick m_driverController = new Joystick(JoystickConstants.F310);
  public Joystick m_operatorController = new Joystick(JoystickConstants.Panel);

  //Subsystem
  public final DriveSubsystem m_robotDrive = new DriveSubsystem();
  public final IntakeSubsystem m_intake = new IntakeSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // ------------------ Burada oluşturduğumuz command' ın sürüş için tuş atamasını yaptık F310 Joystick kullanıyouruz --------------------------
    m_robotDrive.setDefaultCommand(new JoystickDrive(m_robotDrive, () -> -m_driverController.getRawAxis(1),() -> m_driverController.getRawAxis(4)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
     
    // ------------------- Tuş atamalarını yaptığımız yer --------------------------
     // Top Alma PANEL
     new JoystickButton(m_operatorController, 1).whileHeld(new RunIntake(m_intake, 0.4));
     // Top Bırakma PANEL
     new JoystickButton(m_operatorController, 8).whileHeld(new RunIntake(m_intake, -0.4));

     // Top Alma F310
     new JoystickButton(m_driverController, 1).whileHeld(new RunIntake(m_intake, 0.4));
     // Top Bırakma F310
     new JoystickButton(m_driverController, 8).whileHeld(new RunIntake(m_intake, -0.4));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  // Otonom Commandı çalıştırdığımız yerdir.
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous

    // Ben null olarak bıraktım otonom command yazıldığında buraya eklenmesi gerek.
    //örnek olarak aşağıya geçen sene ki yazdığım şekili bıraktım
    //return new Autonomous(m_turret, m_vision, m_shooter, m_trigger, m_push, m_robotDrive, m_intake);
    return null;
  }
}
