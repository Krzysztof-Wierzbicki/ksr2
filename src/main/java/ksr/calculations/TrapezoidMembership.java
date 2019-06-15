package ksr.calculations;

import java.util.function.Function;

public class TrapezoidMembership implements Function<Double, Double> {

    private Double a, b, c, d;

    public TrapezoidMembership(Double a, Double b, Double c, Double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public TrapezoidMembership(int a, int b, int c, int d) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
        this.d = (double) d;
    }

    @Override
    public Double apply(Double x) {
        if (a <= x && x <= b) {
            return (x - a) / (b - c);
        }
        else if (b <= x && x <= c) {
            return 1.0;
        }
        else if (c <= x && x <= d) {
            return (d - x) / (d - c);
        }
        else {
            return 0.0;
        }
    }
}
