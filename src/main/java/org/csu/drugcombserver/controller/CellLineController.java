package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.entity.CellLine;
import org.csu.drugcombserver.service.CellLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/cellLine")
public class CellLineController extends BaseController {
    @Autowired
    private CellLineService service;


    @GetMapping("/cellName")
    public Msg fetchDrugCombinationPages(@Param("q")
                                         @NotNull(message = "The cellName is Required!")
                                         String q){
        CellLine cellLine = service.getCellLineInfoByCellName(q);
        return cellLine != null ? success(cellLine) : notFound();
    }
}
