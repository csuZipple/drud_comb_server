package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.entity.CellLine;
import org.csu.drugcombserver.service.CellLineService;
import org.csu.drugcombserver.service.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/proteins")
public class ProteinController extends BaseController {
    @Autowired
    private ProteinService service;

    @GetMapping("/{drugId}")
    public Msg getDrugProteinLinks(@PathVariable("drugId") String drugId){
        return success(service.getDrugProteinProteinLinks(drugId));
    }
}
