package ksr.calculations;

import ksr.model.Entity;

import java.util.ArrayList;
import java.util.function.Function;

public abstract class XMembership implements Function<Double, Double> {

    public ArrayList<Double> parameters;

    public abstract Double apply(Entity entity) throws NoSuchFieldException, IllegalAccessException;
    public abstract double cardinality();
}
