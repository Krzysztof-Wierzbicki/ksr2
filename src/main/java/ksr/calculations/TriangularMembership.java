package ksr.calculations;

import ksr.model.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class TriangularMembership extends XMembership {

    private Double a, b, c;
    private String fieldName;

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

    public TriangularMembership(Double a, Double b, Double c, String fieldName) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fieldName = fieldName;
        parameters = new ArrayList<>(Arrays.asList(a, b, c));
    }

    public TriangularMembership(int a, int b, int c, String fieldName) {
        this.a = (double) a;
        this.b = (double) b;
        this.c = (double) c;
        this.fieldName = fieldName;
        parameters = new ArrayList<>(Arrays.asList((double) a, (double) b, (double) c));
    }

    public Double apply(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        Field field = entity.getClass().getField(fieldName);

        if (field.getType().isAssignableFrom(Integer.TYPE)) {
            return apply(field.getDouble(entity));
        }
        else if (field.getType().isAssignableFrom(Boolean.TYPE)) {
            return field.getBoolean(entity) ? 1.0 : 0.0;
        }
        else if (field.getType().getSimpleName().equals("Race")) {
            // TODO: implement
        }
        else if (field.getType().getSimpleName().equals("MaritalStatus")) {
            //
        }
        else if (field.getType().getSimpleName().equals("SchoolType")) {
            //
        }
        else if (field.getType().getSimpleName().equals("Degree")) {
            //
        }
        else if (field.getType().getSimpleName().equals("Religion")) {
            //
        }
        else if (field.getType().getSimpleName().equals("WorkType")) {
            //
        }

        throw new NoSuchFieldException();
    }

    @Override
    public double cardinality() {
        return 0.5 * (c - a);
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
