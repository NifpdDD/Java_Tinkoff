package edu.pr4;

import edu.pr4.render.MultiThreadRender;
import edu.pr4.render.SingleThreadRender;
import edu.pr4.tranformation.DiskTransformation;
import edu.pr4.tranformation.LinearTransformation;
import edu.pr4.tranformation.PolarTranformation;
import edu.pr4.tranformation.SphericalTransformation;
import edu.pr4.tranformation.Transformation;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        long startTimeMultiThreaded = System.nanoTime();
        var renderMultiThreaded = new MultiThreadRender();
        List<Transformation> transformations = List.of(
            new PolarTranformation(),
            new LinearTransformation(),
            new SphericalTransformation(),
            new DiskTransformation()
        );
        var pixelsMultiThreaded = renderMultiThreaded.render(transformations);
        GammaCorrection.correction(pixelsMultiThreaded);
        ImageUtils.saveImage("fractal_flame_multi_threaded.png", pixelsMultiThreaded);
        long endTimeMultiThreaded = System.nanoTime();
        LOGGER.info("Multi-threaded rendering time: " + (endTimeMultiThreaded - startTimeMultiThreaded));

        long startTimeSingleThreaded = System.nanoTime();
        var renderSingleThreaded = new SingleThreadRender();

        var pixelsSingleThreaded = renderSingleThreaded.render(transformations);
        GammaCorrection.correction(pixelsSingleThreaded);
        ImageUtils.saveImage("fractal_flame_single_threaded.png", pixelsSingleThreaded);
        long endTimeSingleThreaded = System.nanoTime();
        LOGGER.info("Single-threaded rendering time: " + (endTimeSingleThreaded - startTimeSingleThreaded));
    }
}
