package entity;

public class Exam_Details implements SuperEntity{
    private String Exam_Details_Id;
    private String Marks;
    private String Reg_ID;
    private String Exam_Id;

    public Exam_Details() {
    }

    public Exam_Details(String exam_Details_Id, String marks, String reg_ID, String exam_Id) {
        Exam_Details_Id = exam_Details_Id;
        Marks = marks;
        Reg_ID = reg_ID;
        Exam_Id = exam_Id;
    }

    public String getExam_Details_Id() {
        return Exam_Details_Id;
    }

    public void setExam_Details_Id(String exam_Details_Id) {
        Exam_Details_Id = exam_Details_Id;
    }

    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public String getReg_ID() {
        return Reg_ID;
    }

    public void setReg_ID(String reg_ID) {
        Reg_ID = reg_ID;
    }

    public String getExam_Id() {
        return Exam_Id;
    }

    public void setExam_Id(String exam_Id) {
        Exam_Id = exam_Id;
    }

    @Override
    public String toString() {
        return "Exam_Details{" +
                "Exam_Details_Id='" + Exam_Details_Id + '\'' +
                ", Marks='" + Marks + '\'' +
                ", Reg_ID='" + Reg_ID + '\'' +
                ", Exam_Id='" + Exam_Id + '\'' +
                '}';
    }
}
