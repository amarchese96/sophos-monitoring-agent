package it.unict.appgroup;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NetworkMonitor {
    public void updateParams(AppGroupGraph appGroupGraph) {
        appGroupGraph.getApps().forEach(app -> app.getTraffic().forEach((peerAppName, traffic) -> app.getDeployment()
                .getMetadata().getAnnotations().put("traffic." + peerAppName, String.valueOf(traffic))));
    }
}