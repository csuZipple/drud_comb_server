package org.csu.drugcombserver.service;

import org.csu.drugcombserver.VO.DrugProteinLinks;
import org.csu.drugcombserver.VO.DrugProteinProteinLinks;
import org.csu.drugcombserver.VO.ProteinLinks;
import org.csu.drugcombserver.mapper.ProteinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class ProteinService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProteinMapper mapper;

    private List<DrugProteinLinks> getDrugProteinLinks(String drugId){
        return mapper.getDrugProteinLinks(drugId);
    }

    private List<ProteinLinks> getProteinLinks(String proteinId){
        return mapper.getProteinLinks(proteinId);
    }

    public DrugProteinProteinLinks getDrugProteinProteinLinks(String drugId){
        DrugProteinProteinLinks result = new DrugProteinProteinLinks();
        List<Object> nodes = new ArrayList<>();
        List<Object> links = new ArrayList<>();
        Set<String> proteinIdSet = new HashSet<>();
        List<DrugProteinLinks> drugProteinLinks = getDrugProteinLinks(drugId);
        Map<String,String> proteinMap;
        for (DrugProteinLinks temp : drugProteinLinks) {
            proteinMap = new HashMap<>();
            proteinMap.put("id", temp.getProteinId());
            proteinIdSet.add(temp.getProteinId());
            nodes.add(proteinMap);
        }

        for (DrugProteinLinks temp : drugProteinLinks) {
            List<ProteinLinks> tempProteinLinkList = getProteinLinks(temp.getProteinId());
            for (ProteinLinks tempProteinLinks : tempProteinLinkList) {
                if(proteinIdSet.contains(tempProteinLinks.getProteinId2())){
                    proteinMap = new HashMap<>();
                    proteinMap.put("source", tempProteinLinks.getProteinId1());
                    proteinMap.put("target", tempProteinLinks.getProteinId2());
                    links.add(proteinMap);
                }
            }
        }

        result.setNodes(nodes);
        result.setLinks(links);
        return result;
    }
}
