package org.csu.drugcombserver.service;

import org.csu.drugcombserver.VO.DrugInfo;
import org.csu.drugcombserver.mapper.DrugChemicalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugChemicalService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DrugChemicalMapper mapper;

    public List<DrugInfo> list(){
        return mapper.getAllDrugInfo();
    }

    public DrugInfo getDrugInfoById(String id){
        return mapper.getDrugInfoByDrugCIDs(id);
    }

}
