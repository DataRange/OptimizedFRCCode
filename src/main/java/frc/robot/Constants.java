// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final double CONTROLLER_DEADBAND = 0.2;
  }

  public static class SwerveConstants {
    public static final int NEO_MAX_RPM = 5676;
    public static final double WHEEL_DIAM_M = Units.inchesToMeters(4.0); //convert using inbuilt conversion to find diameter of wheel in meters

    public static final double DRIVE_GEARING = (14.0 / 50.0) * (28.0 / 16.0) * (15.0 / 45.0);
    public static final double DRIVE_POSITION_CONVERSION_FACTOR = (WHEEL_DIAM_M * Math.PI * DRIVE_GEARING); //Rotations to Meters
    public static final double DRIVE_VELOCITY_CONVERSION_FACTOR = (DRIVE_POSITION_CONVERSION_FACTOR) / (60.0); //RPM to M/S

    public static final double STEER_GEARING = 1 / (150.0 / 7.0);
    public static final double STEER_POSITION_CONVERSION_FACTOR = STEER_GEARING * 2 * Math.PI; //Rotations to Radians

    public static final int SWERVE_FRONT_LEFT_STEER_MOTOR_ID = 0;
    public static final int SWERVE_FRONT_LEFT_DRIVE_MOTOR_ID = 0;
    public static final int SWERVE_FRONT_LEFT_CANCODER_ID = 0;

    public static final int SWERVE_REAR_LEFT_STEER_MOTOR_ID = 0;
    public static final int SWERVE_REAR_LEFT_DRIVE_MOTOR_ID = 0;
    public static final int SWERVE_REAR_LEFT_CANCODER_ID = 0;

    public static final int SWERVE_FRONT_RIGHT_STEER_MOTOR_ID = 0;
    public static final int SWERVE_FRONT_RIGHT_DRIVE_MOTOR_ID = 0;
    public static final int SWERVE_FRONT_RIGHT_CANCODER_ID = 0;

    public static final int SWERVE_REAR_RIGHT_STEER_MOTOR_ID = 0;
    public static final int SWERVE_REAR_RIGHT_DRIVE_MOTOR_ID = 0;
    public static final int SWERVE_REAR_RIGHT_CANCODER_ID = 0;

    public static final int SWERVE_FRONT_LEFT_IDS = 0;
    public static final int SWERVE_REAR_LEFT_IDS = 1;
    public static final int SWERVE_FRONT_RIGHT_IDS = 2;
    public static final int SWERVE_REAR_RIGHT_IDS = 3;

    public static final int STEER_IDX = 0;
    public static final int DRIVE_IDX = 0;
    public static final int CANCODER_IDX = 0;

    public static final int[][] SWERVE_MOTOR_IDS = {
      {SWERVE_FRONT_LEFT_STEER_MOTOR_ID, SWERVE_FRONT_LEFT_DRIVE_MOTOR_ID, SWERVE_FRONT_LEFT_CANCODER_ID},
      {SWERVE_REAR_LEFT_STEER_MOTOR_ID, SWERVE_REAR_LEFT_DRIVE_MOTOR_ID, SWERVE_REAR_LEFT_CANCODER_ID},
      {SWERVE_FRONT_RIGHT_STEER_MOTOR_ID, SWERVE_FRONT_RIGHT_DRIVE_MOTOR_ID, SWERVE_FRONT_RIGHT_CANCODER_ID},
      {SWERVE_REAR_RIGHT_STEER_MOTOR_ID, SWERVE_REAR_RIGHT_DRIVE_MOTOR_ID, SWERVE_REAR_RIGHT_CANCODER_ID}
    };

    public static final double STEER_KP = 0.0;
    public static final double DRIVE_KP = 0.0;

    public static final int GYRO_PIGEON_ID = 0;
  }
}
