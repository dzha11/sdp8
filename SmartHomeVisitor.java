interface Device {
    void accept(DeviceVisitor visitor);
    String getName();
}

// визитор интерфэйс
interface DeviceVisitor {
    void visit(Light light);
    void visit(TV tv);
    void visit(AirConditioner ac);
}

// конкретные устройства
class Light implements Device {
    private boolean isOn = false;

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }
    public boolean isOn() { return isOn; }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return "light";
    }
}

class TV implements Device {
    private boolean isOn = false;

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }
    public boolean isOn() { return isOn; }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return "tv";
    }
}

class AirConditioner implements Device {
    private boolean isOn = false;

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }
    public boolean isOn() { return isOn; }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return "air conditioner";
    }
}

// визитор который онкает все устройства
class TurnOnVisitor implements DeviceVisitor {
    @Override
    public void visit(Light light) {
        light.turnOn();
        System.out.println(light.getName() + " turned on");
    }

    @Override
    public void visit(TV tv) {
        tv.turnOn();
        System.out.println(tv.getName() + " turned on");
    }

    @Override
    public void visit(AirConditioner ac) {
        ac.turnOn();
        System.out.println(ac.getName() + " turned on️");
    }
}

// а тут он оффкает
class TurnOffVisitor implements DeviceVisitor {
    @Override
    public void visit(Light light) {
        light.turnOff();
        System.out.println(light.getName() + " turned off");
    }

    @Override
    public void visit(TV tv) {
        tv.turnOff();
        System.out.println(tv.getName() + " turned off");
    }

    @Override
    public void visit(AirConditioner ac) {
        ac.turnOff();
        System.out.println(ac.getName() + " turned off ");
    }
}

// главный класс
public class SmartHomeVisitor {
    public static void main(String[] args) {
        Device[] devices = {
                new Light(),
                new TV(),
                new AirConditioner()
        };

        System.out.println(" smart home system started");
        System.out.println("turning all devices on");
        DeviceVisitor onVisitor = new TurnOnVisitor();
        for (Device d : devices) d.accept(onVisitor);

        System.out.println("turning all devices");
        DeviceVisitor offVisitor = new TurnOffVisitor();
        for (Device d : devices) d.accept(offVisitor);

        System.out.println(" all devices processed");
    }
}
