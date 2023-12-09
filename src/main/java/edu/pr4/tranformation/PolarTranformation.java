package edu.pr4.tranformation;

import edu.pr4.Point;

public class PolarTranformation implements Transformation {

    @Override
    public Point transform(Point point) {
        double newX = Math.atan2(point.y(), point.x());
        double newY = Math.sqrt(point.x() * point.x() + point.y() * point.y()) - 1;
        return new Point(newX, newY);
    }
}
