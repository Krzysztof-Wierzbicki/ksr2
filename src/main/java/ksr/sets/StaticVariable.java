package ksr.sets;

import ksr.calculations.TrapezoidMembership;
import ksr.calculations.TriangularMembership;

import java.util.ArrayList;
import java.util.Arrays;

public class StaticVariable {

    // TODO: race, maritalStatus, schoolType, completed, degree, religion, everWorked, workType
    //<editor-fold desc="race">
    //</editor-fold desc="race">
    //<editor-fold desc="age">
    public static LinguisticVariable ageTeen = new LinguisticVariable(
            "age: teen", "age",
            x -> new TrapezoidMembership(15, 15, 17, 19, "age").getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(15, 15, 17, 15),
                    x -> (double) x.age
            )
    );
    public static LinguisticVariable ageYoungAdult = new LinguisticVariable(
            "age: young adult", "age",
            x -> new TrapezoidMembership(18, 20, 25, 27, "age").getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(18, 20, 25, 27),
                    x -> (double) x.age
            )
    );
    public static LinguisticVariable ageAdult = new LinguisticVariable(
            "age: adult", "age",
            x -> new TrapezoidMembership(26, 29, 33, 39, "age").getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(26, 29, 33, 39),
                    x -> (double) x.age
            )
    );
    public static LinguisticVariable ageOldAdult = new LinguisticVariable(
            "age: old adult", "age",
            x -> new TrapezoidMembership(35, 40, 44, 44, "age").getMembership(x.age),
            new FuzzySet<>(
                    new TrapezoidMembership(35, 40, 44, 44),
                    x -> (double) x.age
            )
    );
    //</editor-fold desc="age">
    //<editor-fold desc="maritalStatus">
    //</editor-fold desc="maritalStatus">
    //<editor-fold desc="numberOfKids">
    public static LinguisticVariable kidsFew = new LinguisticVariable(
            "numberOfKids: few kids", "numberOfKids",
            x -> new TriangularMembership(0, 0, 3, "numberOfKids").getMembership(x.numberOfKids),
            new FuzzySet<>(
                    new TriangularMembership(0, 0, 3),
                    x -> (double) x.numberOfKids
            )
    );
    public static LinguisticVariable kidsMany = new LinguisticVariable(
            "numberOfKids: many kids", "numberOfKids",
            x -> new TriangularMembership(2, 5, 5, "numberOfKids").getMembership(x.numberOfKids),
            new FuzzySet<>(
                    new TriangularMembership(2, 5, 5),
                    x -> (double) x.numberOfKids
            )
    );
    //</editor-fold desc="numberOfKids">
    //<editor-fold desc="schoolType">
    //</editor-fold desc="schoolType">
    //<editor-fold desc="maxGrade">
    public static LinguisticVariable gradesLow = new LinguisticVariable(
            "maxGrade: around 2 grades", "maxGrade",
            x -> new TrapezoidMembership(1, 1, 3, 4, "maxGrade").getMembership(x.maxGrade),
            new FuzzySet<>(
                    new TrapezoidMembership(1, 1, 3, 4),
                    x -> (double) x.maxGrade
            )
    );
    public static LinguisticVariable gradesMedium = new LinguisticVariable(
            "maxGrade: some grades", "maxGrade",
            x -> new TrapezoidMembership(3, 5, 7, 9, "maxGrade").getMembership(x.maxGrade),
            new FuzzySet<>(
                    new TrapezoidMembership(3, 5, 7, 9),
                    x -> (double) x.maxGrade
            )
    );
    public static LinguisticVariable gradesHigh = new LinguisticVariable(
            "maxGrade: all/almost all grades", "maxGrade",
            x -> new TrapezoidMembership(8, 11, 12, 12, "maxGrade").getMembership(x.maxGrade),
            new FuzzySet<>(
                    new TrapezoidMembership(8, 11, 12, 12),
                    x -> (double) x.maxGrade
            )
    );
    //</editor-fold desc="maxGrade">
    //<editor-fold desc="completed">
    //</editor-fold desc="completed">
    //<editor-fold desc="degree">
    //</editor-fold desc="degree">
    //<editor-fold desc="pregnancyCount">
    public static LinguisticVariable pregnanciesLow = new LinguisticVariable(
            "pregnancyCount: low amount of pregnancies", "pregnancyCount",
            x -> new TrapezoidMembership(0, 0, 2, 6, "pregnancyCount").getMembership(x.pregnancyCount),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 2, 6),
                    x -> (double) x.pregnancyCount
            )
    );
    public static LinguisticVariable pregnanciesMedium = new LinguisticVariable(
            "pregnancyCount: medium amount of pregnancies", "pregnancyCount",
            x -> new TrapezoidMembership(4, 6, 8, 10, "pregnancyCount").getMembership(x.pregnancyCount),
            new FuzzySet<>(
                    new TrapezoidMembership(4, 6, 8, 10),
                    x -> (double) x.pregnancyCount
            )
    );
    public static LinguisticVariable pregnanciesHigh = new LinguisticVariable(
            "pregnancyCount: high amount of pregnancies", "pregnancyCount",
            x -> new TrapezoidMembership(8, 10, 20, 20, "pregnancyCount").getMembership(x.pregnancyCount),
            new FuzzySet<>(
                    new TrapezoidMembership(8, 10, 20, 20),
                    x -> (double) x.pregnancyCount
            )
    );
    //</editor-fold desc="pregnancyCount">
    //<editor-fold desc="marriageCount">
    public static LinguisticVariable marriagesFew = new LinguisticVariable(
            "marriageCount: few marriages", "marriageCount",
            x -> new TriangularMembership(0, 0, 3, "marriageCount").getMembership(x.marriageCount),
            new FuzzySet<>(
                    new TriangularMembership(0, 0, 3),
                    x -> (double) x.marriageCount
            )
    );
    public static LinguisticVariable marriagesMany = new LinguisticVariable(
            "marriageCount: many marriages", "marriageCount",
            x -> new TrapezoidMembership(2, 3, 6, 6, "marriageCount").getMembership(x.marriageCount),
            new FuzzySet<>(
                    new TrapezoidMembership(2, 3, 6, 6),
                    x -> (double) x.marriageCount
            )
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
            "weight: light", "weight",
            x -> new TrapezoidMembership(0, 0, 50, 57, "weight").getMembership(x.weight),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 50, 57),
                    x -> (double) x.weight
            )
    );
    public static LinguisticVariable weightMedium = new LinguisticVariable(
            "weight: medium", "weight",
            x -> new TrapezoidMembership(53, 60, 65, 72, "weight").getMembership(x.weight),
            new FuzzySet<>(
                    new TrapezoidMembership(53, 60, 65, 72),
                    x -> (double) x.weight
            )
    );
    public static LinguisticVariable weightHeavy = new LinguisticVariable(
            "weight: heavy", "weight",
            x -> new TrapezoidMembership(70, 80, 125, 125, "weight").getMembership(x.weight),
            new FuzzySet<>(
                    new TrapezoidMembership(70, 80, 125, 125),
                    x -> (double) x.weight
            )
    );
    //</editor-fold desc="weight">
    //<editor-fold desc="height">
    public static LinguisticVariable heightShort = new LinguisticVariable(
            "height: short", "height",
            x -> new TrapezoidMembership(0, 0, 150, 165, "height").getMembership(x.height),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 150, 165),
                    x -> (double) x.height
            )
    );
    public static LinguisticVariable heightMedium = new LinguisticVariable(
            "height: medium", "height",
            x -> new TrapezoidMembership(160, 165, 170, 175, "height").getMembership(x.height),
            new FuzzySet<>(
                    new TrapezoidMembership(160, 165, 170, 175),
                    x -> (double) x.height
            )
    );
    public static LinguisticVariable heightTall = new LinguisticVariable(
            "height: tall", "height",
            x -> new TrapezoidMembership(170, 175, 180, 180, "height").getMembership(x.height),
            new FuzzySet<>(
                    new TrapezoidMembership(170, 175, 180, 180),
                    x -> (double) x.height
            )
    );
    //</editor-fold desc="height">
    //<editor-fold desc="earnings">
    public static LinguisticVariable earningsLow = new LinguisticVariable(
            "earnings: low earnings", "earnings",
            x -> new TrapezoidMembership(0, 0, 12500, 25000, "earnings").getMembership(x.earnings),
            new FuzzySet<>(
                    new TrapezoidMembership(0, 0, 12500, 2500),
                    x -> (double) x.earnings
            )
    );
    public static LinguisticVariable earningsMedium = new LinguisticVariable(
            "earnings: medium earnings", "earnings",
            x -> new TrapezoidMembership(20000, 25000, 35000, 40000, "earnings").getMembership(x.earnings),
            new FuzzySet<>(
                    new TrapezoidMembership(20000, 25000, 35000, 40000),
                    x -> (double) x.earnings
            )
    );
    public static LinguisticVariable earningsHigh = new LinguisticVariable(
            "earnings: high earnings", "earnings",
            x -> new TrapezoidMembership(35000, 50000, 2137000, 2137000, "earnings").getMembership(x.earnings),
            new FuzzySet<>(
                    new TrapezoidMembership(35000, 50000, 2137000, 2137000),
                    x -> (double) x.earnings
            )
    );
    //</editor-fold desc="earnings">

    public static ArrayList<LinguisticVariable> staticVariables = new ArrayList<>(Arrays.asList(
            ageTeen, ageYoungAdult, ageAdult, ageOldAdult,
            kidsFew, kidsMany,
            gradesLow, gradesMedium, gradesHigh,
            pregnanciesLow, pregnanciesMedium, pregnanciesHigh,
            marriagesFew, marriagesMany,
            weightLight, weightMedium, weightHeavy,
            heightShort, heightMedium, heightTall,
            earningsLow, earningsMedium, earningsHigh
    ));
}
