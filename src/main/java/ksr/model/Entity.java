package ksr.model;

import java.util.Objects;

public class Entity {

    public int id;
    public Race race;
    public int age;
    public MaritalStatus maritalStatus;
    public int numberOfKids;
    public SchoolType schoolType;
    public int maxGrade;
    public boolean completed;
    public Degree degree;
    public int pregnancyCount;
    public int marriageCount;
    public Religion religion;
    public boolean everWorked;
    public WorkType workType;
    public int weight;
    public int height;
    public int earnings;

    public Entity() {}

    public Entity(EntityDB entityDB) {
        this.id = entityDB.id;
        this.race = parseRace(entityDB.race);
        this.age = entityDB.age;
        this.maritalStatus = parseMaritalStatus(entityDB.maritalStatus);
        this.numberOfKids = entityDB.numberOfKids;
        this.schoolType = parseSchoolType(entityDB.schoolType);
        this.maxGrade = entityDB.maxGrade;
        this.completed = entityDB.completed;
        this.degree = parseDegree(entityDB.degree);
        this.pregnancyCount = parseInt(entityDB.pregnancyCount);
        this.marriageCount = parseInt(entityDB.marriageCount);
        this.religion = parseReligion(entityDB.religion);
        this.everWorked = entityDB.everWorked;
        this.workType = parseWorkType(entityDB.workType);
        this.weight = parseInt(entityDB.weight);
        this.height = parseInt(entityDB.height);
        this.earnings = parseInt(entityDB.earnings);
    }

    //<editor-fold desc="parsers">

    private int parseInt(String s) {
        if (!s.equals("None")) {
            return Integer.parseInt(s);
        }
        return 0;
    }

    private Race parseRace(String s) {
        switch (s) {
            case "white":
                return Race.white;
            case "hispanic":
                return Race.hispanic;
            case "black":
                return Race.black;
            default:
                return Race.other;
        }
    }

    private MaritalStatus parseMaritalStatus(String s) {
        switch (s) {
            case "married":
                return MaritalStatus.married;
            case "informal relationship":
                return MaritalStatus.informalRelationship;
            case "widowed":
                return MaritalStatus.widowed;
            case "separated":
                return MaritalStatus.separated;
            case "divorced":
                return MaritalStatus.divorced;
            case "never married":
                return MaritalStatus.neverMarried;
            default:
                return null;
        }
    }

    private SchoolType parseSchoolType(String s) {
        switch (s) {
            case "school":
                return SchoolType.school;
            case "college":
                return SchoolType.college;
            default:
                return null;
        }
    }

    private Degree parseDegree(String s) {
        switch (s) {
            case "Associate":
                return Degree.associate;
            case "Bachelor":
                return Degree.bachelor;
            case "Master":
                return Degree.master;
            case "Doctorate":
                return Degree.doctorate;
            case "Professional":
                return Degree.professional;
            default:
                return Degree.none;
        }
    }

    private Religion parseReligion(String s) {
        switch (s) {
            case "catholic":
                return Religion.catholic;
            case "baptist":
                return Religion.baptist;
            case "protestant":
                return Religion.protestant;
            case "other":
                return Religion.other;
            default:
                return Religion.none;
        }
    }

    private WorkType parseWorkType(String s) {
        switch (s) {
            case "full-time":
                return WorkType.fulltime;
            case "part-time":
                return WorkType.parttime;
            case "both":
                return WorkType.both;
            default:
                return null;
        }
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", race=" + race +
                ", age=" + age +
                ", maritalStatus=" + maritalStatus +
                ", numberOfKids=" + numberOfKids +
                ", schoolType=" + schoolType +
                ", maxGrade=" + maxGrade +
                ", completed=" + completed +
                ", degree=" + degree +
                ", pregnancyCount=" + pregnancyCount +
                ", marriageCount=" + marriageCount +
                ", religion=" + religion +
                ", everWorked=" + everWorked +
                ", workType=" + workType +
                ", weight=" + weight +
                ", height=" + height +
                ", earnings=" + earnings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(age, entity.age) &&
                Objects.equals(numberOfKids, entity.numberOfKids) &&
                Objects.equals(maxGrade, entity.maxGrade) &&
                Objects.equals(completed, entity.completed) &&
                Objects.equals(pregnancyCount, entity.pregnancyCount) &&
                Objects.equals(marriageCount, entity.marriageCount) &&
                Objects.equals(everWorked, entity.everWorked) &&
                Objects.equals(weight, entity.weight) &&
                Objects.equals(height, entity.height) &&
                Objects.equals(earnings, entity.earnings) &&
                Objects.equals(race, entity.race) &&
                Objects.equals(maritalStatus, entity.maritalStatus) &&
                Objects.equals(schoolType, entity.schoolType) &&
                Objects.equals(degree, entity.degree) &&
                Objects.equals(religion, entity.religion) &&
                Objects.equals(workType, entity.workType);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
