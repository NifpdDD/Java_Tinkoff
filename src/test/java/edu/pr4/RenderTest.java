package edu.pr4;

import edu.pr4.render.MultiThreadRender;
import edu.pr4.render.SingleThreadRender;
import edu.pr4.tranformation.LinearTransformation;
import edu.pr4.tranformation.Transformation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.pr4.Configuration.XRES;
import static edu.pr4.Configuration.YRES;

class RenderTest {
    @Test
    void if_call_render_multi_should_return_pixels() {
        var render = new MultiThreadRender();
        List<Transformation> transformations = List.of(new LinearTransformation());
        var pixels = render.render(transformations);

        Assertions.assertThat(pixels.length).isEqualTo(XRES);
        Assertions.assertThat(pixels[0].length).isEqualTo(YRES);
    }

    @Test
    void if_call_render_single_should_return_pixels() {
        var render = new SingleThreadRender();
        List<Transformation> transformations = List.of(new LinearTransformation());
        var pixels = render.render(transformations);

        Assertions.assertThat(pixels.length).isEqualTo(XRES);
        Assertions.assertThat(pixels[0].length).isEqualTo(YRES);
    }

}
