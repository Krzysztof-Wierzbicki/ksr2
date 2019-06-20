package ksr.calculations;

import ksr.model.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DiscreteMembership extends XMembership {

    private String fieldName;

    public DiscreteMembership(List<Double> parameters) {
        this.parameters = (ArrayList<Double>) parameters;
    }

    public DiscreteMembership(List<Double> parameters, String fieldName) {
        this.parameters = (ArrayList<Double>) parameters;
        this.fieldName = fieldName;
    }

    @Override
    public Double apply(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        Field field = entity.getClass().getField(fieldName);

        // TODO: implement - IFs in Triangular and Trapezoid classes for enums might be unnecessary and their place is here (?)

        return null;
    }

    @Override
    public double cardinality() {
        return parameters.stream().mapToDouble(a -> a).sum();
    }

    @Override
    public Double apply(Double x) {
        return parameters.get(x.intValue());
    }
}
