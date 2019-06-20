package ksr.sets;

import ksr.calculations.TrapezoidMembership;
import ksr.calculations.TriangularMembership;

import java.util.ArrayList;
import java.util.Arrays;

public class StaticQuantifiers {

    //<editor-fold desc="quantifiers relative">
    public static LinguisticVariable none = new LinguisticVariable(
            "none", new TriangularMembership(.0, .0, 0.15), false
    );

    public static LinguisticVariable around20p = new LinguisticVariable(
            "around 20%", new TriangularMembership(0.15, 0.2, 0.27), false
    );

    public static LinguisticVariable around35p = new LinguisticVariable(
            "around 35%", new TriangularMembership(0.27, 0.35, 0.43), false
    );

    public static LinguisticVariable around50p = new LinguisticVariable(
            "around 50%", new TriangularMembership(0.43, 0.5, 0.57), false
    );

    public static LinguisticVariable around65p = new LinguisticVariable(
            "around 65%", new TriangularMembership(0.57, 0.65, 0.73), false
    );

    public static LinguisticVariable around80p = new LinguisticVariable(
            "around 80%", new TriangularMembership(0.73, 0.8, 0.85), false
    );

    public static LinguisticVariable all = new LinguisticVariable(
            "all", new TriangularMembership(0.85, 1.0,1.0), false
    );
    //</editor-fold desc="quantifiers relative">
    //<editor-fold desc="quantifiers absolute">
    public static LinguisticVariable lessThan3000 = new LinguisticVariable(
            "less than 3000", new TrapezoidMembership(0, 0, 2850, 3000), true
    );

    public static LinguisticVariable around5000 = new LinguisticVariable(
            "around 5000", new TriangularMembership(4000, 5000, 6000), true
    );

    public static LinguisticVariable around8000 = new LinguisticVariable(
            "around 8000", new TriangularMembership(7000, 8000, 9000), true
    );

    public static LinguisticVariable moreThan10000 = new LinguisticVariable(
            "more than 10000", new TrapezoidMembership(10000, 10150, 100000, 100000), true
    );
    //</editor-fold desc="quantifiers absolute">

    public static ArrayList<LinguisticVariable> staticQuantifiers = new ArrayList<>(Arrays.asList(
            none, around20p, around35p, around50p, around65p, around80p, all,
            lessThan3000, around5000, around8000, moreThan10000
    ));
}
