package ksr.calculations;

import ksr.model.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class TrapezoidMembership extends XMembership {

    private Double a, b, c, d;
    private String fieldName;

    public TrapezoidMembership(Double a, Double b, Double c, Double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        parameters = new ArrayList<>(Arrays.asList(a, b, c, d));
    }

    public TrapezoidMembership(int a, int b, int c, int d) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
        this.d = (double) d;
        parameters = new ArrayList<>(Arrays.asList((double) a, (double) b, (double) c, (double) d));
    }

    public TrapezoidMembership(Double a, Double b, Double c, Double d, String fieldName) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.fieldName = fieldName;
        parameters = new ArrayList<>(Arrays.asList(a, b, c, d));
    }

    public TrapezoidMembership(int a, int b, int c, int d, String fieldName) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
        this.d = (double) d;
        this.fieldName = fieldName;
        parameters = new ArrayList<>(Arrays.asList((double) a, (double) b, (double) c, (double) d));
    }

    @Override
    public ArrayList<XMembership> getAll() {
        return new ArrayList<>(Arrays.asList(this));
    }

    @Override
    public Double getMembership(double x) {
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

    @Override
    public double cardinality() {
        return 0.5 * ((d - a) + (c - b));
    }
}
