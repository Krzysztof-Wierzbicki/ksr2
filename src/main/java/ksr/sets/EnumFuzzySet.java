package ksr.sets;

import ksr.model.Degree;
import ksr.model.Entity;
import ksr.model.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EnumFuzzySet<T extends Enum<T>> extends FuzzySet<Entity> {

    private Class<? extends Enum> enumClass;

    public EnumFuzzySet(Function<Entity, Double> extractor, T val){
        this.extractor = extractor;
        this.enumClass = val.getClass();
    }

    public EnumFuzzySet() {
        super();
    }

    @Override
    public double getMembership(Entity entity) {
        return extractor.apply(entity);
    }

    @Override
    public double cardinality() {
        double sum = 0;
        for(Enum e : enumClass.getEnumConstants()){
            Entity ent = new Entity();
            if(enumClass == Degree.class || e instanceof Degree){
                ent.degree = (Degree) e;
            }else if(enumClass == Race.class || e instanceof Race){
                ent.race = (Race) e;
            }
            sum += extractor.apply(ent);
        }
        return sum;
    }

    @Override
    public double degreeOfFuzziness(List<Entity> entities) {
        return (double) support(entities).size()/entities.size();
    }

    @Override
    public ArrayList<Entity> support(List<Entity> entities) {
        ArrayList<Entity> res = new ArrayList<>();
        for(Entity ent : entities){
            if(extractor.apply(ent) > 0){
                res.add(ent);
            }
        }
        return res;
    }
}
