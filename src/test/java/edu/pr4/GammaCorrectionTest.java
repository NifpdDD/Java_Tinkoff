package edu.pr4;

import edu.pr4.render.MultiThreadRender;
import edu.pr4.tranformation.LinearTransformation;
import edu.pr4.tranformation.Transformation;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GammaCorrectionTest {
    @Test
    void if_call_correction_should_return_correct_pixels() {
        var render = new MultiThreadRender();
        List<Transformation> transformations = List.of(new LinearTransformation());
        var pixels = render.render(transformations);
        var pixelsWithOutGamma = pixels.clone();

        GammaCorrection.correction(pixels);

        for(int i = 0; i < pixels.length;i++){
            for (int j = 0; j < pixels[0].length;j++){
                Assertions.assertThat(pixels[i][j].getRed()).isLessThanOrEqualTo(pixelsWithOutGamma[i][j].getRed());
                Assertions.assertThat(pixels[i][j].getGreen()).isLessThanOrEqualTo(pixelsWithOutGamma[i][j].getGreen());
                Assertions.assertThat(pixels[i][j].getBlue()).isLessThanOrEqualTo(pixelsWithOutGamma[i][j].getBlue());
            }
        }
    }

}
