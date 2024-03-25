package it.unict.service;

import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import io.smallrye.mutiny.Uni;

@RegisterRestClient(configKey = "telemetry")
public interface TelemetryService {

    @GET
    @Path("/metrics/nodes/cpu-usage")
    Uni<Double> getNodeCpuUsage(@QueryParam("node") String node, String rangeWidth);

    @GET
    @Path("/metrics/nodes/memory-usage")
    Uni<Double> getNodeMemoryUsage(@QueryParam("node") String node, @QueryParam("range-width") String rangeWidth);

    @GET
    @Path("/metrics/nodes/latencies")
    Uni<Map<String, Double>> getNodeLatencies(@QueryParam("node") String node,
            @QueryParam("range-width") String rangeWidth);

    @GET
    @Path("/metrics/apps/cpu-usage")
    Uni<Double> getAppCpuUsage(@QueryParam("app-group") String appGroupName, @QueryParam("app") String appName,
            @QueryParam("range-width") String rangeWidth);

    @GET
    @Path("/metrics/apps/memory-usage")
    Uni<Double> getAppMemoryUsage(@QueryParam("app-group") String appGroupName, @QueryParam("app") String appName,
            @QueryParam("range-width") String rangeWidth);

    @GET
    @Path("/metrics/apps/traffic")
    Uni<Map<String, Double>> getAppTraffic(@QueryParam("app-group") String appGroupName,
            @QueryParam("app") String appName, @QueryParam("direction") String direction,
            @QueryParam("range-width") String rangeWidth);
}