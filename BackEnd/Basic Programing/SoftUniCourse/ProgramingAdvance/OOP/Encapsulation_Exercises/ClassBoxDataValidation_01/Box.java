package JavaOOP.Encapsulation_Exercises.ClassBoxDataValidation_01;

public class Box {
    private  double length;
    private double width;
    private  double height;

    public void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative");
        }
        this.height = height;
    }

    public Box(double length, double width, double height) {
        setHeight(height);
        setLength(length);
        setWidth(width);
    }
    public double calculateSurfaceArea(){
        return 2*length*width + 2*length*height + 2*width*height;
    }
    public double calculateLateralSurfaceArea(){
        return 2*length*height + 2*width*height;
    }
    public double calculateVolume(){
        return length*width*height;
    }
}

//Volume = lwh
//Lateral Surface Area = 2lh + 2wh
//Surface Area = 2lw + 2lh + 2wh
