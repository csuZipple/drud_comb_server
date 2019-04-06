package org.csu.drugcombserver.service;

import org.csu.drugcombserver.mapper.DrugCombMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DrugCombService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DrugCombMapper drugCombMapper;

    public Map page (String tableName, int page, int size) {
        Map<String,Object> res = new HashMap<>();
        res.put("page",drugCombMapper.page(tableName, (page - 1) * size, size));
        res.put("total",drugCombMapper.getTableSizeCount(tableName)/size); //Todo : 总数可以考虑缓存起来
        return res;
    }

    public Integer count (String tableName){
        return drugCombMapper.getTableSizeCount(tableName);
    }

    public Map getDrugMapPage (String tableName, int page, int size){
        Map<String,Object> res = new HashMap<>();
        res.put("page",drugCombMapper.drugMapPage(tableName, (page - 1) * size, size));
        res.put("total",drugCombMapper.getDrugMapSizeCount(tableName)/size);
        return res;
    }
}
