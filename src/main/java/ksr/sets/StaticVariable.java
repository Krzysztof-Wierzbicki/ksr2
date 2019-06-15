package ksr.sets;

import ksr.calculations.TrapezoidMembership;
import ksr.calculations.TriangleMembership;

public class StaticVariable {

    // TODO: race, maritalStatus, schoolType, completed, degree, religion, everWorked, workType
    // TODO: FuzzySets - adapt, fill, adjust
    //<editor-fold desc="race">
    //</editor-fold desc="race">
    //<editor-fold desc="age">
    public static LinguisticVariable ageTeen = new LinguisticVariable(
            "teen", "age",
            new TrapezoidMembership(15, 15, 17, 19),
            new FuzzySet<>()
    );
    public static LinguisticVariable ageYoungAdult = new LinguisticVariable(
            "young adult", "age",
            new TrapezoidMembership(18, 20, 25, 27),
            new FuzzySet<>()
    );
    public static LinguisticVariable ageAdult = new LinguisticVariable(
            "adult", "age",
            new TrapezoidMembership(26, 29, 33, 39),
            new FuzzySet<>()
    );
    public static LinguisticVariable ageOldAdult = new LinguisticVariable(
            "old adult", "age",
            new TrapezoidMembership(35, 40, 44, 44),
            new FuzzySet<>()
    );
    //</editor-fold desc="age">
    //<editor-fold desc="maritalStatus">
    //</editor-fold desc="maritalStatus">
    //<editor-fold desc="numberOfKids">
    public static LinguisticVariable kidsFew = new LinguisticVariable(
            "few kids", "numberOfKids",
            new TriangleMembership(0, 0, 3),
            new FuzzySet<>()
    );
    public static LinguisticVariable kidsMany = new LinguisticVariable(
            "many kids", "numberOfKids",
            new TriangleMembership(2, 5, 5),
            new FuzzySet<>()
    );
    //</editor-fold desc="numberOfKids">
    //<editor-fold desc="schoolType">
    //</editor-fold desc="schoolType">
    //<editor-fold desc="maxGrade">
    public static LinguisticVariable gradesLow = new LinguisticVariable(
            "around 2 grades", "maxGrade",
            new TrapezoidMembership(1, 1, 3, 4),
            new FuzzySet<>()
    );
    public static LinguisticVariable gradesMedium = new LinguisticVariable(
            "some grades", "maxGrade",
            new TrapezoidMembership(3, 5, 7, 9),
            new FuzzySet<>()
    );
    public static LinguisticVariable gradesHigh = new LinguisticVariable(
            "all/almost all grades", "maxGrade",
            new TrapezoidMembership(8, 11, 12, 12),
            new FuzzySet<>()
    );
    //</editor-fold desc="maxGrade">
    //<editor-fold desc="completed">
    //</editor-fold desc="completed">
    //<editor-fold desc="degree">
    //</editor-fold desc="degree">
    //<editor-fold desc="pregnancyCount">
    public static LinguisticVariable pregnanciesLow = new LinguisticVariable(
            "low amount of pregnancies", "pregnancyCount",
            new TrapezoidMembership(0, 0, 2, 6),
            new FuzzySet<>()
    );
    public static LinguisticVariable pregnanciesMedium = new LinguisticVariable(
            "medium amount of pregnancies", "pregnancyCount",
            new TrapezoidMembership(4, 6, 8, 10),
            new FuzzySet<>()
    );
    public static LinguisticVariable pregnanciesHigh = new LinguisticVariable(
            "high amount of pregnancies", "pregnancyCount",
            new TrapezoidMembership(8, 10, 20, 20),
            new FuzzySet<>()
    );
    //</editor-fold desc="pregnancyCount">
    //<editor-fold desc="marriageCount">
    public static LinguisticVariable marriagesFew = new LinguisticVariable(
            "few marriages", "marriageCount",
            new TriangleMembership(0, 0, 3),
            new FuzzySet<>()
    );
    public static LinguisticVariable marriagesMany = new LinguisticVariable(
            "many marriages", "marriageCount",
            new TrapezoidMembership(2, 3, 6, 6),
            new FuzzySet<>()
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
            "light", "weight",
            new TrapezoidMembership(0, 0, 50, 57),
            new FuzzySet<>()
    );
    public static LinguisticVariable weightMedium = new LinguisticVariable(
            "medium", "weight",
            new TrapezoidMembership(53, 60, 65, 72),
            new FuzzySet<>()
    );
    public static LinguisticVariable weightHeavy = new LinguisticVariable(
            "heavy", "weight",
            new TrapezoidMembership(70, 80, 125, 125),
            new FuzzySet<>()
    );
    //</editor-fold desc="weight">
    //<editor-fold desc="height">
    public static LinguisticVariable heightShort = new LinguisticVariable(
            "short", "height",
            new TrapezoidMembership(0, 0, 150, 165),
            new FuzzySet<>()
    );
    public static LinguisticVariable heightMedium = new LinguisticVariable(
            "medium", "height",
            new TrapezoidMembership(160, 165, 170, 175),
            new FuzzySet<>()
    );
    public static LinguisticVariable heightTall = new LinguisticVariable(
            "tall", "height",
            new TrapezoidMembership(170, 175, 180, 180),
            new FuzzySet<>()
    );
    //</editor-fold desc="height">
    //<editor-fold desc="earnings">
    public static LinguisticVariable earningsLow = new LinguisticVariable(
            "low earnings", "earnings",
            new TrapezoidMembership(0, 0, 12500, 25000),
            new FuzzySet<>()
    );
    public static LinguisticVariable earningsMedium = new LinguisticVariable(
            "medium earnings", "earnings",
            new TrapezoidMembership(20000, 25000, 35000, 40000),
            new FuzzySet<>()
    );
    public static LinguisticVariable earningsHigh = new LinguisticVariable(
            "high earnings", "earnings",
            new TrapezoidMembership(35000, 50000, 2137000, 2137000),
            new FuzzySet<>()
    );
    //</editor-fold desc="earnings">
}
