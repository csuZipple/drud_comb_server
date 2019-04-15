package org.csu.drugcombserver.service;

import org.csu.drugcombserver.entity.CellLine;
import org.csu.drugcombserver.mapper.CellLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CellLineService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CellLineMapper cellLineMapper;

    public CellLine getCellLineInfoByCellName(String name){
        return cellLineMapper.getCellLineInfo(name);
    }

}
