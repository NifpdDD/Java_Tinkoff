package edu.pr4.render;

import edu.pr4.AfineFactors;
import edu.pr4.Configuration;
import edu.pr4.Pixel;
import edu.pr4.tranformation.Transformation;
import java.util.List;

public class SingleThreadRender implements Render {

    @Override
    public Pixel[][] render(List<Transformation> transformations) {
        var pixels = Pixel.initializePixels();
        var coefficients = AfineFactors.generateFactors();
        for (int i = 0; i < Configuration.THREAD_COUNT; i++) {
            RenderHelperFunc.createSamples(transformations, coefficients, pixels);
        }
        return pixels;
    }

}
