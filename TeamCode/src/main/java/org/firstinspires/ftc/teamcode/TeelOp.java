package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "MagicTeleOp")
public class TeelOp extends OpMode {
    private Botommaps BM;
    @Override
    public void init(){
        Robott robot = new Robott(hardwareMap);
        BM = new Botommaps(robot, gamepad1);
    }
    @Override
    public void loop(){
        BM.armCode();
        BM.dpadStrafe();
    }
}
