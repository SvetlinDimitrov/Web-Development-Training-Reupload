public class RadioButton extends Button {

  protected RadioButton(SizeButton sizeButton) {
    super(sizeButton);
  }

  public void draw() {
      sizeButton.draw();
      System.out.println("Drawing a radio button.\n");
  }

}
