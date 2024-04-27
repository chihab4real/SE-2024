package put.io.patterns.implement;

public class CoolingSystemObserver implements SystemStateObserver{

        @Override
        public void update(SystemState systemState) {
            if (systemState.getCpuTemp() > 60.0){
                System.out.println("> Turning on cooling system...");
            }
        }
}
