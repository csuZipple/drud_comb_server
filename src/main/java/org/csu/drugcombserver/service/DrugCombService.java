package org.csu.drugcombserver.service;

import org.csu.drugcombserver.entity.DrugCombInfo;
import org.csu.drugcombserver.entity.DrugIntegrationInfo;
import org.csu.drugcombserver.mapper.DrugCombMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DrugCombService {
    private final static Integer RECOMMEND_LIST_SIZE = 2;
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
        List<DrugIntegrationInfo> pages = drugCombMapper.getDrugIntegrationPages((page-1)*size, size);
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
        List<DrugIntegrationInfo> pages = drugCombMapper.searchIntegrationPagesContainIndividualDrugPages(searchName,(page-1)*size, size);
        Integer total = drugCombMapper.getSearchSize(searchName);
        Map<String, Object> result = new HashMap<>();
        result.put("page", pages);
        result.put("total", total);
        return result;
    }

    public Map<String, Object> searchIntegrationByCombinationName(String combination, Integer page, Integer size){
        List<DrugIntegrationInfo> pages = drugCombMapper.getIndividualDrugIntegrationByCombinationName(combination,(page-1)*size,size);
        Integer total = drugCombMapper.getCombinationSearchSize(combination);
        Map<String, Object> result = new HashMap<>();
        result.put("page", pages);
        result.put("total", total);
        return result;
    }

    public List<String> fetchRecommendDrugIntegrationList(){
        List<String>  list = new ArrayList<>();
        int size = RECOMMEND_LIST_SIZE;
        while(size --> 0){
            int id = (int)(1+Math.random()*10000);
            list.add(drugCombMapper.getIndividualDrugIntegration(id).getDrugCombination());
        }
        size = RECOMMEND_LIST_SIZE;
        while(size --> 0){
            int id = (int)(1+Math.random()*10000);
            list.add(drugCombMapper.getIndividualDrugIntegration(id).getDrug1());
        }
        return list;
    }

}
