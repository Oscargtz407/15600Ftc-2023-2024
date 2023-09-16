package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class ChassisTankSubsystem extends SubsystemBase {
    DcMotorEx leftMotor;
    DcMotorEx rightMotor;

    public ChassisTankSubsystem(HardwareMap hardwareMap){
        leftMotor = hardwareMap.get(DcMotorEx.class, "lftM");
        rightMotor = hardwareMap.get(DcMotorEx.class, "rghtM");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void moveRobot(double drive, double turn){
        double leftPower;
        double rightPower;

        leftPower = Range.clip(drive - turn, -0.5, 0.5);
        rightPower = Range.clip(drive + turn, -0.5, 0.5);

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }
    public void InvertFront(double drive, double turn){
        double leftPower;
        double rightPower;

        leftPower = Range.clip(drive + turn, -0.5, 0.5);
        rightPower = Range.clip(drive - turn, -0.5, 0.5);

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }
}
