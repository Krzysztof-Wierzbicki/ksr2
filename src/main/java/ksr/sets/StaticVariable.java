package ksr.sets;

import ksr.calculations.ConstantMembership;
import ksr.calculations.TrapezoidMembership;
import ksr.calculations.TriangularMembership;
import ksr.model.Degree;
import ksr.model.Entity;
import ksr.model.Race;

import java.util.*;
import java.util.function.Function;

public class StaticVariable {

    // TODO: religion, everWorked, workType
    //<editor-fold desc="race">
    private static Function<Entity, Double> whiteFunc = entity -> (entity.race == Race.white) ? 1. : 0.;
    private static Function<Entity, Double> blackFunc = entity -> (entity.race == Race.black) ? 1. : 0.;
    private static Function<Entity, Double> hispanicFunc = entity -> (entity.race == Race.hispanic) ? 1. : 0.;
    private static Function<Entity, Double> otherFunc = entity -> (entity.race == Race.other) ? 1. : 0.;
    public static LinguisticVariable raceWhite = new LinguisticVariable(
            "race", "white",
            whiteFunc,
            new EnumFuzzySet<>(whiteFunc, Race.other),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable raceBlack = new LinguisticVariable(
            "race", "black",
            blackFunc,
            new EnumFuzzySet<>(blackFunc, Race.other),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable raceHispanic = new LinguisticVariable(
            "race", "hispanic",
            hispanicFunc,
            new EnumFuzzySet<>(hispanicFunc, Race.other),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable raceOther = new LinguisticVariable(
            "race", "other",
            otherFunc,
            new EnumFuzzySet<>(otherFunc, Race.other),
            LinguisticVariable.IsHave.IS
    );
    //</editor-fold desc="race">
    //<editor-fold desc="age">
    public static LinguisticVariable ageTeen = new LinguisticVariable(
            "age", "teen",
            x -> new TrapezoidMembership(15, 15, 17, 19).getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(15, 15, 17, 15),
                    x -> (double) x.age
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable ageYoungAdult = new LinguisticVariable(
            "age", "young adult",
            x -> new TrapezoidMembership(18, 20, 25, 27).getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(18, 20, 25, 27),
                    x -> (double) x.age
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable ageAdult = new LinguisticVariable(
            "age", "adult",
            x -> new TrapezoidMembership(26, 29, 33, 39).getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(26, 29, 33, 39),
                    x -> (double) x.age
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable ageOldAdult = new LinguisticVariable(
            "age", "old adult",
            x -> new TrapezoidMembership(35, 40, 44, 44).getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(35, 40, 44, 44),
                    x -> (double) x.age
            ),
            LinguisticVariable.IsHave.IS
    );
    //</editor-fold desc="age">
    //<editor-fold desc="maritalStatus">
    //</editor-fold desc="maritalStatus">
    //<editor-fold desc="numberOfKids">
    public static LinguisticVariable kidsFew = new LinguisticVariable(
            "number of kids", "few kids",
            x -> new TriangularMembership(0, 0, 3).getMembership(x.numberOfKids),
            new FuzzySet<>(
                    new TriangularMembership(0, 0, 3),
                    x -> (double) x.numberOfKids
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable kidsMany = new LinguisticVariable(
            "number of kids", "many kids",
            x -> new TriangularMembership(2, 5, 5).getMembership(x.numberOfKids),
            new FuzzySet<>(
                    new TriangularMembership(2, 5, 5),
                    x -> (double) x.numberOfKids
            ),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc="numberOfKids">
    //<editor-fold desc="yearsOfEducation">
    public static LinguisticVariable fewYears = new LinguisticVariable(
            "years of education", "few",
            x -> new TrapezoidMembership(9, 9, 10, 12).getMembership(x.yearsOfEducation),
            new FuzzySet<>(
                    new TrapezoidMembership(9, 9, 10, 12),
                    x -> (double) x.yearsOfEducation
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable normalYears = new LinguisticVariable(
            "years of education", "normal",
            x -> new TrapezoidMembership(10, 12, 14, 15).getMembership(x.yearsOfEducation),
            new FuzzySet<>(
                    new TrapezoidMembership(10, 12, 14, 15),
                    x -> (double) x.yearsOfEducation
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable manyYears = new LinguisticVariable(
            "years of education", "many",
            x -> new TrapezoidMembership(14, 16, 20, 20).getMembership(x.yearsOfEducation),
            new FuzzySet<>(
                    new TrapezoidMembership(14, 16, 20, 20),
                    x -> (double) x.yearsOfEducation
            ),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc="yearsOfEducation">
    //<editor-fold desc="degree">
    static Function<Entity, Double> lowerDegreeFunction = entity -> {
        if(entity.degree == Degree.associate){
            return 1.;
        }else if(entity.degree == Degree.none){
            return 0.2;
        }
        return 0.;
    };
    static Function<Entity, Double> mediumDegreeFunction = entity -> {
        if(entity.degree == Degree.bachelor){
            return 0.5;
        }else if(entity.degree == Degree.master) {
            return 1.;
        }else if(entity.degree == Degree.professional){
            return 0.8;
        }else if(entity.degree == Degree.doctorate){
            return 0.2;
        }
        return 0.;
    };
    static Function<Entity, Double> higherDegreeFunction = entity -> {
        if(entity.degree == Degree.doctorate){
            return 1.;
        }else if(entity.degree == Degree.professional){
            return 0.7;
        }
        return 0.;
    };
    public static LinguisticVariable lowerDegree = new LinguisticVariable(
            "degree", "lower degree",
            lowerDegreeFunction,
            new EnumFuzzySet<>(lowerDegreeFunction, Degree.none),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable mediumDegree = new LinguisticVariable(
            "degree", "medium degree",
            mediumDegreeFunction,
            new EnumFuzzySet<>(mediumDegreeFunction, Degree.none),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable higherDegree = new LinguisticVariable(
            "degree", "higher degree",
            higherDegreeFunction,
            new EnumFuzzySet<>(higherDegreeFunction, Degree.none),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc="degree">
    //<editor-fold desc="pregnancyCount">
    public static LinguisticVariable pregnanciesLow = new LinguisticVariable(
            "pregnancy count", "low amount of pregnancies",
            x -> new TrapezoidMembership(0, 0, 2, 6).getMembership(x.pregnancyCount),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 2, 6),
                    x -> (double) x.pregnancyCount
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable pregnanciesMedium = new LinguisticVariable(
            "pregnancy count", "medium amount of pregnancies",
            x -> new TrapezoidMembership(4, 6, 8, 10).getMembership(x.pregnancyCount),
            new FuzzySet<>(
                    new TrapezoidMembership(4, 6, 8, 10),
                    x -> (double) x.pregnancyCount
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable pregnanciesHigh = new LinguisticVariable(
            "pregnancy count", "high amount of pregnancies",
            x -> new TrapezoidMembership(8, 10, 20, 20).getMembership(x.pregnancyCount),
            new FuzzySet<>(
                    new TrapezoidMembership(8, 10, 20, 20),
                    x -> (double) x.pregnancyCount
            ),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc="pregnancyCount">
    //<editor-fold desc="marriageCount">
    public static LinguisticVariable marriagesFew = new LinguisticVariable(
            "marriage count", "few marriages",
            x -> new TriangularMembership(0, 0, 3).getMembership(x.marriageCount),
            new FuzzySet<>(
                    new TriangularMembership(0, 0, 3),
                    x -> (double) x.marriageCount
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable marriagesMany = new LinguisticVariable(
            "marriage count", "many marriages",
            x -> new TrapezoidMembership(2, 3, 6, 6).getMembership(x.marriageCount),
            new FuzzySet<>(
                    new TrapezoidMembership(2, 3, 6, 6),
                    x -> (double) x.marriageCount
            ),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc="marriageCount">
    //<editor-fold desc="religion">
    //</editor-fold desc="religion">
    //<editor-fold desc="everWorked">
    //</editor-fold desc="everWorked">
    //<editor-fold desc="workType">
    //</editor-fold desc="workType">
    //<editor-fold desc="weight">
    public static LinguisticVariable weightLight = new LinguisticVariable(
            "weight", "light",
            x -> new TrapezoidMembership(0, 0, 50, 57).getMembership(x.weight),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 50, 57),
                    x -> (double) x.weight
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable weightMedium = new LinguisticVariable(
            "weight", "medium",
            x -> new TrapezoidMembership(53, 60, 65, 72).getMembership(x.weight),
            new FuzzySet<>(
                    new TrapezoidMembership(53, 60, 65, 72),
                    x -> (double) x.weight
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable weightHeavy = new LinguisticVariable(
            "weight", "heavy",
            x -> new TrapezoidMembership(70, 80, 125, 125).getMembership(x.weight),
            new FuzzySet<>(
                    new TrapezoidMembership(70, 80, 125, 125),
                    x -> (double) x.weight
            ),
            LinguisticVariable.IsHave.IS
    );
    //</editor-fold desc="weight">
    //<editor-fold desc="height">
    public static LinguisticVariable heightShort = new LinguisticVariable(
            "height", "short",
            x -> new TrapezoidMembership(0, 0, 150, 165).getMembership(x.height),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 150, 165),
                    x -> (double) x.height
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable heightMedium = new LinguisticVariable(
            "height", "medium",
            x -> new TrapezoidMembership(160, 165, 170, 175).getMembership(x.height),
            new FuzzySet<>(
                    new TrapezoidMembership(160, 165, 170, 175),
                    x -> (double) x.height
            ),
            LinguisticVariable.IsHave.IS
    );
    public static LinguisticVariable heightTall = new LinguisticVariable(
            "height", "tall",
            x -> new TrapezoidMembership(170, 175, 180, 180).getMembership(x.height),
            new FuzzySet<>(
                    new TrapezoidMembership(170, 175, 180, 180),
                    x -> (double) x.height
            ),
            LinguisticVariable.IsHave.IS
    );
    //</editor-fold desc="height">
    //<editor-fold desc="earnings">
    public static LinguisticVariable earningsLow = new LinguisticVariable(
            "earnings", "low earnings",
            x -> new TrapezoidMembership(0, 0, 12500, 25000).getMembership(x.earnings),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 12500, 2500),
                    x -> (double) x.earnings
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable earningsMedium = new LinguisticVariable(
            "earnings", "medium earnings",
            x -> new TrapezoidMembership(20000, 25000, 35000, 40000).getMembership(x.earnings),
            new FuzzySet<>(
                    new TrapezoidMembership(20000, 25000, 35000, 40000),
                    x -> (double) x.earnings
            ),
            LinguisticVariable.IsHave.HAVE
    );
    public static LinguisticVariable earningsHigh = new LinguisticVariable(
            "earnings", "high earnings",
            x -> new TrapezoidMembership(35000, 50000, 2137000, 2137000).getMembership(x.earnings),
            new FuzzySet<>(
                    new TrapezoidMembership(35000, 50000, 2137000, 2137000),
                    x -> (double) x.earnings
            ),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc="earnings">
    //<editor-fold desc="none">
    public static LinguisticVariable none = new LinguisticVariable(
            "",
            x -> new ConstantMembership().getMembership(0.0),
            new FuzzySet<>(
                    new ConstantMembership(),
                    x -> 0.0
            ),
            LinguisticVariable.IsHave.HAVE
    );
    //</editor-fold desc=" - ">

    public static ArrayList<LinguisticVariable> staticVariables = new ArrayList<>(Arrays.asList(
            none,
            raceWhite, raceBlack, raceHispanic, raceOther,
            ageTeen, ageYoungAdult, ageAdult, ageOldAdult,
            kidsFew, kidsMany,
            lowerDegree, mediumDegree, higherDegree,
            fewYears, normalYears, manyYears,
            pregnanciesLow, pregnanciesMedium, pregnanciesHigh,
            marriagesFew, marriagesMany,
            weightLight, weightMedium, weightHeavy,
            heightShort, heightMedium, heightTall,
            earningsLow, earningsMedium, earningsHigh
    ));

    public static Map<String, List<LinguisticVariable>> categorisedVariables = new HashMap<>();

    static {
        for(LinguisticVariable variable : staticVariables){
            if(variable.category.equals("")){
                continue;
            }
            if(!categorisedVariables.containsKey(variable.category)){
                categorisedVariables.put(variable.category, new ArrayList<>());
            }
            categorisedVariables.get(variable.category).add(variable);
        }
    }
}
