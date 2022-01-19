// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsytem. */

  // Motor Sürücülerin tanımlanması
  public final WPI_VictorSPX leftRearMotor = new WPI_VictorSPX(DriveConstants.kLeftRearMotor);
  public final WPI_VictorSPX rightRearMotor = new WPI_VictorSPX(DriveConstants.kRightRearMotor);
  private final WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(DriveConstants.kLeftFrontMotor);
  private final WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(DriveConstants.kRightFrontMotor);

  // X ve Y komutanda giden bir robot yaptığımız için DiffrerentialDrive fonksiyonunu kullanıyoruz.
  private final DifferentialDrive m_drive = new DifferentialDrive(leftRearMotor, rightRearMotor);

  //Nötr modu boştayken motor uçlarını elektriksel olarak ortak hale getirmek için "frenlemeye" ayarlanabilir,
  //bu da dönen motor hareketiyle mücadele eden bir yavaşlamaya neden olur. Elektriksel bir frenleme yapar.
  private NeutralMode defaultMode = NeutralMode.Brake; 
  public DriveSubsystem() {

    leftFrontMotor.setInverted(DriveConstants.kLeftFrontMotorInverted); // Motor çıkışlarını ters çevirmeye yarıyor
    leftRearMotor.setInverted(DriveConstants.kLeftRearMotorInverted); // Motor çıkışlarını ters çevirmeye yarıyor
    rightFrontMotor.setInverted(DriveConstants.kRightFrontMotorInverted); // Motor çıkışlarını ters çevirmeye yarıyor
    rightRearMotor.setInverted(DriveConstants.kRightRearMotorInverted); // Motor çıkışlarını ters çevirmeye yarıyor

    leftFrontMotor.setNeutralMode(defaultMode);
    rightFrontMotor.setNeutralMode(defaultMode);
    leftRearMotor.setNeutralMode(defaultMode);
    rightRearMotor.setNeutralMode(defaultMode);

    leftFrontMotor.follow(leftRearMotor); // Motorları birbirine bağlıyor
    rightFrontMotor.follow(rightRearMotor); // Motorları birbirine bağlıyor
  }

  // İleri ve dönüşler için arcade drive fonksiyonu
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot, true); 
  }

  public void tankDrive(double l, double r) {
    m_drive.tankDrive(l, r, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
