package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.ServoedClaw;

public class ServoedIntakeCommand extends CommandBase {
    private ServoedClaw servoedClaw;
    private ServoedIntakeModes servoedIntakeModes;
    private Gamepad gamepad;

    public ServoedIntakeCommand(ServoedClaw servoedClaw, ServoedIntakeModes servoedIntakeModes){
        this.servoedClaw = servoedClaw;
        this.servoedIntakeModes = servoedIntakeModes;
    }

    public enum ServoedIntakeModes{
        OPEN,
        CLOSE,
    }

    public void initialize(){}

    public void execute(){
        switch (servoedIntakeModes){
            case OPEN:
                servoedClaw.moveSecondIntake(1);
                break;

            case CLOSE:
                servoedClaw.moveSecondIntake(.5);
        }
    }
}
