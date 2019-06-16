package ksr.calculations;

import ksr.model.Entity;
import ksr.sets.LinguisticVariable;

import java.util.List;

// TODO: implement T2, T4, T5, T8, T9, T10, T11
public class Measures {

    // T1
    public static double degreeOfTruth(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) throws NoSuchFieldException, IllegalAccessException {
        double numerator = 0;
        double denominator = 0;

        for (Entity entity : entities) {
            numerator += Math.min(qualifier.getMembership(entity), summarizer.getMembership(entity));
            denominator += qualifier.extractor.apply(entity);
        }

        if (quantificator.absolute) {
            return quantificator.extractor.apply(numerator);
        }
        else {
            return quantificator.extractor.apply(numerator / denominator);
        }
    }

    // T2 <
    public static double degreeOfImprecision() {
        return 0;
    }

    // T3
    public static double degreeOfCovering(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) throws NoSuchFieldException, IllegalAccessException {
        double numerator = 0;
        double denominator = 0;

        for (Entity entity : entities) {
            double qualifierMembership = qualifier.getMembership(entity);
            double summarizerMembership = summarizer.getMembership(entity);

            if (qualifierMembership > 0) {
                denominator++;
                if (summarizerMembership > 0) {
                    numerator++;
                }
            }
        }

        return numerator / denominator;
    }

    // T4 <
    public static double degreeOfAppropriateness() {
        return 0;
    }

    // T5 <
    public static double lengthOfSummary() {
        return 0;
    }

    // T6
    public static double degreeOfQuantifierImprecision(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        double ret = quantificator.extractor.parameters.get(quantificator.extractor.parameters.size() - 1) - quantificator.extractor.parameters.get(0);

        if (quantificator.absolute) {
            ret /= entities.size();
        }

        return 1 - ret;
    }

    // T7
    public static double degreeOfQuantifierCardinality(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        double ret = quantificator.extractor.cardinality();

        if (quantificator.absolute) {
            ret /= entities.size();
        }

        return 1 - ret;
    }

    // T8 <
    public static double degreeOfSummarizerCardinality() {
        return 0;
    }

    // T9 <
    public static double degreeOfQualifierImprecision() {
        return 0;
    }

    // T10 <
    public static double degreeOfQualifierCardinality() {
        return 0;
    }

    // T11 <
    public static double lengthOfQualifier() {
        return 0;
    }
}
