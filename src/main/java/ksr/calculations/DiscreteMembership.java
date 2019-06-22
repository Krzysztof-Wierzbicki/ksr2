package ksr.calculations;

import ksr.model.Entity;

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
    public ArrayList<XMembership> getAll() {
        return new ArrayList<>(Arrays.asList(this));
    }

    @Override
    public Double getMembership(double x) {
        return parameters.get((int) x);
    }

    @Override
    public double cardinality() {
        return parameters.stream().mapToDouble(a -> a).sum();
    }
}
