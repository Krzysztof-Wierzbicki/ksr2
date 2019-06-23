package ksr.calculations;

import java.util.ArrayList;
import java.util.Arrays;

public class TriangularMembership extends XMembership {

    private Double a, b, c;

    public TriangularMembership(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        parameters = new ArrayList<>(Arrays.asList(a, b, c));
    }

    public TriangularMembership(int a, int b, int c) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
        parameters = new ArrayList<>(Arrays.asList((double) a, (double) b, (double) c));
    }

    @Override
    public ArrayList<XMembership> getAll() {
        return new ArrayList<>(Arrays.asList(this));
    }

    @Override
    public Double getMembership(double x) {
        if (a <= x && x < b) {
            return (x - a) / (b - a);
        }
        else if (x == b) {
            return 1.0;
        }
        else if (b < x && x <= c) {
            return (c - x) / (c - b);
        }
        else {
            return 0.0;
        }
    }

    @Override
    public double cardinality() {
        return 0.5 * (c - a);
    }
}
