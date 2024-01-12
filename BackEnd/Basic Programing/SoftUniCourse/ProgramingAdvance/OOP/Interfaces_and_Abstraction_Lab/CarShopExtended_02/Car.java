import java.io.Serializable;

public interface Car extends Serializable {
    public static final Integer TIRES = 4;
    public String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
