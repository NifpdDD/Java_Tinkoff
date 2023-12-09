package edu.pr4.tranformation;

import edu.pr4.Point;

public class LinearTransformation implements Transformation {
    @Override
    public Point transform(Point point) {
        return point;
    }
}
