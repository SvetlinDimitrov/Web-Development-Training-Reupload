public class AdapterAsianCity extends AsianCity{
    public AdapterAsianCity(String name, double temperature) {
        super(name, temperature);
    }

    @Override
    public double getTemperature() {
        return super.getTemperature() * 1.8 + 32;
    }

    @Override
    public String getTemperatureScale() {
        return "Fahrenheit";
    }
}
