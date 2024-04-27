package put.io.patterns.implement;

public class GarbageCollectorObserver implements SystemStateObserver{

    @Override
    public void update(SystemState systemState) {
        if (systemState.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }
    }


}
