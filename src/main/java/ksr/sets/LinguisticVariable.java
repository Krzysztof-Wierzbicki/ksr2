package ksr.sets;

import ksr.calculations.XMembership;
import ksr.model.Entity;

import java.util.function.Function;

public class LinguisticVariable {

    public String name;
    public XMembership xmembership;
    public Function<Entity, Double> extractor;
    public FuzzySet<Entity> set;
    public boolean absolute;

    public LinguisticVariable(String name, FuzzySet<Entity> set) {
        this.name = name;
        this.set = set;
    }

    public LinguisticVariable(String name, Function<Entity, Double> extractor, FuzzySet<Entity> set) {
        this.name = name;
        this.extractor = extractor;
        this.set = set;
    }

    public LinguisticVariable(String name, XMembership xmembership, boolean absolute) {
        this.name = name;
        this.xmembership = xmembership;
        this.absolute = absolute;
    }

    public double getMembership(Entity entity) {
        return set.getMembership(entity);
    }
}
