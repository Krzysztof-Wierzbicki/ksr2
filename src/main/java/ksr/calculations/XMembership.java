package ksr.calculations;

import ksr.model.Entity;

import java.util.function.Function;

public abstract class XMembership implements Function<Double, Double> {

    abstract Double apply(Entity entity) throws NoSuchFieldException, IllegalAccessException;
}
