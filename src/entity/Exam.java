package entity;

public class Exam implements SuperEntity{
    private String Exam_Id;
    private String Exame_Date;

    public Exam() {
    }

    public Exam(String exam_Id, String exame_Date) {
        Exam_Id = exam_Id;
        Exame_Date = exame_Date;
    }

    public String getExam_Id() {
        return Exam_Id;
    }

    public void setExam_Id(String exam_Id) {
        Exam_Id = exam_Id;
    }

    public String getExame_Date() {
        return Exame_Date;
    }

    public void setExame_Date(String exame_Date) {
        Exame_Date = exame_Date;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "Exam_Id='" + Exam_Id + '\'' +
                ", Exame_Date='" + Exame_Date + '\'' +
                '}';
    }
}
