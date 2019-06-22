package ksr.sets;

import ksr.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class And extends FuzzySet<Entity> {

    public static FuzzySet<Entity> set1;
    public static FuzzySet<Entity> set2;

    public static double getMembership(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        return Math.min(set1.getMembership(entity), set2.getMembership(entity));
    }

    public ArrayList<Entity> support(List<Entity> entities) {
        FuzzySet<Entity> intersection = intersection(set1, set2);

        return new ArrayList<>(intersection.keys());
    }

    public double getDegreeOfFuzziness(List<Entity> entities) {
        return set1.getDegreeOfFuzziness(entities) * set2.getDegreeOfFuzziness(entities);
    }

    public ArrayList<FuzzySet> getAllFuzzySets() {
        ArrayList<FuzzySet> ret = set1.getAllFuzzySets();
        ret.add(set2);
        return ret;
    }

    public void setAllFuzzySets(List<FuzzySet> sets) {
        set1 = sets.get(0);
        set2 = sets.get(1);
    }
}
