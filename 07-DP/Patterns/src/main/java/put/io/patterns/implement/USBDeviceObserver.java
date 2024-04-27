package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{

    private int previousUsbDevices = -1;

    @Override
    public void update(SystemState systemState) {
        int currentUSBDevices = systemState.getUsbDevices();

        if (previousUsbDevices != -1) {
            if (currentUSBDevices > previousUsbDevices) {
                System.out.println("> USB devices increased");
            } else if (currentUSBDevices < previousUsbDevices) {
                System.out.println("> USB devices decreased");
            }
        }

        previousUsbDevices = currentUSBDevices;
    }
}
