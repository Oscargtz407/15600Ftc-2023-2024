package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class ChassisTankSubsystem extends SubsystemBase {
    DcMotorEx leftFrontMotor;
    DcMotorEx rightFrontMotor;

    public ChassisTankSubsystem(HardwareMap hardwareMap){
        leftFrontMotor = hardwareMap.get(DcMotorEx.class, "lftM");
        rightFrontMotor = hardwareMap.get(DcMotorEx.class, "rghtM");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void moveRobot(double drive, double turn) {
        double leftPower;
        double rightPower;

        leftPower = Range.clip(drive - turn, -1, 1);
        rightPower = Range.clip(drive + turn, -1, 1);

        leftFrontMotor.setPower(leftPower);
        rightFrontMotor.setPower(rightPower);
    }
}
