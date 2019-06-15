package ksr.calculations;

import java.util.function.Function;

public class TriangleMembership implements Function<Double, Double> {

    private Double a, b, c;

    public TriangleMembership(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Double apply(Double x) {
        if (a <= x && x <= b) {
            return (x - a) / (b - a);
        }
        else if (b <= x && x <= c) {
            return (c - x) / (c - b);
        }
        else {
            return 0.0;
        }
    }
}
