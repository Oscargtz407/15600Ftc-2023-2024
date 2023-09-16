package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoedClaw {
    Servo servoClaw;

    public ServoedClaw(HardwareMap hardwareMap){
        servoClaw = hardwareMap.get(Servo.class, "I2");

        servoClaw.setDirection(Servo.Direction.FORWARD);
    }

    public void moveSecondIntake(double position){

        servoClaw.setPosition(position);
    }
}
