package ksr.calculations;

import ksr.model.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscreteMembership extends XMembership {

    private String fieldName;

    public DiscreteMembership(List<Double> parameters) {
        this.parameters = (ArrayList<Double>) parameters;
    }

    public DiscreteMembership(Double... parameters) {
        this.parameters = new ArrayList<>(Arrays.asList(parameters));
    }

    public DiscreteMembership(String fieldName, List<Double> parameters) {
        this.parameters = (ArrayList<Double>) parameters;
        this.fieldName = fieldName;
    }

    public DiscreteMembership(String fieldName, Double... parameters) {
        this.parameters = new ArrayList<>(Arrays.asList(parameters));
        this.fieldName = fieldName;
    }

    @Override
    public Double apply(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        Field field = entity.getClass().getField(fieldName);

        // TODO: implement - IFs in Triangular and Trapezoid classes for enums might be unnecessary and their place is here (?)

        return 0.;
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
