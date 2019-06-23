package ksr.sets;

import ksr.calculations.XMembership;
import ksr.model.Entity;

import java.util.function.Function;

public class LinguisticVariable {

    enum IsHave {
        IS,
        HAVE
    }

    public String name;
    public String category;
    public XMembership xmembership;
    public Function<Entity, Double> extractor;
    public FuzzySet<Entity> set;
    public boolean absolute;
    public IsHave isHave;

    public LinguisticVariable(String name, FuzzySet<Entity> set) {
        this.name = name;
        this.set = set;
        this.category = "";
    }

    public LinguisticVariable(String category, String name, FuzzySet<Entity> set) {
        this.name = name;
        this.set = set;
        this.category = category;
    }

    public LinguisticVariable(String name, Function<Entity, Double> extractor, FuzzySet<Entity> set, IsHave isHave) {
        this.name = name;
        this.extractor = extractor;
        this.set = set;
        this.category = "";
        this.isHave = isHave;
    }

    public LinguisticVariable(String category, String name, Function<Entity, Double> extractor, FuzzySet<Entity> set, IsHave isHave) {
        this.name = name;
        this.extractor = extractor;
        this.set = set;
        this.category = category;
        this.isHave = isHave;
    }

    public LinguisticVariable(String name, XMembership xmembership, boolean absolute) {
        this.name = name;
        this.xmembership = xmembership;
        this.absolute = absolute;
        this.category = "";
    }

    public LinguisticVariable(String category, String name, XMembership xmembership, boolean absolute) {
        this.name = name;
        this.xmembership = xmembership;
        this.absolute = absolute;
        this.category = category;
    }

    public double getMembership(Entity entity) {
        return set.getMembership(entity);
    }

    public String fullName(){
        return category + ": " + name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isDummy(){
        return false;
    }

    public String isHaveSimple(){
        if(isHave == IsHave.IS){
            return "are";
        }else{
            return "have";
        }
    }

    public String isHaveContinuous(){
        if(isHave == IsHave.IS){
            return "being";
        }else{
            return "having";
        }
    }
}
