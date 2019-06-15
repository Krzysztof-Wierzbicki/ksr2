package ksr.model;

public class EntityDB {

    public int id;
    public String race;
    public int age;
    public String maritalStatus;
    public int numberOfKids;
    public String schoolType;
    public int maxGrade;
    public boolean completed;
    public String degree;
    public String pregnancyCount;
    public String marriageCount;
    public String religion;
    public boolean everWorked;
    public String workType;
    public String weight;
    public String height;
    public String earnings;

    public EntityDB(int id, String race, int age, String maritalStatus, int numberOfKids,
                    String schoolType, int maxGrade, boolean completed, String degree,
                    String pregnancyCount, String marriageCount, String religion,
                    boolean everWorked, String workType, String weight, String height, String earnings) {
        this.id = id;
        this.race = race;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.numberOfKids = numberOfKids;
        this.schoolType = schoolType;
        this.maxGrade = maxGrade;
        this.completed = completed;
        this.degree = degree;
        this.pregnancyCount = pregnancyCount;
        this.marriageCount = marriageCount;
        this.religion = religion;
        this.everWorked = everWorked;
        this.workType = workType;
        this.weight = weight;
        this.height = height;
        this.earnings = earnings;
    }

    @Override
    public String toString() {
        return "EntityDB{" +
                "id=" + id +
                ", race='" + race +
                ", age=" + age +
                ", maritalStatus='" + maritalStatus +
                ", numberOfKids=" + numberOfKids +
                ", schoolType='" + schoolType +
                ", maxGrade=" + maxGrade +
                ", completed=" + completed +
                ", degree='" + degree +
                ", pregnancyCount='" + pregnancyCount +
                ", marriageCount='" + marriageCount +
                ", religion='" + religion +
                ", everWorked=" + everWorked +
                ", workType='" + workType +
                ", weight='" + weight +
                ", height='" + height +
                ", earnings='" + earnings +
                '}';
    }
}
