// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class JoystickDrive extends CommandBase {
  /** Creates a new DriveCommand. */

  // Drive Subsystemi çekerek motor üzerindeki kontrollerimizi command' a aktardık 
  private final DriveSubsystem m_drive;
  // Robotu joystick ile sürmek için bir komut DoubleSupplier RawAxis'ler için 
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;

  public JoystickDrive(DriveSubsystem drive, DoubleSupplier left, DoubleSupplier right) {
    // Use addRequirements() here to declare subsystem dependencies.

    // burada kullanacağımız dataların eşitlemesi yapıyoruz ve bu command a diyoruz ki drive subsystem olmadan çalışamazsın
    //addRequirements() fonksiyonu bu subystem gerekli komutudur.
    m_drive = drive;
    m_left = left;
    m_right = right;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // RobotCoantainer dan aldığımız RawAxis bilgilerini burada çalıştırıyoruz.
    // Neden burada RawAxis bilgilerini girmedik diyebilirsin.
    //Nedeni ise RobotContainer dan istediğimiz her an kolaylıkla ulaşabilmek ve yazılım bilmeyen bir insan için bile kolaylıkla değişiklik yapabilmesini sağlamak.
    m_drive.arcadeDrive(m_left.getAsDouble(), m_right.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
