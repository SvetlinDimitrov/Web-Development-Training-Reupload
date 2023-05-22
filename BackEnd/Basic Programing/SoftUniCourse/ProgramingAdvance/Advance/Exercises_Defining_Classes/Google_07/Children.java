package JavaAdvance.Exercises_Defining_Classes.Google_07;

public class Children {
    private String childrenName;
    private String childrenBirthday;

    public Children(String childrenName, String childrenBirthday) {
        this.childrenName = childrenName;
        this.childrenBirthday = childrenBirthday;
    }

    public String getChildrenName() {
        return childrenName;
    }

    public String getChildrenBirthday() {
        return childrenBirthday;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public void setChildrenBirthday(String childrenBirthday) {
        this.childrenBirthday = childrenBirthday;
    }
}
