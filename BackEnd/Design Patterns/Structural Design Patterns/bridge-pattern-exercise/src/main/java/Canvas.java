public class Canvas {

  public static void main(String[] args) {

    CheckboxButton checkboxButton = new CheckboxButton(new SmallButton());
    checkboxButton.draw();

    RadioButton radioButton = new RadioButton(new MediumButton());
    radioButton.draw();

    DropdownButton dropdownButton = new DropdownButton(new LargeButton());
    dropdownButton.draw();
  }

}
