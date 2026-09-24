public abstract class Appliance {
    protected String brand;
    protected String model;

    public Appliance(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void turnOn() {
        System.out.println(brand + " " + model + " is switched on.");
    }

    public void turnOff() {
        System.out.println(brand + " " + model + " is switched off.");
    }

    public abstract void operate();
}
