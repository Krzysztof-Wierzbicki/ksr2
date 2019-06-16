package ksr.calculations;

import ksr.model.Entity;
import ksr.sets.LinguisticVariable;

import java.util.List;

// TODO: implement
public class Measures {

    // T1
    public static double degreeOfTruth(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) throws NoSuchFieldException, IllegalAccessException {
        /*double up = 0;
        double down = 0;

        for (Entity entity : entities) {
            up += Math.min(qualifier.getMembership(entity), summarizer.getMembership(entity));
            down += qualifier.extractor.apply(entity);
        }*/
        return 0;
    }

    // T2
    public static double degreeOfImprecision() {
        return 0;
    }

    // T3
    public static double degreeOfCovering() {
        return 0;
    }

    // T4
    public static double degreeOfAppropriateness() {
        return 0;
    }

    // T5
    public static double lengthOfSummary() {
        return 0;
    }

    // T6
    public static double degreeOfQuantifierImprecision() {
        return 0;
    }

    // T7
    public static double degreeOfQuantifierCardinality() {
        return 0;
    }

    // T8
    public static double degreeOfSummarizerCardinality() {
        return 0;
    }

    // T9
    public static double degreeOfQualifierImprecision() {
        return 0;
    }

    // T10
    public static double degreeOfQualifierCardinality() {
        return 0;
    }

    // T11
    public static double lengthOfQualifier() {
        return 0;
    }
}
