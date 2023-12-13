package edu.pr4.tranformation;

import edu.pr4.Point;

public class SphericalTransformation implements Transformation {

    @Override
    public Point transform(Point point) {
        double radius = 1 / (point.x() * point.x() + point.y() * point.y());
        double newX = radius * point.x();
        double newY = radius * point.y();
        return new Point(newX, newY);
    }
}
