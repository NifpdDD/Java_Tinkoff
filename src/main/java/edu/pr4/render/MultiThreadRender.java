package edu.pr4.render;

import edu.pr4.AfineFactors;
import edu.pr4.Configuration;
import edu.pr4.Pixel;
import edu.pr4.tranformation.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadRender implements Render {
    private static final long MAX_WAITING_MINUTES_FOR_RENDERER = 3;
    private final ExecutorService executorService = Executors.newFixedThreadPool(Configuration.THREAD_COUNT);
    public static final int SKIP_STEP = 5;

    public MultiThreadRender() {

    }

    @Override
    public Pixel[][] render(List<Transformation> transformations) {
        var pixels = Pixel.initializePixels();
        var coefficients = AfineFactors.generateFactors();
        for (int i = 0; i < Configuration.THREAD_COUNT; i++) {
            executorService.execute(() -> RenderHelperFunc.createSamples(transformations, coefficients, pixels));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(MAX_WAITING_MINUTES_FOR_RENDERER, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pixels;
    }

}
