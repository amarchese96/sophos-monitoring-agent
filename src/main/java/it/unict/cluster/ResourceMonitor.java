package it.unict.cluster;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResourceMonitor {

    public void updateParams(ClusterGraph clusterGraph) {
        clusterGraph.getClusterNodes().forEach(clusterNode -> {
            clusterNode.getNode().getMetadata().getAnnotations().put("cpu-usage",
                    String.valueOf(clusterNode.getCpuUsage()));

            clusterNode.getNode().getMetadata().getAnnotations().put("memory-usage",
                    String.valueOf(clusterNode.getMemoryUsage()));
        });
    }
}