package belski.different;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoundRobinWeightedLoadBalancer {

    private List<String> serverIPs;

    private static Integer counter = 0;

    public RoundRobinWeightedLoadBalancer(final Map<String, Integer> serverConfigMap) {
        this.serverIPs = getServerIPsWithWeightRespect(serverConfigMap);
    }

    public String getTargetServer() {
        synchronized (counter) {
            if (counter == serverIPs.size()) {
                counter = 0;
            }
            final String targetServerIp = serverIPs.get(counter);
            counter++;

            return targetServerIp;
        }
    }

    private static List<String> getServerIPsWithWeightRespect(final Map<String, Integer> serverConfigMap) {
        final List<String> serversIps = new ArrayList<>();

        for (Map.Entry<String, Integer> serverConfig : serverConfigMap.entrySet()) {
            final Integer serverWeight = serverConfig.getValue();
            for (int i = 0; i < serverWeight; i++) {
                serversIps.add(serverConfig.getKey());
            }
        }

        return serversIps;
    }
}
