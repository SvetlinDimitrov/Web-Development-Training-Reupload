public class AdapterAsianCity implements City {
    private final City city;

    public AdapterAsianCity(City city) {
        this.city = city;
    }

    @Override
    public String getName() {
        return city.getName();
    }

    @Override
    public double getTemperature() {
        return city.getTemperature() * 1.8 +32;
    }

    @Override
    public String getTemperatureScale() {
        return "Fahrenheit";
    }

    @Override
    public boolean getHasWeatherWarning() {
        return city.getHasWeatherWarning();
    }

    @Override
    public void setHasWeatherWarning(boolean hasWeatherWarning) {
        city.setHasWeatherWarning(hasWeatherWarning);
    }
}
