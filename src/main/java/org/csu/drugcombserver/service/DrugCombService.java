package org.csu.drugcombserver.service;

import org.csu.drugcombserver.entity.DrugCombInfo;
import org.csu.drugcombserver.mapper.DrugCombMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DrugCombService {
    @Autowired
    private DrugCombMapper drugCombMapper;

    public List<DrugCombInfo> getTop10 (String tableName) {
        return drugCombMapper.getTop10ByTableId(tableName);
    }
}
