package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class Robott {

    DcMotor Left_Front;
    DcMotor Right_Front;
    DcMotor Left_Back;
    DcMotor Right_Back;
    IMU imu;

    public Robott(HardwareMap hardwareMap) {
        Left_Front = hardwareMap.get(DcMotor.class, "front_left_drive");
        Right_Front = hardwareMap.get(DcMotor.class, "front_right_drive");
        Left_Back = hardwareMap.get(DcMotor.class, "back_left_drive");
        Right_Back = hardwareMap.get(DcMotor.class, "back_right_drive");

        Right_Back.setDirection(DcMotor.Direction.REVERSE);
        Right_Front.setDirection(DcMotor.Direction.REVERSE);

        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection =
                RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection =
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

        RevHubOrientationOnRobot orientationOnRobot = new
                RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
    }

}
