package edu.pr4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {
    private ImageUtils() {

    }

    static void saveImage(String filename, Pixel[][] pixels) {
        BufferedImage image = new BufferedImage(Configuration.XRES, Configuration.YRES, BufferedImage.TYPE_INT_RGB);
        int[] rgbArray = new int[Configuration.XRES * Configuration.YRES];

        for (int x = 0; x < Configuration.XRES; x++) {
            for (int y = 0; y < Configuration.YRES; y++) {
                int index = y * Configuration.XRES + x;
                rgbArray[index] = new Color((int) pixels[x][y].getRed(), (int) pixels[x][y].getGreen(),
                    (int) pixels[x][y].getBlue()
                ).getRGB();
            }
        }

        image.setRGB(0, 0, Configuration.XRES, Configuration.YRES, rgbArray, 0, Configuration.XRES);

        try {
            ImageIO.write(image, "png", new File(filename));
            System.out.println("Изображение сохранено успешно.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
