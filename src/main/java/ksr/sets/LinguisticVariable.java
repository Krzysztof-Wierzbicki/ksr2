package ksr.sets;

import ksr.calculations.XMembership;
import ksr.model.Entity;

import java.util.function.Function;

// TODO: finish it
public class LinguisticVariable {

    public String name;
    public String extract;
    public XMembership extractor;
    public FuzzySet<Entity> set;
    public boolean absolute;

    public LinguisticVariable() {}

    public LinguisticVariable(String name, String extract, XMembership extractor, FuzzySet<Entity> set) {
        this.name = name;
        this.extract = extract;
        this.extractor = extractor;
        this.set = set;
    }

    public double getMembership(Entity entity) {
        return FuzzySet.getMembership(entity);
    }
}
