package ksr.sets;

import java.util.Objects;

public class IntRange implements Range {

    int begin;
    int end;

    IntRange(int begin, int end){
        if(end < begin){
            throw new IllegalArgumentException("End must be greater than or equal to begin");
        }
        this.begin = begin;
        this.end = end;
    }

    void set(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public int compareTo(Range range) {
        if(this.begin < ((IntRange)range).begin && this.end < ((IntRange)range).end){
            return -1;
        }
        if(this.begin > ((IntRange)range).begin && this.end > ((IntRange)range).end){
            return 1;
        }
        return 0;
    }

    @Override
    public int compare(Range lhs, Range rhs) {
        return lhs.compareTo(rhs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntRange range = (IntRange) o;
        return begin == range.begin &&
                end == range.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }
}
