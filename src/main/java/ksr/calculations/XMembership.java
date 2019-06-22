package ksr.calculations;

import java.util.ArrayList;

public abstract class XMembership {

    public ArrayList<Double> parameters;

    public abstract ArrayList<XMembership> getAll();
    public abstract Double getMembership(double x);
    public abstract double cardinality();
}
