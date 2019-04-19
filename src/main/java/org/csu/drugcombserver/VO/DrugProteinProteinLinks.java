package org.csu.drugcombserver.VO;

import java.util.List;

/**
 * 药物对应的蛋白质与蛋白质之间的联系
 */
public class DrugProteinProteinLinks {
    private List<Object> nodes;
    private List<Object> links;

    public List<Object> getNodes() {
        return nodes;
    }

    public void setNodes(List<Object> nodes) {
        this.nodes = nodes;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
