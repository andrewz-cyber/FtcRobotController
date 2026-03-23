package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
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
        //maximum
        double max;

        if (gamepad.dpad_up) y = 1;
        if (gamepad.dpad_down) y = -1;
        if (gamepad.dpad_left) x = -1;
        if (gamepad.dpad_right) x = 1;

        double lf = y + x;
        double rf = y - x;
        double lb = y - x;
        double rb = y + x;

        //prevents them from going above 1
        max = Math.max(1,Math.abs(lf));
        max = Math.max(1,Math.abs(rf));
        max = Math.max(1,Math.abs(lb));
        max = Math.max(1,Math.abs(rb));

        lf /= max;
        rf /= max;
        lb /= max;
        rb /= max;

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
            robot.runIntake(1);
        }
        else if(gamepad.b){
            robot.runIntake(-1);
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
}
