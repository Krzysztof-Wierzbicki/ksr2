package ksr.calculations;

import ksr.model.Entity;

import java.lang.reflect.Field;

public class TrapezoidMembership extends XMembership {

    private Double a, b, c, d;
    private String fieldName;

    public TrapezoidMembership(Double a, Double b, Double c, Double d, String fieldName) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.fieldName = fieldName;
    }

    public TrapezoidMembership(int a, int b, int c, int d, String fieldName) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
        this.d = (double) d;
        this.fieldName = fieldName;
    }

    public Double apply(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        Field field = entity.getClass().getField(fieldName);

        if (field.getType().isAssignableFrom(Integer.TYPE)) {
            return apply(field.getDouble(entity));
        }

        // TODO: finish
        return 0.0;
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
