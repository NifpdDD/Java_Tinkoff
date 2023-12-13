package edu.pr4;

public class GammaCorrection {
    private GammaCorrection() {

    }

    public static final double GAMMA = 0.5;

    static void correction(Pixel[][] pixels) {
        var max = 0.0;

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                if (pixels[row][col].getCounter() != 0) {
                    pixels[row][col].setNormal(Math.log10(pixels[row][col].getCounter()));
                    if (pixels[row][col].getNormal() > max) {
                        max = pixels[row][col].getNormal();
                    }
                }
            }
        }

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                pixels[row][col].setNormal(pixels[row][col].getNormal() / max);
                pixels[row][col].setRed(
                    Math.pow(pixels[row][col].getNormal(), (1.0 / GAMMA)) * pixels[row][col].getRed());
                pixels[row][col].setGreen(pixels[row][col].getGreen()
                    * Math.pow(pixels[row][col].getNormal(), (1.0 / GAMMA)));
                pixels[row][col].setBlue(pixels[row][col].getBlue()
                    * Math.pow(pixels[row][col].getNormal(), (1.0 / GAMMA)));
            }
        }
    }
}
