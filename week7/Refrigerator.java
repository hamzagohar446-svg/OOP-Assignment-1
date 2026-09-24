public class Refrigerator extends Appliance {
    private int targetCelsius;

    public Refrigerator(String brand, String model, int targetCelsius) {
        super(brand, model);
        this.targetCelsius = targetCelsius;
    }

    @Override
    public void operate() {
        System.out.println("Cooling the compartment to " + targetCelsius + " C.");
    }
}
