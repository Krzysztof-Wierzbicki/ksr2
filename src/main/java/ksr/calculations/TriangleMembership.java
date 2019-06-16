package ksr.calculations;

import ksr.model.Entity;

import java.lang.reflect.Field;
import java.util.function.Function;

public class TriangleMembership extends XMembership {

    private Double a, b, c;
    private String fieldName;

    public TriangleMembership(Double a, Double b, Double c, String fieldName) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fieldName = fieldName;
    }

    public TriangleMembership(int a, int b, int c, String fieldName) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
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
