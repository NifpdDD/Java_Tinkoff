package edu.pr4;

import edu.pr4.render.MultiThreadRender;
import edu.pr4.tranformation.LinearTransformation;
import edu.pr4.tranformation.Transformation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ImageUtilsTest {
    @Test
    void if_save_image_should_save_image(@TempDir Path tempDir) throws IOException {
        var render = new MultiThreadRender();
        List<Transformation> transformations = List.of(
            new LinearTransformation()
        );
        var pixels = render.render(transformations);
        GammaCorrection.correction(pixels);

        String imageFileName = "fractal_flame.png";
        Path imagePath = tempDir.resolve(imageFileName);
        ImageUtils.saveImage(imagePath.toString(), pixels);

        Assertions.assertThat(imagePath).exists();
    }
}
