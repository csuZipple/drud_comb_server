package org.csu.drugcombserver.service;

import org.csu.drugcombserver.entity.DrugCombInfo;
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

    public List<DrugCombInfo> getTop10 (String tableName) {
        return drugCombMapper.getTop10ByTableId(tableName);
    }

    public Map page (String tableName, int page, int size) {
        Map<String,Object> res = new HashMap<>();
        res.put("page",drugCombMapper.page(tableName, (page - 1) * size, size));
        res.put("total",drugCombMapper.getTableSizeCount(tableName)/size); //Todo : 总数可以考虑缓存起来
        return res;
    }

    public Integer count (String tableName){
        return drugCombMapper.getTableSizeCount(tableName);
    }
}
