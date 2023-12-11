package edu.pr4.render;

import edu.pr4.AfineFactors;
import edu.pr4.Configuration;
import edu.pr4.Pixel;
import edu.pr4.tranformation.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadRender implements Render {
    private final ExecutorService executorService = Executors.newFixedThreadPool(Configuration.THREAD_COUNT);
    public static final int SKIP_STEP = 20;

    public MultiThreadRender() {

    }

    @Override
    public Pixel[][] render(List<Transformation> transformations) {
        var pixels = Pixel.initializePixels();
        var coefficients = AfineFactors.generateFactors();
        for (int i = 0; i < Configuration.THREAD_COUNT; i++) {
            executorService.submit(() -> RenderHelperFunc.createSamples(transformations, coefficients, pixels));
        }
        executorService.shutdownNow();
        return pixels;
    }

}
