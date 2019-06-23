package ksr.sets;

import ksr.model.Degree;
import ksr.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EnumFuzzySet<Enum> extends FuzzySet<Entity> {

    public EnumFuzzySet(Function<Entity, Double> extractor){
        this.extractor = extractor;
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
        for(Enum e : Enum.values()){
            Entity ent = new Entity();
            if(e instanceof Degree){
                ent.degree = (Degree) e;
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
