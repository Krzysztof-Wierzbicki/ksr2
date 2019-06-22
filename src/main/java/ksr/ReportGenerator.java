package ksr;

import javafx.util.Pair;
import ksr.calculations.Measures;
import ksr.model.Entity;
import ksr.sets.LinguisticVariable;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;

public class ReportGenerator {

    private LinguisticVariable qualifier;

    private LinguisticVariable summarizer1;
    private LinguisticVariable summarizer2;
    private LinguisticVariable andOr;
    private ArrayList<LinguisticVariable> quantifiers;
    private ArrayList<Entity> entities;
    private ArrayList<AbstractMap.SimpleEntry<Double, Pair<String, ArrayList<Double>>>> summaries;
    private String report;

    void generate() throws NoSuchFieldException, IllegalAccessException {
        summaries = new ArrayList<>();
        for (LinguisticVariable quantifier : quantifiers) {
            String w = qualifier.name;
            String summary = quantifier.name + w + " are/have " + summarizer1.name;
            AbstractMap.SimpleEntry<Double, Pair<String, ArrayList<Double>>> pair = pair(quantifier, summarizer1, summary);
            summaries.add(pair);
        }
        summaries.sort((x, y) -> y.getKey().compareTo(x.getKey()));
        report = generateReport();
    }

    void save() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("report.txt");
        printWriter.print(report);
        printWriter.close();
    }

    AbstractMap.SimpleEntry<Double, Pair<String, ArrayList<Double>>> pair(LinguisticVariable quantifier, LinguisticVariable summarizer, String summary) throws NoSuchFieldException, IllegalAccessException {
        Pair<Double, ArrayList<Double>> temp = Measures.weightedMeasure(quantifier, qualifier, summarizer, entities);
        return new AbstractMap.SimpleEntry<>(temp.getKey(), new Pair<>(summary, temp.getValue()));
    }

    String generateReport() {
        StringBuilder ret = new StringBuilder();

        for (AbstractMap.SimpleEntry<Double, Pair<String, ArrayList<Double>>> summary : summaries) {
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

    public LinguisticVariable getQualifier() {
        return qualifier;
    }

    public LinguisticVariable getSummarizer1() {
        return summarizer1;
    }

    public LinguisticVariable getSummarizer2() {
        return summarizer2;
    }

    public LinguisticVariable getAndOr() {
        return andOr;
    }

    public ArrayList<LinguisticVariable> getQuantifiers() {
        return quantifiers;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setQualifier(LinguisticVariable qualifier) {
        this.qualifier = qualifier;
    }

    public void setSummarizer1(LinguisticVariable summarizer1) {
        this.summarizer1 = summarizer1;
    }

    public void setSummarizer2(LinguisticVariable summarizer2) {
        this.summarizer2 = summarizer2;
    }

    public void setAndOr(LinguisticVariable andor) {
        this.andOr = andor;
    }

    public void setQuantifiers(ArrayList<LinguisticVariable> quantifiers) {
        this.quantifiers = quantifiers;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
