package org.csu.drugcombserver.service;

import org.csu.drugcombserver.mapper.DrugCombMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugCombService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DrugCombMapper drugCombMapper;

}
