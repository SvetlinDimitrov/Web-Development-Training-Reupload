package JavaOOP.Working_with_Abstraction_Lab.PointInRectangle_02;

public class Rectangle {
    private Point bottom;
    private Point top;

    Rectangle(int bottomLeftX, int bottomLeftY , int topRightX , int topRightY ){
        bottom = new Point(bottomLeftX , bottomLeftY);
        top = new Point(topRightX , topRightY);
    }
    public boolean contains(Point point){
        return point.getX() <= top.getX() && point.getX() >= bottom.getX() &&
                point.getY() <= top.getY() && point.getY() >= bottom.getY();
    }
}
