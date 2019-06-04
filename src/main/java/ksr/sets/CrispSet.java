package ksr.sets;

import java.util.*;

public class CrispSet<ElemType> {
    private HashSet<ElemType> set;

    public CrispSet(){
        set = new HashSet<>();
    }

    public CrispSet(Set<ElemType> set){
        this.set = new HashSet<>(set);
    }

    public CrispSet(CrispSet<ElemType> set){
        this.set = (HashSet<ElemType>) set.set.clone();
    }

    public static <T> CrispSet<T> intersection(CrispSet<T> set1, CrispSet<T> set2){
        CrispSet<T> result = new CrispSet<>();
        result.set.addAll(set1.set);
        result.set.retainAll(set2.set);
        return result;
    }

    public static <T> CrispSet<T> sum(CrispSet<T> set1, CrispSet<T> set2){
        CrispSet<T> result = new CrispSet<>();
        result.set.addAll(set1.set);
        result.set.addAll(set2.set);
        return result;
    }

    public Set<ElemType> Set(){
        return set;
    }

    public boolean contains(ElemType element) {
        return set.contains(element);
    }

    public void set(ElemType element) {
        set.remove(element);
        set.add(element);
    }

    public boolean add(ElemType element){
        return set.add(element);
    }

    public void remove(ElemType element) {
        set.remove(element);
    }

    public void clear() {
        set.clear();
    }
}
