// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.limelight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;
import static frc.robot.Constants.CAMERA_DATA.*;

public class Limelight extends SubsystemBase {
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private boolean not_active;
  private boolean has_target;
  /** Creates a new Limelight. */
  public Limelight() {}

  public double checkTarget() {
    return table.getEntry("tv").getDouble(0);
  }

  public double getX() {
    return table.getEntry("tx").getDouble(0);
  }

  public double getY() {
    return table.getEntry("ty").getDouble(0);
  }

  public void setPipeline(int pipeline) {
    table.getEntry("pipeline").setNumber(pipeline);
  }

  public double getPipeline() {
    return table.getEntry("getpipe").getDouble(0);
  }

  public void ledMode(int ledMode) {
    table.getEntry("ledMode").setNumber(ledMode);
  }

  public double getDistance() {
    double alpha = camera_pitch + getY();
    return (target_height - camera_height)/Math.tan(alpha);
  }

  public boolean getActivestate() {
    return !not_active;
  }

  public boolean getTargetstate() {
    return has_target;
  }

  public void resetTarget() {
    has_target = false;
    not_active = true;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Distance to target", getDistance());
    SmartDashboard.putNumber("Y angle", getY());
    SmartDashboard.putNumber("X angle", getX());
    SmartDashboard.putBoolean("Target state", has_target);
    SmartDashboard.putBoolean("Active state", !not_active);
    if (checkTarget() > 0) {
      has_target = true;
    }
    else {
      has_target = false;
    }

    if(RobotContainer.controller.getRawButton(3)) {
      not_active = false;
    }
    else {
      not_active = true;
    }

    // This method will be called once per scheduler run
  }
}
