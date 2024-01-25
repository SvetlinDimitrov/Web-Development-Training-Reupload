public class CheckboxButton extends Button {

  protected CheckboxButton(SizeButton sizeButton) {
    super(sizeButton);
  }

  public void draw() {
      sizeButton.draw();
      System.out.println("Drawing a checkbox button.\n");
  }

}
