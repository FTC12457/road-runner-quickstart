package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public DcMotor frontLeftDrive = null;
    public DcMotor frontRightDrive = null;
    public DcMotor backLeftDrive = null;
    public DcMotor backRightDrive = null;

    public Servo claw = null;

    public DcMotor arm = null;

    public Servo baseL = null;
    public Servo baseR = null;

    public Servo autoblueArm = null;
    public Servo autoblueClaw = null;

    public BNO055IMU imu = null;

    HardwareMap hwMap = null;

    public Hardware()
    {
        // Constructor
    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        // At convenience, change names and config of RL and RR to BL and BR, respectively.

        frontLeftDrive      = hwMap.get(DcMotor.class,      "FL");
        frontRightDrive     = hwMap.get(DcMotor.class,      "FR");
        backLeftDrive       = hwMap.get(DcMotor.class,      "RL");
        backRightDrive      = hwMap.get(DcMotor.class,      "RR");

        claw                = hwMap.get(Servo.class,        "CL");
        arm                 = hwMap.get(DcMotor.class,      "AR");
        baseL               = hwMap.get(Servo.class,        "BL");
        baseR               = hwMap.get(Servo.class,        "BR");
        imu                 = hwMap.get(BNO055IMU.class,    "IM");
        autoblueArm         = hwMap.get(Servo.class,        "BA");
        autoblueClaw        = hwMap.get(Servo.class,        "BC");

        frontLeftDrive. setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.  setDirection(DcMotor.Direction.REVERSE);
        backRightDrive. setDirection(DcMotor.Direction.FORWARD);

        arm.setDirection(DcMotor.Direction.FORWARD);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        claw.setPosition(0);

        baseL.setPosition(0);
        baseR.setPosition(1);


        autoblueArm.setPosition(0.5);
        autoblueClaw.setPosition(0.5);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu.initialize(parameters);
    }
}
