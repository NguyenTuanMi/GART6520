// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.mecanumdrive;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotContainer;
import static frc.robot.Constants.MECA.*;
import static frc.robot.Constants.GenerichHIDController.*;
import static frc.robot.Constants.Speed.*;

public class Meca extends SubsystemBase {
  public static WPI_TalonSRX leftFront = new WPI_TalonSRX(LFMOTOR);
  public static WPI_TalonSRX rightFront = new WPI_TalonSRX(RFMOTOR);
  public static WPI_TalonSRX leftBack = new WPI_TalonSRX(LBMOTOR);
  public static WPI_TalonSRX rightBack = new WPI_TalonSRX(RBMOTOR);
  public static MecanumDrive meca = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);

  /** Creates a new Meca. */
  public Meca() {
    leftFront.setInverted(true);
    leftBack.setInverted(true);

    leftBack.setNeutralMode(NeutralMode.Brake);
    leftFront.setNeutralMode(NeutralMode.Brake);
    rightBack.setNeutralMode(NeutralMode.Brake);
    rightFront.setNeutralMode(NeutralMode.Brake);

    leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    leftBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    rightBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

  }

  @Override
  public void periodic() {
    double forward_speed = 0;
    double sideways_speed = 0;
    double rotation = 0;
    //if (RobotContainer.limelight.getTargetstate()) {
      
      rotation = -RobotContainer.controller.getRawAxis(rotate_axis) * maxSpeed;
      
      if (RobotContainer.controller.getRawButton(forward_button)) {
        forward_speed = -0.6;
      }
      else if (RobotContainer.controller.getRawButton(downward_button)) {
        forward_speed = 0.6;
      }

      if (RobotContainer.controller.getRawButton(left_sideways_button)) {
        sideways_speed = 0.5;
      }
      else if (RobotContainer.controller.getRawButton(right_sideways_button)) {
        sideways_speed = -0.5;
      }
    //}

    //else {
      //rotation = -0.5;
    //}
    meca.driveCartesian(forward_speed,
    sideways_speed,
    rotation);
    
    SmartDashboard.putNumber("LeftBack", leftBack.getSelectedSensorVelocity());
    SmartDashboard.putNumber("RightBack", rightBack.getSelectedSensorVelocity());
    SmartDashboard.putNumber("LeftFront", leftFront.getSelectedSensorVelocity());
    SmartDashboard.putNumber("RightFront", rightFront.getSelectedSensorVelocity());
    // This method will be called once per scheduler run
  }
}
