package ksr;

import ksr.database.DatabaseSetup;
import ksr.database.Loader;
import ksr.sets.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainTerminal {

    public static void main(String[] args) throws SQLException, FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        ReportGenerator reportGenerator = new ReportGenerator();

        DatabaseSetup.init();
        reportGenerator.setEntities(Loader.loadDatabaseToModel());
        reportGenerator.setQuantifiers(StaticQuantifiers.staticQuantifiers);

        Scanner scanner = new Scanner(System.in);
        boolean complex = false;

        ArrayList<LinguisticVariable> andOrList = new ArrayList<>(Arrays.asList(
                new LinguisticVariable("and", new And()),
                new LinguisticVariable("of", new Or())
        ));

        for (int i = 0; i < StaticVariable.staticVariables.size(); i++) {
            System.out.println(" > " + i + "\t " + StaticVariable.staticVariables.get(i).name);
        }

        System.out.print("\n[0]Simple or [1]Complex report?  ");
        complex = scanner.nextInt() != 0;

        System.out.print("Pick qualifier:     \t");
        reportGenerator.setQualifier(StaticVariable.staticVariables.get(scanner.nextInt()));

        System.out.print("Pick summarizer 1:  \t");
        reportGenerator.setSummarizer1(StaticVariable.staticVariables.get(scanner.nextInt()));

        if (complex) {
            System.out.print("Pick summarizer 2:  \t");
            reportGenerator.setSummarizer2(StaticVariable.staticVariables.get(scanner.nextInt()));

            System.out.print("Pick [0]and / [1]or:\t");
            reportGenerator.setAndOr(andOrList.get(scanner.nextInt()));
        }
        System.out.println();

        if (complex) {
            reportGenerator.generateComplex();
        }
        else {
            reportGenerator.generate();
        }
        reportGenerator.save();

        System.out.print(reportGenerator.getReport());
    }
}
