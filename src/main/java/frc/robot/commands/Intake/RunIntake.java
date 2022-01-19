// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntake extends CommandBase {
  /** Creates a new RunIntake. */
  
  // Intake Subsystemi çekerek motor üzerindeki kontrollerimizi command' a aktardık 
  private final IntakeSubsystem m_intake;

  // m_speed tanımlayarak istediğim her yerden bu commanda erişim sağladığımda.
  // intake motorunun speed değerini istediğim zamana göre hızını ayarlamak
  private final double m_speed;

  //Burada RunIntake() fonksiyonuna Intake Subsystemi göndermemdeki amaç diğer başka bir işlemimde bana lazım olan intake motorunun bilgilerini çekebilmek 
  // Speed yazan yere ise istediğim yerde speed değeri ayarlayabilmek
  public RunIntake(IntakeSubsystem intake, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.

    // burada kullanacağımız dataların eşitlemesi yapıyoruz ve bu command a diyoruz ki intake subsystem olmadan çalışamazsın
    //addRequirements() fonksiyonu bu subystem gerekli komutudur.
    this.m_speed = speed;
    this.m_intake = intake;
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // RobotCoantainer dan aldığımız Speed bilgilerini burada çalıştırıyoruz.
    // Neden burada Speed bilgilerini girmedik diyebilirsin.
    // Nedeni ise RobotContainer dan istediğimiz her an kolaylıkla ulaşabilmek ve yazılım bilmeyen bir insan için bile kolaylıkla değişiklik yapabilmesini sağlamak.
    // + olarak ise istediğim farklı bir yerde speed değerini değiştirebilmek.
    m_intake.runIntake(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Bu komut bittiğinde motorun durmasını sağlar
    m_intake.runIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
