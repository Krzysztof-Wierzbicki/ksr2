package ksr.calculations;

import javafx.util.Pair;
import ksr.model.Entity;
import ksr.sets.FuzzySet;
import ksr.sets.LinguisticVariable;

import java.util.*;

public class Measures {

    // T1
    public static double degreeOfTruth(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) throws NoSuchFieldException, IllegalAccessException {
        double numerator = 0;
        double denominator = 0;

        for (Entity entity : entities) {
            numerator += Math.min(qualifier.getMembership(entity), summarizer.getMembership(entity));
            denominator += qualifier.getMembership(entity);
        }

        if (quantificator.absolute) {
            return quantificator.extractor.getMembership(numerator);
        }
        else {
            return quantificator.extractor.getMembership(numerator / denominator);
        }
    }

    // T2
    public static double degreeOfImprecision(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        double ret = 1;
        ArrayList<FuzzySet> sets = summarizer.set.getAllFuzzySets();

        for (FuzzySet set : sets) {
            ret *= set.degreeOfFuzziness(entities);
        }

        ret = Math.pow(ret, 1 / sets.size());
        return 1 - ret;
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

    // T4
    public static double degreeOfAppropriateness(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) throws NoSuchFieldException, IllegalAccessException {
        double ret = 1;
        ArrayList<FuzzySet> sets = summarizer.set.getAllFuzzySets();

        double t3 = degreeOfCovering(quantificator, qualifier, summarizer, entities);

        for (FuzzySet set : sets) {
            ret *= ((double) set.support(entities).size() / entities.size()) - t3;
        }

        return Math.abs(ret);
    }

    // T5
    public static double lengthOfSummary(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        return 2.0 * Math.pow(0.5, summarizer.set.getAllFuzzySets().size());
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

    // T8
    public static double degreeOfSummarizerCardinality(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        double ret = 1;
        var sets = summarizer.set.getAllFuzzySets();

        for (var set : sets) {
            ret *= set.cardinality() / entities.size();
        }

        ret = Math.pow(ret, 1.0 / sets.size());
        return 1 - ret;
    }

    // T9
    public static double degreeOfQualifierImprecision(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        return 1 - qualifier.set.degreeOfFuzziness(entities);
    }

    // T10
    public static double degreeOfQualifierCardinality(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        return 1 - qualifier.set.cardinality() / entities.size();
    }

    // T11
    public static double lengthOfQualifier(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) {
        return 2.0 * Math.pow(0.5, qualifier.set.getAllFuzzySets().size());
    }

    // custom, weighted measure
    public static Pair<Double, ArrayList<Double>> weightedMeasure(LinguisticVariable quantificator, LinguisticVariable qualifier, LinguisticVariable summarizer, List<Entity> entities) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Double> weightedValues;
        ArrayList<Double> measureValues = new ArrayList<>(Arrays.asList(
                degreeOfTruth(quantificator, qualifier, summarizer, entities),
                degreeOfImprecision(quantificator, qualifier, summarizer, entities),
                degreeOfCovering(quantificator, qualifier, summarizer, entities),
                degreeOfAppropriateness(quantificator, qualifier, summarizer, entities),
                lengthOfSummary(quantificator, qualifier, summarizer, entities),
                degreeOfQuantifierImprecision(quantificator, qualifier, summarizer, entities),
                degreeOfQuantifierCardinality(quantificator, qualifier, summarizer, entities),
                degreeOfSummarizerCardinality(quantificator, qualifier, summarizer, entities),
                degreeOfQualifierImprecision(quantificator, qualifier, summarizer, entities),
                degreeOfQualifierCardinality(quantificator, qualifier, summarizer, entities),
                lengthOfQualifier(quantificator, qualifier, summarizer, entities)
        ));

        measureValues.add(degreeOfQualifierImprecision(quantificator, qualifier, summarizer, entities));
        measureValues.add(degreeOfQualifierCardinality(quantificator, qualifier, summarizer, entities));
        measureValues.add(lengthOfQualifier(quantificator, qualifier, summarizer, entities));
        weightedValues = new ArrayList<>(Arrays.asList(
                measureValues.get(0) * 0.7,
                measureValues.get(1) * 0.03,
                measureValues.get(2) * 0.03,
                measureValues.get(3) * 0.03,
                measureValues.get(4) * 0.03,
                measureValues.get(5) * 0.03,
                measureValues.get(6) * 0.03,
                measureValues.get(7) * 0.03,
                measureValues.get(8) * 0.03,
                measureValues.get(9) * 0.03,
                measureValues.get(10) * 0.03
        ));

        double sum = weightedValues.stream().mapToDouble(n -> n).sum();
        return new Pair<>(sum, measureValues);
    }
}
