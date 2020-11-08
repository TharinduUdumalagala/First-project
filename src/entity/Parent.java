package entity;

public class Parent implements SuperEntity {
    private int parentId;
    private String parentName;
    private String phoneNo;

    public Parent() {
    }

    public Parent(int parentId, String parentName, String phoneNo) {
        this.parentId = parentId;
        this.parentName = parentName;
        this.phoneNo = phoneNo;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
