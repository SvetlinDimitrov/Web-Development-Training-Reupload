package JavaOOP.Working_with_Abstraction_Lab.HotelReservation_04;

public class PriceCalculator {
    private int year;
    private String color;


    public PriceCalculator(int year , String color){
        this.year = year;
        this.color = color;
    }
    public static double MoneyToPay(double PricePerDay , int days , String season , String VIP){
        return (PricePerDay * days * Season.valueOf(season).getValue()) -
                (PricePerDay * days * Season.valueOf(season).getValue())*Discount.valueOf(VIP).getPercent()/100;
    }
}
