package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Controlled", group = "Performance")
public class Controlled extends LinearOpMode {
    Hardware robot = new Hardware();
    Drive drive = new Drive(robot);
    Claw claw = new Claw(robot);
    Base base = new Base(robot);

    public void runOpMode() {

        robot.init(hardwareMap);

        claw.init();

        waitForStart();

        while(opModeIsActive()) {

            drive.drive(gamepad1, telemetry);

            robot.arm.setPower(gamepad2.left_stick_y);

            claw.run(gamepad2.b, gamepad2.y);
            base.run(gamepad2.x);

            telemetry.update();

            sleep(25);
        }
    }
}
