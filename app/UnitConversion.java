import java.util.HashMap;
import java.util.Map;

public class UnitConversion {
    private Map<String, Double> conversionFactors;

    public UnitConversion() {
        conversionFactors = new HashMap<>();
        conversionFactors.put("meters", 1.0);
        conversionFactors.put("kilometers", 1000.0);
        conversionFactors.put("miles", 1609.34);
    }

    public double convert(double value, String fromUnit, String toUnit) {
        return value * conversionFactors.get(fromUnit) / conversionFactors.get(toUnit);
    }
}
