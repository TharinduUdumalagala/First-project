package entity;

public class Subject implements SuperEntity{
    private int subId;
    private String subName;
    private String subDiscription;

    public Subject() {
    }

    public Subject(int subId, String subName, String subDiscription) {
        this.subId = subId;
        this.subName = subName;
        this.subDiscription = subDiscription;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubDiscription() {
        return subDiscription;
    }

    public void setSubDiscription(String subDiscription) {
        this.subDiscription = subDiscription;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId=" + subId +
                ", subName='" + subName + '\'' +
                ", subDiscription='" + subDiscription + '\'' +
                '}';
    }
}
