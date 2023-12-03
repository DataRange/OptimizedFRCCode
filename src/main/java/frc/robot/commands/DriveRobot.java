package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotContainer;
import frc.robot.subsystems.swerve.DriveTrain;

public class DriveRobot extends CommandBase {

    private DriveTrain dt;
    private CommandXboxController joy;
    
    public DriveRobot() {
        dt = DriveTrain.getInstance();
        joy = RobotContainer.getJoy();
        addRequirements(dt);
    }

    @Override
    public void execute() {
        double xVelocity = joy.getLeftY();
        double yVelocity = joy.getLeftX();
        double zRotation = joy.getRightX();
        dt.moveChassis(xVelocity, yVelocity, zRotation);
    }
    
}
