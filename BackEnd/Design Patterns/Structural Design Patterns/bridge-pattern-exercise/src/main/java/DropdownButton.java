public class DropdownButton extends Button {

  protected DropdownButton(SizeButton sizeButton) {
    super(sizeButton);
  }

  public void draw() {
      sizeButton.draw();
      System.out.println("Drawing a dropdown button.\n");
  }

}
