package ksr;

import javafx.util.Pair;
import ksr.calculations.Measures;
import ksr.database.DatabaseSetup;
import ksr.database.Loader;
import ksr.model.Entity;
import ksr.sets.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainTerminal {

    private static LinguisticVariable qualifier;
    private static LinguisticVariable summarizer1;
    private static LinguisticVariable summarizer2;
    private static LinguisticVariable andor;
    private static ArrayList<LinguisticVariable> quantifiers;
    private static ArrayList<SimpleEntry<Double, Pair<String, ArrayList<Double>>>> summaries;
    private static String report;
    private static ArrayList<Entity> entities;

    public static void main(String[] args) throws SQLException, FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        DatabaseSetup.init();
        entities = Loader.loadDatabaseToModel();

        Scanner scanner = new Scanner(System.in);

        quantifiers = StaticQuantifiers.staticQuantifiers;

        ArrayList<LinguisticVariable> andorList = new ArrayList<>(Arrays.asList(
                new LinguisticVariable("or", new Or()),
                new LinguisticVariable("and", new And())
        ));

        for (int i = 0; i < StaticVariable.staticVariables.size(); i++) {
            System.out.println(" > " + i + "\t " + StaticVariable.staticVariables.get(i).name);
        }

        System.out.print("Pick qualifier:     \t");
        qualifier = StaticVariable.staticVariables.get(scanner.nextInt());

        System.out.print("Pick summarizer 1:  \t");
        summarizer1 = StaticVariable.staticVariables.get(scanner.nextInt());

        System.out.print("Pick summarizer 2:  \t");
        summarizer2 = StaticVariable.staticVariables.get(scanner.nextInt());

        System.out.print("Pick [0]and / [1]or:\t");
        andor = andorList.get(scanner.nextInt());

        generate();

        save();

        System.out.print(report);
    }

    private static void generate() throws NoSuchFieldException, IllegalAccessException {
        summaries = new ArrayList<>();
        for (LinguisticVariable quantifier : quantifiers) {
            String w = !qualifier.name.equals(" - ") ? "of females being/having " + qualifier.name : "";
            String summary = quantifier.name + w + " are/have " + summarizer1.name + "\n\n";
            var pair = pair(quantifier, summarizer1, summary);
            summaries.add(pair);
        }
        summaries.sort((x, y) -> y.getKey().compareTo(x.getKey()));
        report = generateReport();
    }

    private static void save() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("report.txt");
        printWriter.print(report);
        printWriter.close();
    }

    private static SimpleEntry<Double, Pair<String, ArrayList<Double>>> pair(LinguisticVariable quantifier, LinguisticVariable summarizer, String summary) throws NoSuchFieldException, IllegalAccessException {
        Pair<Double, ArrayList<Double>> temp = Measures.weightedMeasure(quantifier, qualifier, summarizer, entities);
        return new SimpleEntry<>(temp.getKey(), new Pair<>(summary, temp.getValue()));
    }

    private static String generateReport() {
        StringBuilder ret = new StringBuilder();

        for (SimpleEntry<Double, Pair<String, ArrayList<Double>>> summary : summaries) {
            int i = 1;
            ret.append(summary.getValue().getKey()).append(" [").append(Math.round(100 * summary.getKey()) / 100).append("]\n");
            ret.append("[");
            for (Double x : summary.getValue().getValue()) {
                ret.append("T").append(i++).append("=").append(Math.round(100 * x) / 100).append("; ");
            }
            ret = new StringBuilder(ret.substring(0, ret.length() - 2));
            ret.append("]\n");
        }

        return ret.toString();
    }
}
