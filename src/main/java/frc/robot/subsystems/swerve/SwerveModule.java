package frc.robot.subsystems.swerve;

import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.Constants.SwerveConstants;

public class SwerveModule {

    private CANSparkMax steerMotor, driveMotor;
    private RelativeEncoder steerEnc, driveEnc;
    private SparkMaxPIDController steerController, driveController;
    private CANCoder canCoder;

    private Rotation2d steerSetpoint;
    private double speedSetpoint;

    public SwerveModule(int motorIDS) {
        int[] ids = SwerveConstants.SWERVE_MOTOR_IDS[motorIDS];

        steerMotor = new CANSparkMax(ids[SwerveConstants.STEER_IDX], MotorType.kBrushless);
        driveMotor = new CANSparkMax(ids[SwerveConstants.DRIVE_IDX], MotorType.kBrushless);

        steerEnc = steerMotor.getEncoder();
        steerEnc.setPositionConversionFactor(SwerveConstants.STEER_POSITION_CONVERSION_FACTOR);
        driveEnc = driveMotor.getEncoder();
        driveEnc.setPositionConversionFactor(SwerveConstants.DRIVE_POSITION_CONVERSION_FACTOR);
        driveEnc.setPositionConversionFactor(SwerveConstants.DRIVE_VELOCITY_CONVERSION_FACTOR);

        steerController = steerMotor.getPIDController();
        steerController.setP(SwerveConstants.STEER_KP);
        driveController = driveMotor.getPIDController();
        driveController.setP(SwerveConstants.DRIVE_KP);

        canCoder = new CANCoder(ids[SwerveConstants.CANCODER_IDX]);
        canCoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);
    }

    public void setModuleState(SwerveModuleState state) {
        state = SwerveModuleState.optimize(state, steerSetpoint);
        steerSetpoint = new Rotation2d(state.angle.getRadians());
        speedSetpoint = state.speedMetersPerSecond * SwerveConstants.NEO_MAX_RPM;
    }

    public void updateModule() {
        steerController.setReference(steerSetpoint.getRadians(), ControlType.kPosition);
        driveController.setReference(speedSetpoint, ControlType.kVelocity);
    }
    
}
