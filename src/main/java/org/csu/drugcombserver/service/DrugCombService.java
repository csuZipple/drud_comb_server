package org.csu.drugcombserver.service;

import org.csu.drugcombserver.entity.DrugCombInfo;
import org.csu.drugcombserver.entity.DrugIntegrationInfo;
import org.csu.drugcombserver.mapper.DrugCombMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DrugCombService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DrugCombMapper drugCombMapper;

    public Map<String, Object> fetchDrugCombinationPages(Integer page, Integer size){
        List<DrugCombInfo> pages = drugCombMapper.getDrugCombinationPages(page-1, size);
        Integer total = drugCombMapper.getTableSize("combination");
        Map<String, Object> result = new HashMap<>();
        result.put("page", pages);
        result.put("total", total);
        return result;
    }

    public List<DrugCombInfo>  fetchIndividualDrugCombinations(Integer id){
        return drugCombMapper.getIndividualDrugCombination(id);
    }



    public Map<String, Object> fetchDrugIntegrationPages(Integer page, Integer size){
        List<DrugIntegrationInfo> pages = drugCombMapper.getDrugIntegrationPages(page-1, size);
        Integer total = drugCombMapper.getTableSize("integration");
        Map<String, Object> result = new HashMap<>();
        result.put("page", pages);
        result.put("total", total);
        return result;
    }

    public DrugIntegrationInfo fetchIndividualDrugIntegration(Integer id){
        return drugCombMapper.getIndividualDrugIntegration(id);
    }

    public Map<String, Object> searchIntegrationPagesContainIndividualDrugPages(String drugName, Integer page, Integer size){
        String searchName = "%"+drugName+"%";
        List<DrugIntegrationInfo> pages = drugCombMapper.searchIntegrationPagesContainIndividualDrugPages(searchName,page-1, size);
        Integer total = drugCombMapper.getSearchSize(searchName);
        Map<String, Object> result = new HashMap<>();
        result.put("page", pages);
        result.put("total", total);
        return result;
    }

}
