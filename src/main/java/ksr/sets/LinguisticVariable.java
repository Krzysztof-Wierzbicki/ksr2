package ksr.sets;

import ksr.calculations.XMembership;
import ksr.model.Entity;

public class LinguisticVariable {

    public String name;
    public String extractName;
    public XMembership extractor;
    public FuzzySet<Entity> set;
    public boolean absolute;

    public LinguisticVariable() {}

    public LinguisticVariable(String name, String extractName, XMembership extractor, FuzzySet<Entity> set) {
        this.name = name;
        this.extractName = extractName;
        this.extractor = extractor;
        this.set = set;
    }

    public LinguisticVariable(String name, XMembership extractor, boolean absolute) {
        this.name = name;
        this.extractor = extractor;
        this.absolute = absolute;
    }

    public double getMembership(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        return FuzzySet.getMembership(entity);
    }
}
