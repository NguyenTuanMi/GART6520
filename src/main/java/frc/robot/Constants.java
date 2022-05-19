// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class MECA{
        public static final int RFMOTOR = 1;
        public static final int LFMOTOR = 2;
        public static final int RBMOTOR = 3;
        public static final int LBMOTOR = 4;
        public static final int SHOOTER_MOTOR = 5;
        public static final int HOOD_MOTOR = 6;
    }
    public static class controller{
        public static final int Sq = 1;
        public static final int X = 2;
        public static final int O = 3;
        public static final int Tri = 4;
    
        public static final int L1 = 5;
        public static final int R1 = 6;
        public static final int L2 = 7;
        public static final int R2 = 8;

        public static final int L3 = 11;
        public static final int R3 = 12;

        public static final int Share = 9;
        public static final int Option = 10;
        public static final int TouchPad = 13;
        
        public static final int Up = 14;
        public static final int Down = 15;
        public static final int Left = 16;
        public static final int Right = 17;

        public static final int xbox_port = 2;
    }
    public static class GenerichHIDController {
        public static final int port = 0;
        public static final int left_sideways_button = 7;
        public static final int right_sideways_button = 8;
        public static final int forward_button = 5;
        public static final int downward_button = 6;
        public static final int shoot_button = 9;
        public static final int rotate_axis = 0;
    }
    public static class Speed{
        public static final double maxSpeed = .8;
        public static final double maxRotation = .5;
        public static final double minSpeed = .4;
    }

    public static class FIELD_DATA {
        public static final double target1_x = 10;
        public static final double target1_y = 10;
        public static final double target2_x = 11;
        public static final double target2_y = 11;
        public static final double target3_x = 12;
        public static final double target3_y = 12;
    }

    public static class ROBOT_DATA {
        // the 4 wheels position in the center of robot mass frame
        public static final Translation2d m_frontLeft = new Translation2d(2,3); 
        public static final Translation2d m_frontRight = new Translation2d(2,3);
        public static final Translation2d m_backRight = new Translation2d(2,3);
        public static final Translation2d m_backLeft = new Translation2d(2,3);
    }

    public static class CAMERA_DATA {
        public static final double camera_height = 1;        // compare to the floor
        public static final double target_height = 1;        // compare to the floor
        public static final double camera_pitch = 
        Units.degreesToRadians(23);                          // in field's frame
        
    }

    public static class SHOOTER_CONSTANTS {
        public static final double angular_kp = 0.5;
        public static final double angular_kd = 0.6;
        public static final double yaw = 10;
        public static final double const_delta = 1; // angle in radian
        public static final double turretMinimumInput = 10;
        public static final double turretMaximumInput = 180;
        public static final double turretVelocityTolerance = .01;
        public static final double turretPositionTolerance = .08;
        public static final int pipeline = 0;
        public static final double shooter_rpm = 5000;
    }

    public static class HOOD_CONSTANTS {
        public static final double min_angle = 0;
        public static final double max_angle = 70;
        public static final double max_velocity = 0.4;
        public static final double min_velocity = 0.2;
        public static final double hoodVelocityTolerence = .01;
        public static final double hoodPositionTolerence = .08;
        public static final double hood_kp = 0.2;
        public static final double hood_kd = 0.1;
        public static final double hood_rpm = 5000;
    }

    public static class PNEUMATICS_CONSTANTS {
        public static final int solenoid_alpha_forward_channel = 4;
        public static final int solenoid_alpha_reverse_channel = 5;
        public static final int solenoid_beta_forward_channel = 3;
        public static final int solenoid_beta_reverse_channel = 4;
        public static final int compressor_id = 0;
    }

    public static class SHOOTER_STATE {
        public static enum DISTANCE_CONSTANTS {
            ZONE1 (3249.94, true),
            ZONE2 (3278.59, true),
            ZONE3 (3313.6, true),
            ZONE4 (3332.17 , true),
            ZONE5 (3364.53, true),
            ZONE6 (3399.55, true),
            ZONE7 (3428.2, true),
            ZONE8 (3461.55, true),
            ZONE9 (3504.74, true),
            ZONE10 (3530.05, true),
            ZONE11 (3568.25, true),
            ZONE12 (3609.63, true),
            ZONE13 (3647.83, true),
            ZONE14 (3682.84, true),
            ZONE15( 3730.59, true),
            ZONE16 (3765.6, true),
            ZONE17 (3819.72, true);

            private double RPM;
            private boolean hoodAngle; //final?

            DISTANCE_CONSTANTS (double percentRPM, boolean hoodAngle) {
                this.RPM = percentRPM;
                this.hoodAngle = hoodAngle;
            }
             public double getOutput() {
                return RPM;
            }
             public boolean getHoodAngle() {
                return hoodAngle;
            }

        }
        public static enum ANGLE_CONSTANTS {
            TWOFIVE (61),
            FOURZERO (52.5);

            private double hoodAngle; //final?
            ANGLE_CONSTANTS (double hoodAngle) {
                this.hoodAngle = hoodAngle;
            }
             public double getAngle() {
                return hoodAngle;
            }
        }
    }
}

