package edu.pr4;

public class Configuration {
    public static final int THREAD_COUNT = 12;

    private Configuration() {
    }

    public static final int XRES = 1920;
    public static final int YRES = 1080;
    public static final int SAMPLES = 50_000;
    public static final int AFFINE_COUNT = 10;
    public static final double XMIN = -1.777;
    public static final double XMAX = 1.777;
    public static final double YMIN = -1;
    public static final double YMAX = 1;
    public static final int SYMMERTY = 1;
    public static final int ITERATIONS_PER_SAMPLE = 100;
}
