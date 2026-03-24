package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Botommaps {

    Robott robot;
    Gamepad gamepad;

    public Botommaps(Robott robot, Gamepad gamepad){
        this.robot = robot;
        this.gamepad = gamepad;
    }

    public void dpadStrafe(){

        //xy coords
        double x = 0;
        double y = 0;

        if (gamepad.dpad_up) y = 0.8;
        if (gamepad.dpad_down) y = -0.8;
        if (gamepad.dpad_left) x = -0.8;
        if (gamepad.dpad_right) x = 0.8;
        if (gamepad.right_bumper) {
            robot.Left_Front.setPower(1);
            robot.Right_Front.setPower(-1);
            robot.Left_Back.setPower(1);
            robot.Right_Back.setPower(-1);
        }
        if (gamepad.left_bumper) {
            robot.Left_Front.setPower(-1);
            robot.Right_Front.setPower(1);
            robot.Left_Back.setPower(-1);
            robot.Right_Back.setPower(1);
        }

        double lf = y + x;
        double rf = y - x;
        double lb = y - x;
        double rb = y + x;

        //prevents them from going above 1
        double max1 = Math.max(1,Math.abs(lf));
        double max2 = Math.max(1,Math.abs(rf));
        double max3 = Math.max(1,Math.abs(lb));
        double max4 = Math.max(1,Math.abs(rb));

        lf /= max1;
        rf /= max2;
        lb /= max3;
        rb /= max4;

        robot.Left_Front.setPower(lf);
        robot.Right_Front.setPower(rf);
        robot.Left_Back.setPower(lb);
        robot.Right_Back.setPower(rb);

//        if(gamepad.dpad_up){
//            if(gamepad.dpad_left){
//                robot.Left_Front.setPower(0);
//                robot.Left_Back.setPower(1);
//                robot.Right_Front.setPower(1);
//                robot.Right_Back.setPower(0);
//            }
//        else if(gamepad.dpad_right){
//                robot.Left_Front.setPower(1);
//                robot.Left_Back.setPower(0);
//                robot.Right_Front.setPower(0);
//                robot.Right_Back.setPower(1);
//            }
//        else {
//                robot.Left_Front.setPower(1);
//                robot.Left_Back.setPower(1);
//                robot.Right_Front.setPower(1);
//                robot.Right_Back.setPower(1);
//            }
//        }
//        if(gamepad.dpad_down){
//            if(gamepad.dpad_left){
//                robot.Left_Front.setPower(-1);
//                robot.Left_Back.setPower(0);
//                robot.Right_Front.setPower(0);
//                robot.Right_Back.setPower(-1);
//            }
//            else if(gamepad.dpad_right){
//                robot.Left_Front.setPower(0);
//                robot.Left_Back.setPower(-1);
//                robot.Right_Front.setPower(-1);
//                robot.Right_Back.setPower(0);
//            }
//            else {
//                robot.Left_Front.setPower(-1);
//                robot.Left_Back.setPower(-1);
//                robot.Right_Front.setPower(-1);
//                robot.Right_Back.setPower(-1);
//            }
//        }
//        if(gamepad.dpad_left){
//            robot.Left_Front.setPower(-1);
//            robot.Left_Back.setPower(1);
//            robot.Right_Front.setPower(1);
//            robot.Right_Back.setPower(-1);
//        }
//        if(gamepad.dpad_right){
//            robot.Left_Front.setPower(1);
//            robot.Left_Back.setPower(-1);
//            robot.Right_Front.setPower(-1);
//            robot.Right_Back.setPower(1);
//        }
    }

    public void armCode(){
        if(gamepad.a){
            robot.runIntake(0.6);
        }
        else if(gamepad.b){
            robot.runIntake(-0.6);
        }
        else{
            robot.runIntake(0);
        }

        if(gamepad.x){
            robot.runShooter(1);
        }
        else {
            robot.runShooter(0);
        }
    }

//    public void holonomicDrive(){
//        double x = gamepad.left_stick_x;
//        double y = -gamepad.left_stick_y;
//        double rx = gamepad.right_stick_x > 0.1 || gamepad.right_stick_x < -0.1 ? gamepad.right_stick_x : 0;
//
//        double flPower = y + x + rx;
//        double frPower = y - x - rx;
//        double bl = y - x + rx;
//        double br = y + x - rx;
//
//        // Normalize powers so they are within [-1, 1]
//        double max = Math.max(Math.abs(flPower), Math.max(Math.abs(frPower), Math.max(Math.abs(bl), Math.abs(br))));
//        if (max > 1.0) {
//            flPower /= max;
//            frPower /= max;
//            bl /= max;
//            br /= max;
//        }
//
//        Front_Left.setPower(flPower);
//        FrontRight.setPower(frPower);
//        backLeft.setPower(bl);
//        backRight.setPower(br);
    //}
}
