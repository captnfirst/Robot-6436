// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 // ------ Gereklilikler demektir bizim için lazım olan her şeyi buradan çekmek için yapılmuş bir class -------
public final class Constants {
   
    //Joystick
   public static final class JoystickConstants{
       public static final int F310 = 0; // Joystick F310 Logitech
       public static final int Panel = 1; // Driver Station Buttons
   }

   //Drive
   public static final class DriveConstants{
        public static final int kLeftRearMotor = 13; // Sol Arka Motor Bağlantı ip
        public static final int kLeftFrontMotor = 14; // Sol Ön Motor Bağlantı ip
        public static final int kRightRearMotor = 10; // Sağ Arka Motor Bağlantı ip
        public static final int kRightFrontMotor = 11; // Sağ Arka Motor Bağlantı ip

        public static final boolean kLeftRearMotorInverted = true; // Motor çıkışlarını ters çevirmeye yarıyor
        public static final boolean kLeftFrontMotorInverted = true; // Motor çıkışlarını ters çevirmeye yarıyor
        public static final boolean kRightRearMotorInverted = true; // Motor çıkışlarını ters çevirmeye yarıyor
        public static final boolean kRightFrontMotorInverted = true; // Motor çıkışlarını ters çevirmeye yarıyor
   }

   //Intake
   public static final class IntakeConstants{
        public static final int kIntakeMotorPort = 40;
        public static final int kCompressorPort = 0;
        public static final int kPCMPort = 0;
        public static final int kIntakeDoubleSolenoidPort1 = 0;
        public static final int kIntakeDoubleSolenoidPort2 = 1;
   }
}
