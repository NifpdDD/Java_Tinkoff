package edu.pr4;

import edu.pr4.render.MultiThreadRender;
import edu.pr4.tranformation.DiskTransformation;
import edu.pr4.tranformation.LinearTransformation;
import edu.pr4.tranformation.PolarTranformation;
import edu.pr4.tranformation.SphericalTransformation;
import edu.pr4.tranformation.Transformation;
import java.util.List;

public class Main {
    private Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        var render = new MultiThreadRender();
        List<Transformation> transformations = List.of(
            new PolarTranformation(),
            new LinearTransformation(),
            new SphericalTransformation(),
            new DiskTransformation()
        );
        var pivo = render.render(transformations);
        GammaCorrection.correction(pivo);
        ImageUtils.saveImage("fractal_flame.png", pivo);
    }
}
