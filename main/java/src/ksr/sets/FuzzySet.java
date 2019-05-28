package ksr.sets;

import java.util.*;
import java.util.stream.Collectors;

public class FuzzySet<ElemType> {

    private HashMap<ElemType, Double> set;

    public FuzzySet(){
        set = new HashMap<>();
    }

    public FuzzySet(Map<ElemType, Double> map){
        set = new HashMap<>(map);
    }

    public FuzzySet(FuzzySet<ElemType> set){
        this.set = (HashMap<ElemType, Double>) set.set.clone();
    }

    public static <T> FuzzySet<T> intersection(FuzzySet<T> set1, FuzzySet<T> set2){
        FuzzySet<T> result = new FuzzySet<T>();
        for(Map.Entry<T, Double> entry : set1.entrySet()){
            if (set2.set.containsKey(entry.getKey())){
                result.set.put(entry.getKey(), Double.min(entry.getValue(), set2.set.get(entry.getKey())));
            }
        }
        return result;
    }

    public static <T> FuzzySet<T> sum(FuzzySet<T> set1, FuzzySet<T> set2){
        FuzzySet<T> result = new FuzzySet<T>(set1);
        for(Map.Entry<T, Double> entry : set2.entrySet()){
            if (result.set.containsKey(entry.getKey())){
                result.set.put(entry.getKey(), Double.max(entry.getValue(), result.set.get(entry.getKey())));
            }else{
                result.set.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public Set<ElemType> universe() {
        return set.keySet();
    }

    public Set<ElemType> support() {
        return set.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<Map.Entry<ElemType, Double>> entrySet(){
        return set.entrySet();
    }

    public double contains(ElemType element) {
        return set.getOrDefault(element, 0.);
    }

    public double set(ElemType element, double degree) {
        Double res = set.put(element, degree);
        if(res != null){
            return res;
        }
        return 0;
    }

    public void add(ElemType element, double degree){
        set.put(element, degree);
    }

    public void remove(ElemType element) {
        set.remove(element);
    }

    public void clear() {
        set.clear();
    }

    public Collection<Double> values() {
        return set.values();
    }
}
