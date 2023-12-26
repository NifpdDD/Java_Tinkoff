package edu.pr4.render;

import edu.pr4.Pixel;
import edu.pr4.tranformation.Transformation;
import java.util.List;

public interface Render {
    Pixel[][] render(List<Transformation> transformationList);
}
