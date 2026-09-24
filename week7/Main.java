public class Main {
    public static void main(String[] args) {
        Appliance[] kitchen = {
            new WashingMachine("LG", "TurboWash", 8),
            new Refrigerator("Panasonic", "PrimeFresh", 4)
        };

        for (Appliance appliance : kitchen) {
            appliance.turnOn();
            appliance.operate();
            appliance.turnOff();
            System.out.println();
        }
    }
}
