package view.tm;

import javafx.scene.control.Button;

public class SelectedSubjectTM {
    private String fullName;
    private Button button;

    public SelectedSubjectTM(String fullName, Button button) {
        this.fullName = fullName;
        this.button = button;
    }

    public SelectedSubjectTM() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "SelectedSubjectTM{" +
                "fullName='" + fullName + '\'' +
                ", button=" + button +
                '}';
    }
}
