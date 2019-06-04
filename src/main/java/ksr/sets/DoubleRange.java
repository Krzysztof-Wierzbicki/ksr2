package ksr.sets;

import java.util.Objects;

public class DoubleRange implements Range {

    double begin;
    double end;

    DoubleRange(double begin, double end){
        if(end < begin){
            throw new IllegalArgumentException("End must be greater than or equal to begin");
        }
        this.begin = begin;
        this.end = end;
    }

    void set(double begin, double end){
        this.begin = begin;
        this.end = end;
    }

    void add(DoubleRange other){
        begin = Math.min(begin, other.begin);
        end = Math.max(end, other.end);
    }

    void intersect(DoubleRange other){
        begin = Math.max(begin, other.begin);
        end = Math.min(end, other.end);
        if(begin > end){
            begin = 0;
            end = 0;
        }
    }

    @Override
    public int compareTo(Range range) {
        if(this.begin < ((DoubleRange)range).begin && this.end < ((DoubleRange)range).end){
            return -1;
        }
        if(this.begin > ((DoubleRange)range).begin && this.end > ((DoubleRange)range).end){
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
        DoubleRange range = (DoubleRange) o;
        return begin == range.begin &&
                end == range.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }
}
