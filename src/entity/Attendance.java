package entity;

public class Attendance implements SuperEntity {
    private int attendanceId;
    private String date;
    private String attend;
    private int studentDetailsId;

    public Attendance() {
    }

    public Attendance(int attendanceId, String date, String attend, int studentDetailsId) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.attend = attend;
        this.studentDetailsId = studentDetailsId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public int getStudentDetailsId() {
        return studentDetailsId;
    }

    public void setStudentDetailsId(int studentDetailsId) {
        this.studentDetailsId = studentDetailsId;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", date='" + date + '\'' +
                ", attend='" + attend + '\'' +
                ", studentDetailsId=" + studentDetailsId +
                '}';
    }
}
