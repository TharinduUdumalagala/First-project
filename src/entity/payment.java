package entity;

public class payment implements SuperEntity {
    private String Payment_Id;
    private String Payment_Date;
    private String Class_Fee;
    private String Reg_Id;

    public payment() {
    }

    public payment(String payment_Id, String payment_Date, String class_Fee, String reg_Id) {
        Payment_Id = payment_Id;
        Payment_Date = payment_Date;
        Class_Fee = class_Fee;
        Reg_Id = reg_Id;
    }

    public String getPayment_Id() {
        return Payment_Id;
    }

    public void setPayment_Id(String payment_Id) {
        Payment_Id = payment_Id;
    }

    public String getPayment_Date() {
        return Payment_Date;
    }

    public void setPayment_Date(String payment_Date) {
        Payment_Date = payment_Date;
    }

    public String getClass_Fee() {
        return Class_Fee;
    }

    public void setClass_Fee(String class_Fee) {
        Class_Fee = class_Fee;
    }

    public String getReg_Id() {
        return Reg_Id;
    }

    public void setReg_Id(String reg_Id) {
        Reg_Id = reg_Id;
    }

    @Override
    public String toString() {
        return "payment{" +
                "Payment_Id='" + Payment_Id + '\'' +
                ", Payment_Date='" + Payment_Date + '\'' +
                ", Class_Fee='" + Class_Fee + '\'' +
                ", Reg_Id='" + Reg_Id + '\'' +
                '}';
    }
}
