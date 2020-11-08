package entity;

public class Grade implements SuperEntity {
    private int Grade_Id;
    private String Grade_Name;

    public Grade() {
    }

    public Grade(int grade_Id, String grade_Name) {
        Grade_Id = grade_Id;
        Grade_Name = grade_Name;
    }

    public int getGrade_Id() {
        return Grade_Id;
    }

    public void setGrade_Id(int grade_Id) {
        Grade_Id = grade_Id;
    }

    public String getGrade_Name() {
        return Grade_Name;
    }

    public void setGrade_Name(String grade_Name) {
        Grade_Name = grade_Name;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "Grade_Id=" + Grade_Id +
                ", Grade_Name='" + Grade_Name + '\'' +
                '}';
    }
}
