package ksr.calculations;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstantMembership extends XMembership {

    public ConstantMembership() {}

    @Override
    public ArrayList<XMembership> getAll() {
        return new ArrayList<>(Arrays.asList(this));
    }

    @Override
    public Double getMembership(double x) {
        return 1.0;
    }

    @Override
    public double cardinality() {
        return 1.0;
    }
}
