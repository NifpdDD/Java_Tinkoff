package edu.pr4.render;

import edu.pr4.AfineFactors;
import edu.pr4.Configuration;
import edu.pr4.Pixel;
import edu.pr4.Point;
import edu.pr4.tranformation.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static edu.pr4.Point.rotate;

public class RenderHelperFunc {
    private RenderHelperFunc() {

    }

    public static Pixel getNewColor(Pixel pixel, AfineFactors coefficient) {
        if (pixel.getCounter() == 0) {
            pixel.setRed(coefficient.startRed());
            pixel.setGreen(coefficient.startGreen());
            pixel.setBlue(coefficient.startBlue());
        } else {
            pixel.setRed((pixel.getRed() + coefficient.startRed()) / 2);
            pixel.setGreen((pixel.getGreen() + coefficient.startGreen()) / 2);
            pixel.setBlue((pixel.getBlue() + coefficient.startBlue()) / 2);
        }
        pixel.incCounter();
        return pixel;
    }


    public static void drawingPixel(
        int step,
        double newX,
        double newY,
        Point point,
        Pixel[][] pixels,
        AfineFactors coefficient
    ) {
        if (step >= 0 && newX >= Configuration.XMIN && newX <= Configuration.XMAX
            && newY >= Configuration.YMIN && newY <= Configuration.YMAX) {
            double theta2 = 0.0;
            for (int s = 0; s < Configuration.SYMMERTY; s++) {
                theta2 += (Math.PI * 2) / Configuration.SYMMERTY;
                var rotated = rotate(point, theta2);
                int x1 =
                    (int) (Configuration.XRES
                        - (Configuration.XMAX - rotated.x()) / (Configuration.XMAX - Configuration.XMIN)
                        * Configuration.XRES);
                int y1 =
                    (int) (Configuration.YRES
                        - (Configuration.YMAX - rotated.y()) / (Configuration.YMAX - Configuration.YMIN)
                        * Configuration.YRES);
                if (x1 >= 0 && x1 < Configuration.XRES && y1 >= 0 && y1 < Configuration.YRES) {
                    synchronized (pixels[x1][y1]) {
                        pixels[x1][y1] = getNewColor(pixels[x1][y1], coefficient);
                    }
                }
            }
        }
    }

    public static void createSamples(
        List<Transformation> transformations,
        AfineFactors[] coefficients,
        Pixel[][] pixels
    ) {
        for (int num = 0; num < Configuration.SAMPLES / Configuration.THREAD_COUNT; num++) {
            double newX = ThreadLocalRandom.current().nextDouble(Configuration.XMIN, Configuration.XMAX);
            double newY = ThreadLocalRandom.current().nextDouble(Configuration.YMIN, Configuration.YMAX);

            for (int step = -MultiThreadRender.SKIP_STEP; step < Configuration.ITERATIONS_PER_SAMPLE; step++) {
                var transformation =
                    transformations.get(ThreadLocalRandom.current().nextInt(transformations.size()));
                var coefficient = coefficients[ThreadLocalRandom.current().nextInt(Configuration.AFFINE_COUNT)];
                Point point = AfineFactors.getCurrentAfine(coefficient, newX, newY);
                point = transformation.transform(point);
                newX = point.x();
                newY = point.y();
                drawingPixel(step, newX, newY, point, pixels, coefficient);
            }
        }
    }
}
