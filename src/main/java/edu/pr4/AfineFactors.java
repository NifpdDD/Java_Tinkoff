package edu.pr4;

import java.util.Random;

public record AfineFactors(double a, double b, double c, double d, double e, double f, double startRed,
                           double startGreen, double startBlue) {
    public static final Random RANDOM = new Random();

    public static AfineFactors[] generateFactors() {
        var coefficients = new AfineFactors[Configuration.AFFINE_COUNT];
        for (int i = 0; i < Configuration.AFFINE_COUNT; i++) {
            coefficients[i] = new AfineFactors(
                generateRandomCoeff(),
                generateRandomCoeff(),
                generateRandomCoeff(),
                generateRandomCoeff(),
                generateRandomCoeff(),
                generateRandomCoeff(),
                generateRandomColor(),
                generateRandomColor(),
                generateRandomColor()
            );
        }
        return coefficients;
    }

    @SuppressWarnings("MagicNumber")
    private static double generateRandomColor() {
        return RANDOM.nextInt(0, 256);
    }

    private static double generateRandomCoeff() {
        return RANDOM.nextDouble(-1.5, 1.5);
    }

    public static Point getCurrentAfine(AfineFactors coefficient, double newX, double newY) {
        double x = coefficient.a() * newX + coefficient.b() * newY + coefficient.c();
        double y = coefficient.d() * newX + coefficient.e() * newY + coefficient.f();
        return new Point(x, y);
    }
}
