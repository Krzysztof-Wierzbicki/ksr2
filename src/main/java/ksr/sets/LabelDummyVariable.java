package ksr.sets;

public class LabelDummyVariable extends LinguisticVariable {

    public LabelDummyVariable(String name){
        super("", name, null);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean isDummy() {
        return true;
    }
}
