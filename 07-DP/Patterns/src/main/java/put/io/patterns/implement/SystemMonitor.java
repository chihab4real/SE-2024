package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;
import java.util.List;

public class SystemMonitor {

    private SystemInfo si;

    private HardwareAbstractionLayer hal;

    private OperatingSystem os;

    private SystemState lastSystemState = null;

    private List<SystemStateObserver> observers = new ArrayList<>();

    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();

    }

    public void probe(){

        // Get current state of the system resources

        SystemState systemState = getCurrentSystemState();
/*
        double cpuLoad = hal.getProcessor().getSystemCpuLoad()*100;
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).length;

        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);

        // Print information to the console
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", lastSystemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", lastSystemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", lastSystemState.getUsbDevices()));

        // Run garbage collector when out of memory
        if (lastSystemState.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }

        // Increase CPU cooling if the temperature is to high
        if (lastSystemState.getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }*/

        printSystemState(systemState);

        notifyObservers(systemState);
    }


    private SystemState getCurrentSystemState() {
        double cpuLoad = hal.getProcessor().getSystemCpuLoad()*100;
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).length;

        return new SystemState(cpuLoad, cpuTemp, memory, usbDevices);
    }

    public void addObserver(SystemStateObserver observer){

       //observers.add(observer);
       observers.add(observer);
    }

    public void removeObserver(SystemStateObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(SystemState systemState){
        for (SystemStateObserver observer : observers){
            observer.update(systemState);
        }
    }

    public SystemState getLastSystemState() {
        return lastSystemState;
    }

    private void printSystemState(SystemState systemState) {
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", systemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", systemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", systemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", systemState.getUsbDevices()));
    }
}
