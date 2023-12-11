package edu.pr4;

public class GammaCorrection {
    private GammaCorrection() {

    }

    public static final double GAMMA = 2.2;

    public static Pixel[][]  correction(Pixel[][] pixels) {
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

        for (Pixel[] pixel : pixels) {
            for (int col = 0; col < pixels[0].length; col++) {
                pixel[col].setNormal(pixel[col].getNormal() / max);
                pixel[col].setRed(
                        Math.pow(pixel[col].getNormal(), (1.0 / GAMMA)) * pixel[col].getRed());
                pixel[col].setGreen(pixel[col].getGreen()
                        * Math.pow(pixel[col].getNormal(), (1.0 / GAMMA)));
                pixel[col].setBlue(pixel[col].getBlue()
                        * Math.pow(pixel[col].getNormal(), (1.0 / GAMMA)));
            }
        }

        return pixels;
    }
}
