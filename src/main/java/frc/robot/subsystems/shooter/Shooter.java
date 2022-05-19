// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.IOException;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.ShooterFunction;
import static frc.robot.Constants.SHOOTER_CONSTANTS.*;

public class Shooter extends SubsystemBase {
  private WPI_TalonSRX talonSRX = RobotContainer.shooter_motor;
  /** Creates a new Shooter. */
  public Shooter() {
    talonSRX.setNeutralMode(NeutralMode.Brake);
    talonSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
    talonSRX.setSelectedSensorPosition(0);
  }

  public static enum ShooterZone {
    ZONE1, ZONE2, ZONE3, ZONE4, ZONE5, ZONE6, ZONE7, ZONE8, ZONE9, ZONE10, ZONE11, ZONE12, ZONE13, ZONE14, ZONE15, ZONE16, ZONE17
  };

  public static enum ShooterAngle {
    ANGLE1, ANGLE2
  }

  public void shoot(double velocity) { // in position change per 100ms
    talonSRX.set(velocity);
  }

  public double getVelocity() {
    return talonSRX.getSelectedSensorVelocity();
  }

  public double getShooterRPM (ShooterZone state, double distance) {
    switch(state) {
      case ZONE1:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE1.getOutput();
      case ZONE2:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE2.getOutput();
      case ZONE3:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE3.getOutput();
      case ZONE4:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE4.getOutput();
      case ZONE5:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE5.getOutput();
      case ZONE6:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE6.getOutput();
      case ZONE7:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE7.getOutput();
      case ZONE8:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE8.getOutput();
      case ZONE9:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE9.getOutput();
      case ZONE10:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE10.getOutput();
      case ZONE11:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE11.getOutput();
      case ZONE12:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE12.getOutput();
      case ZONE13:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE13.getOutput();
      case ZONE14:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE14.getOutput();
      case ZONE15:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE15.getOutput();
      case ZONE16:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE16.getOutput();
      case ZONE17:
        return Constants.SHOOTER_STATE.DISTANCE_CONSTANTS.ZONE17.getOutput();
      default:
        return 3500;
    }
  }

  public ShooterZone getShooterZone (double distance) {
    if (2.3 < distance && distance < 2.368) {
      return ShooterZone.ZONE1;
    }
    else if (2.368 <= distance && distance < 2.47) {
      return ShooterZone.ZONE2;
    }
    else if (2.47 <= distance && distance < 2.572) {
      return ShooterZone.ZONE3;
    }
    else if (2.572 <= distance && distance < 2.674) {
      return ShooterZone.ZONE4;
    }
    else if (2.674 <= distance && distance < 2.776) {
      return ShooterZone.ZONE5;
    }
    else if (2.776 <= distance && distance < 2.878) {
      return ShooterZone.ZONE6;
    }
    else if (2.878 <= distance && distance < 2.98) {
      return ShooterZone.ZONE7;
    }
    else if (2.98 <= distance && distance < 3.082) {
      return ShooterZone.ZONE8;
    }
    else if (3.082 <= distance && distance < 3.184) {
      return ShooterZone.ZONE9;
    }
    else if (3.184 < distance && distance < 3.286) {
      return ShooterZone.ZONE10;
    }
    else if (3.286 <= distance && distance < 3.388) {
      return ShooterZone.ZONE11;
    }
    else if (3.388 <= distance && distance < 3.49) {
      return ShooterZone.ZONE12;
    }
    else if (3.49 <= distance && distance < 3.592) {
      return ShooterZone.ZONE13;
    }
    else if (3.592 <= distance && distance < 3.694) {
      return ShooterZone.ZONE14;
    }
    else if (3.694 <= distance && distance < 3.796) {
      return ShooterZone.ZONE15;
    }
    else if (3.796 <= distance && distance < 3.898) {
      return ShooterZone.ZONE16;
    }
    else if (3.898 <= distance && distance < 3.966) {
      return ShooterZone.ZONE17;
    }
    else {
      return ShooterZone.ZONE5;
    }
  }

  public double getShooterAngle (ShooterAngle angle, double distance) {
    switch(angle) {
      case ANGLE1:
        return Constants.SHOOTER_STATE.ANGLE_CONSTANTS.FOURZERO.getAngle();
      case ANGLE2:
        return Constants.SHOOTER_STATE.ANGLE_CONSTANTS.TWOFIVE.getAngle();
      default:
        return 50;
    }
  }

  public ShooterAngle getShooteAngle (double distance) {
    if (2.3 <= distance && distance < 3.184) {
      return ShooterAngle.ANGLE1;
    }
    else if (3.184 <= distance && distance <= 3.966) {
      return ShooterAngle.ANGLE2;
    }
    else {
      return ShooterAngle.ANGLE1;
    }
  }

  @Override
  public void periodic() {
    double distance = SmartDashboard.getNumber("Distance to target", 0);
    SmartDashboard.putNumber("Shooter speed", getVelocity());
    SmartDashboard.putNumber("Hood angle", getShooterAngle(getShooteAngle(distance), distance));
    double rpm = getShooterRPM(getShooterZone(distance), distance);
    double velocity = RobotContainer.shooter_pid.calculate(getVelocity(), rpm);
    shoot(velocity/shooter_rpm);
    
    // This method will be called once per scheduler run
  }
}
