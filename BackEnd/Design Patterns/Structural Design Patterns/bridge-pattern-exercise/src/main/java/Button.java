public abstract class Button {

  protected SizeButton sizeButton;

  protected Button (SizeButton sizeButton){
    this.sizeButton = sizeButton;
  }

  abstract void draw();

}
