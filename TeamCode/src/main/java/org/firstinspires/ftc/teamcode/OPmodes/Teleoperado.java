package org.firstinspires.ftc.teamcode.OPmodes;


import static org.firstinspires.ftc.teamcode.Commands.DefaultDozzyIntake.IntakeMode.IN;
import static org.firstinspires.ftc.teamcode.Commands.DefaultDozzyIntake.IntakeMode.OUT;
import static org.firstinspires.ftc.teamcode.Commands.DefaultDozzyIntake.IntakeMode.STOP;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.DefaultDozzyIntake;
import org.firstinspires.ftc.teamcode.Commands.DriveCommand;
import org.firstinspires.ftc.teamcode.Commands.ServoedIntakeCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ChassisTankSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DozzyIntake;
import org.firstinspires.ftc.teamcode.Subsystems.ServoedClaw;

@TeleOp
public class Teleoperado extends CommandOpMode {
    ChassisTankSubsystem chassisTankSubsystem;
    ServoedClaw servoedClaw;
    DozzyIntake dozzyIntake;


    @Override
    public void initialize(){
        chassisTankSubsystem = new ChassisTankSubsystem(hardwareMap);
        dozzyIntake = new DozzyIntake(hardwareMap);
        servoedClaw = new ServoedClaw(hardwareMap);

        register(dozzyIntake, chassisTankSubsystem);

        chassisTankSubsystem.setDefaultCommand(new DriveCommand(chassisTankSubsystem, gamepad1));



        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_LEFT)
                .whileHeld(new DefaultDozzyIntake(dozzyIntake, STOP));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.A)
                .whileHeld(new ServoedIntakeCommand(servoedClaw, ServoedIntakeCommand.ServoedIntakeModes.OPEN));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.B)
                .whileHeld(new ServoedIntakeCommand(servoedClaw, ServoedIntakeCommand.ServoedIntakeModes.CLOSE));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(new DefaultDozzyIntake(dozzyIntake, IN))
                .whenReleased(new DefaultDozzyIntake(dozzyIntake, STOP));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(new DefaultDozzyIntake(dozzyIntake, OUT))
                .whenReleased(new DefaultDozzyIntake(dozzyIntake,STOP));
    }
}
