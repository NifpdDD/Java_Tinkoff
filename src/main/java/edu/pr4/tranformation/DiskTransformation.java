package edu.pr4.tranformation;

import edu.pr4.Point;

public class DiskTransformation implements Transformation {
    @Override
    public Point transform(Point point) {
        double radius = Math.sqrt(point.x() * point.x() + point.y() * point.y()) * Math.PI;
        double theta = Math.atan2(point.y(), point.x()) / Math.PI;
        double newX = theta * Math.sin(radius);
        double newY = theta * Math.cos(radius);
        return new Point(newX, newY);
    }
}
