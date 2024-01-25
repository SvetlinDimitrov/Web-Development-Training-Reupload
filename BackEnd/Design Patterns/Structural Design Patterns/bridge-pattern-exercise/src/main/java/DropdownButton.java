public class DropdownButton extends Button {

  private final SizeButton sizeButton;

    public DropdownButton(SizeButton sizeButton) {
        this.sizeButton = sizeButton;
    }

    public void draw() {
      sizeButton.draw();
      System.out.println("Drawing a dropdown button.\n");
  }

}
