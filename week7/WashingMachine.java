public class WashingMachine extends Appliance {
    private int loadKg;

    public WashingMachine(String brand, String model, int loadKg) {
        super(brand, model);
        this.loadKg = loadKg;
    }

    @Override
    public void operate() {
        System.out.println("Washing a " + loadKg + " kg load.");
    }
}
