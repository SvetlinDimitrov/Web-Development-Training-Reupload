package JavaAdvance.Exercises_Defining_Classes.Google_07;

public class Parents {
    private String parentName;
    private String parentBirthDay;

    public Parents(String parentName, String parentBirthDay) {
        this.parentName = parentName;
        this.parentBirthDay = parentBirthDay;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthDay() {
        return parentBirthDay;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentBirthDay(String parentBirthDay) {
        this.parentBirthDay = parentBirthDay;
    }
}
