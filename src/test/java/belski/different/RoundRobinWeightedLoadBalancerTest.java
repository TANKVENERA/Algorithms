package belski.different;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RoundRobinWeightedLoadBalancerTest {

    private static final Map<String, Integer> SERVER_CONFIG_MAP = new LinkedHashMap<>();
    private static final List<String> EXPECTED_TARGET_IPS = List.of(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.3",
            "192.168.0.3",
            "192.168.0.1");

    private final RoundRobinWeightedLoadBalancer balancer = new RoundRobinWeightedLoadBalancer(SERVER_CONFIG_MAP);

    @BeforeAll
    public static void beforeAll() {
        SERVER_CONFIG_MAP.put("192.168.0.1", 1);
        SERVER_CONFIG_MAP.put("192.168.0.2", 2);
        SERVER_CONFIG_MAP.put("192.168.0.3", 3);
    }

    @Test
    public void shouldReturnTargetServerIPSWithServerWeightRespect() throws ExecutionException, InterruptedException {
        final List<String> actualTargetIps = new ArrayList<>();
        final ExecutorService pool = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            final Future<String> future = pool.submit(balancer::getTargetServer);
            actualTargetIps.add(future.get());
        }

        assertEquals(actualTargetIps, EXPECTED_TARGET_IPS);
    }
}
