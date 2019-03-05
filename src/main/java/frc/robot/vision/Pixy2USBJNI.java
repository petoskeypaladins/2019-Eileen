package frc.robot.vision;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public class Pixy2USBJNI implements Runnable {
    static {
       System.loadLibrary("pixy2_usb");
    }

    private native int pixy2USBInit();

    private native void pixy2USBGetVersion();

    private native void pixy2USBLampOn();

    private native void pixy2USBLampOff();

    private native void pixy2USBInitCameraServer(int source);

    private void pixy2USBInitCameraServer(CvSource source) {
        pixy2USBInitCameraServer(source.getHandle());
    }

    private native String pixy2USBGetBlocks();

    private static Block[] blocks;
    public static final ArrayBlockingQueue<Block[]> blocksBuffer = new ArrayBlockingQueue<>(2);

    // private double m_expirationTime;
    // private final int m_notifier = NotifierJNI.initializeNotifier();
    // private final double m_period = .05; //Milliseconds?

    private int cycleCounter = 0;

    // Return value is status of PutFrame
    private native int pixy2USBLoopCameraServer();

    private static final int PIXY2_RAW_FRAME_WIDTH = 316;
    private static final int PIXY2_RAW_FRAME_HEIGHT = 208;

    private Pixy2USBJNI pixy2USBJNI;

    public AtomicBoolean toggleLamp = new AtomicBoolean(false);
    private boolean lampOn = false;

    public void toggleLamp() {
        if (lampOn) {
            System.out.println("Turning Lamp Off");
            pixy2USBJNI.pixy2USBLampOff();
            lampOn = false;
        } else {
            System.out.println("Turning Lamp On");
            pixy2USBJNI.pixy2USBLampOn();
            lampOn = true;
        }
    }

    @Override
    public void run() {
        // Uncomment these if you want extra, "regular" USB cameras
        // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        // camera.setResolution(640, 480);
        // UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(1);
        // camera1.setResolution(640, 480);

        pixy2USBJNI = new Pixy2USBJNI();
        int init_result = pixy2USBJNI.pixy2USBInit();
        if (init_result == 0) {
            pixy2USBJNI.pixy2USBGetVersion();
            pixy2USBJNI.pixy2USBLampOn();
            lampOn = true;

            CvSource outputStream = CameraServer.getInstance().putVideo("Target Reticle", PIXY2_RAW_FRAME_WIDTH, PIXY2_RAW_FRAME_HEIGHT);
            pixy2USBJNI.pixy2USBInitCameraServer(outputStream);

            while(true) {
                if (toggleLamp.get()) {
                    toggleLamp();
                    toggleLamp.set(false);
                }
                pixy2USBJNI.pixy2USBLoopCameraServer();
                pixy2USBJNI.loopfunc(); // Blocks too
            }
        } else {
            System.err.println("WARNING: is the Pixy2 plugged in???");
        }
    }



    private void loopfunc() {
        String visionStuffs = pixy2USBJNI.pixy2USBGetBlocks();

        if (visionStuffs.equals("")) {
            if (++cycleCounter > 100) {
                cycleCounter = 0;
                System.out.println("[INFO] No blocks detected");
            }
        return;
        }

        // Reset counter if there are blocks present
        cycleCounter = 0;

        String[] visionParts = visionStuffs.split("\n");
        blocks = new Block[visionParts.length];
        
        int arrayIndex = 0;
        
        for (String s : visionParts) {
        
            if(!s.isEmpty() && !s.isBlank() && !s.equals(null) && !s.equals("")) {
                try{
                    Scanner sc = new Scanner(s);
                    sc.next();
                    sc.next();
                    sc.next();
                    sc.next();
                    int sig = sc.nextInt();
                    sc.next();
                    int x = sc.nextInt();
                    sc.next();
                    int y = sc.nextInt();
                    sc.next();
                    int width = sc.nextInt();
                    sc.next();
                    int height = sc.nextInt();
                    sc.next();
                    int index = sc.nextInt();
                    sc.next();
                    int age = sc.nextInt();

                    if (sig == 1) // capture signature #1 items
                    blocks[arrayIndex++] = new Block(sig, x, y, width, height, index, age);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (Block b: blocks){
        System.out.println(b.toString());
        }
        synchronized(blocksBuffer) {
            if(blocksBuffer.remainingCapacity()==0) {
                blocksBuffer.remove();
            }
            try {
                blocksBuffer.put(blocks);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}