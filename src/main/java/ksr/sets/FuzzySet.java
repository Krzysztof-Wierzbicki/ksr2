package ksr.sets;

import ksr.calculations.XMembership;
import ksr.model.Entity;

import java.util.*;

public class FuzzySet<ElemType> {

    private HashMap<ElemType, Double> set;
    public static XMembership membership;

    public FuzzySet(){
        set = new HashMap<>();
    }

    public FuzzySet(Map<ElemType, Double> map){
        set = new HashMap<>(map);
    }

    public FuzzySet(FuzzySet<ElemType> set){
        this.set = (HashMap<ElemType, Double>) set.set.clone();
    }

    public static double getMembership(Entity entity) throws NoSuchFieldException, IllegalAccessException {
        return membership.apply(entity);
    }

    public static <T> FuzzySet<T> intersection(FuzzySet<T> set1, FuzzySet<T> set2){
        FuzzySet<T> result = new FuzzySet<T>();
        for(T key : commonElementsSet(set1, set2)){
            if (set1.set.containsKey(key) && set2.set.containsKey(key)){
                result.set.put(key, Double.min(set1.set.get(key), set2.set.get(key)));
            }
        }
        return result;
    }

    public static <T> FuzzySet<T> sum(FuzzySet<T> set1, FuzzySet<T> set2){
        FuzzySet<T> result = new FuzzySet<T>();
        for(T key : commonElementsSet(set1, set2)){
            if (set1.set.containsKey(key) && set2.set.containsKey(key)){
                result.set.put(key, Double.max(set1.set.get(key), set2.set.get(key)));
            } else if (set1.set.containsKey(key)) {
                result.set.put(key, set1.set.get(key));
            } else if (set2.set.containsKey(key)){
                result.set.put(key, set2.set.get(key));
            }
        }
        return result;
    }

    public Set<ElemType> support() {
        return set.keySet();
    }

    public Set<Map.Entry<ElemType, Double>> entrySet(){
        return set.entrySet();
    }

    public double contains(ElemType element) {
        return set.getOrDefault(element, 0.);
    }

    public double set(ElemType element, double degree) {
        if (degree == 0) {
            return 0;
        }
        Double res = set.put(element, degree);
        if(res != null){
            return res;
        }
        return 0;
    }

    public void add(ElemType element, double degree){
        if (degree != 0) {
            set.put(element, degree);
        }
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

    private static <T> Set<T> commonElementsSet(FuzzySet<T> set1, FuzzySet<T> set2){
        Set<T> elements = new HashSet<>();
        elements.addAll(set1.set.keySet());
        elements.addAll(set2.set.keySet());
        return elements;
    }
}
