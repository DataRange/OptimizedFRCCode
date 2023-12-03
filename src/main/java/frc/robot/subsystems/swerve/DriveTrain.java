package frc.robot.subsystems.swerve;

import com.ctre.phoenix.sensors.WPI_Pigeon2;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.SwerveConstants;

public class DriveTrain extends SubsystemBase {

    private SwerveDriveKinematics kinematics;
    private SwerveModule[] modules;
    private WPI_Pigeon2 gyro;

    private static DriveTrain instance;

    public DriveTrain() {
        modules = new SwerveModule[] {
            new SwerveModule(SwerveConstants.SWERVE_FRONT_LEFT_IDS),
            new SwerveModule(SwerveConstants.SWERVE_REAR_LEFT_IDS),
            new SwerveModule(SwerveConstants.SWERVE_FRONT_RIGHT_IDS),
            new SwerveModule(SwerveConstants.SWERVE_REAR_RIGHT_IDS)
        };

        kinematics = new SwerveDriveKinematics();
        gyro = new WPI_Pigeon2(SwerveConstants.GYRO_PIGEON_ID);
        gyro.reset();
    }

    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

    public void moveChassis(double xVelocity, double yVelocity, double zRotation) {
        xVelocity = Math.abs(xVelocity) < OperatorConstants.CONTROLLER_DEADBAND ? 0.0 : xVelocity;
        yVelocity = Math.abs(yVelocity) < OperatorConstants.CONTROLLER_DEADBAND ? 0.0 : yVelocity;
        zRotation = Math.abs(zRotation) < OperatorConstants.CONTROLLER_DEADBAND ? 0.0 : zRotation;
        SwerveModuleState[] states = kinematics.toSwerveModuleStates(new ChassisSpeeds(xVelocity, yVelocity, zRotation));
        for (int i = 0; i < states.length; i++) {
            modules[i].setModuleState(states[i]);
            modules[i].updateModule();
        }
    }
    
}
