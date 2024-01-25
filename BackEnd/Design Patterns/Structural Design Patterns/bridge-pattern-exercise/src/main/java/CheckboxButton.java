public class CheckboxButton extends Button {

  private final SizeButton sizeButton;

    public CheckboxButton(SizeButton sizeButton) {
        this.sizeButton = sizeButton;
    }

    public void draw() {
      sizeButton.draw();
      System.out.println("Drawing a checkbox button.\n");
  }

}
