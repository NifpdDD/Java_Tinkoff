package edu.pr4;

public final class Pixel {
    private int counter;
    private double red;
    private double green;
    private double blue;
    private double normal;

    public Pixel(double red, double green, double blue, double normal) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.normal = normal;
        this.counter = 0;
    }

    public static Pixel[][] initializePixels() {
        var pixels = new Pixel[Configuration.XRES][Configuration.YRES];
        for (int x = 0; x < Configuration.XRES; x++) {
            for (int y = 0; y < Configuration.YRES; y++) {
                pixels[x][y] = new Pixel(0, 0, 0, 0);
            }
        }
        return pixels;
    }

    public int getCounter() {
        return counter;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getNormal() {
        return normal;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    public void incCounter() {
        this.counter++;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }
}

