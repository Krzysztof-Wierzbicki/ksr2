package ksr.sets;

import ksr.model.Entity;

import java.util.function.Function;

// TODO: finish it
public class LinguisticVariable {

    public String name;
    public String extract;
    public Function<Double, Double> extractor;
    public FuzzySet<Entity> set;
    public boolean absolute;

    public LinguisticVariable() {}

    public LinguisticVariable(String name, String extract, Function<Double, Double> extractor, FuzzySet<Entity> set) {
        this.name = name;
        this.extract = extract;
        this.extractor = extractor;
        this.set = set;
    }
}
