package ksr.calculations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscreteMembership extends XMembership {

    public DiscreteMembership(List<Double> parameters) {
        this.parameters = (ArrayList<Double>) parameters;
    }

    public DiscreteMembership(Double... parameters) {
        this.parameters = new ArrayList<>(Arrays.asList(parameters));
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
