package ksr;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ksr.database.DatabaseSetup;
import ksr.database.Loader;
import ksr.sets.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TreeView<LinguisticVariable> qualifierTree;
    public TreeView<LinguisticVariable> summarizer1Tree;
    public TreeView<LinguisticVariable> summarizer2Tree;
    public RadioButton andRadio, orRadio;
    public TextArea textArea;

    private ReportGenerator reportGenerator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DatabaseSetup.init();
            reportGenerator = new ReportGenerator();
            reportGenerator.setEntities(Loader.loadDatabaseToModel());
            reportGenerator.setQuantifiers(StaticQuantifiers.staticQuantifiers);
        } catch (SQLException ex) {
            ex.printStackTrace();
            showInitAlert();
            throw new RuntimeException();
        }

        fillTree(qualifierTree);
        fillTree(summarizer1Tree);
        fillTree(summarizer2Tree);
    }

    private void fillTree(TreeView<LinguisticVariable> tree){
        TreeItem<LinguisticVariable> dummyRoot = new TreeItem<>();
        for(Map.Entry<String, List<LinguisticVariable>> entry : StaticVariable.categorisedVariables.entrySet()){
            TreeItem<LinguisticVariable> root = new TreeItem<>(new LabelDummyVariable(entry.getKey()));
            dummyRoot.getChildren().add(root);
            for(LinguisticVariable variable : entry.getValue()){
                root.getChildren().add(new TreeItem<>(variable));
            }
        }
        tree.setRoot(dummyRoot);
        tree.setShowRoot(false);
        tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void generate(ActionEvent actionEvent) {
        LinguisticVariable qualifier = null;
        LinguisticVariable summarizer1 = null;
        LinguisticVariable summarizer2 = null;
        LinguisticVariable andOr = null;
        boolean simple = true;

        List<TreeItem<LinguisticVariable>> qualifierList = qualifierTree.getSelectionModel().getSelectedItems();
        List<TreeItem<LinguisticVariable>> sum1List = summarizer1Tree.getSelectionModel().getSelectedItems();
        List<TreeItem<LinguisticVariable>> sum2List = summarizer2Tree.getSelectionModel().getSelectedItems();
        if(qualifierList.size() > 0){
            qualifier = qualifierList.get(0).getValue();
        }else{
            qualifier = StaticVariable.none;
        }
        if(sum1List.size() > 0 && sum2List.size() > 0){
            summarizer1 = sum1List.get(0).getValue();
            summarizer2 = sum2List.get(0).getValue();
            simple = false;
        }else if(sum1List.size() > 0){
            summarizer1 = sum1List.get(0).getValue();
            summarizer2 = StaticVariable.none;
        }else if(sum2List.size() > 0){
            summarizer1 = sum2List.get(0).getValue();
            summarizer2 = StaticVariable.none;
        }else{
            showChoiceAlert();
            return;
        }

        if(qualifier.isDummy() || summarizer1.isDummy() || summarizer2.isDummy()){
            showChoiceAlert();
            return;
        }

        if(andRadio.isSelected()){
            andOr = new LinguisticVariable("and", new And());
        }else if(orRadio.isSelected()){
            andOr = new LinguisticVariable("or", new Or());
        }else{
            if(!simple){
                showChoiceAlert();
                return;
            }
        }

        reportGenerator.setQualifier(qualifier);
        reportGenerator.setSummarizer1(summarizer1);
        reportGenerator.setSummarizer2(summarizer2);
        reportGenerator.setAndOr(andOr);

        try {
            if(simple){
                reportGenerator.generate();
            }else{
                reportGenerator.generateComplex();
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        textArea.setText(reportGenerator.getReport());
    }

    private void showChoiceAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("At least one summarizer must be selected");
        alert.setHeaderText("Options not chosen");
        alert.setTitle("Error");
        alert.show();
    }

    private void showInitAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Initialization error");
        alert.setTitle("Error");
        alert.showAndWait();
    }
}
