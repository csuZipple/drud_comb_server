package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.entity.DrugCombInfo;
import org.csu.drugcombserver.service.DrugCombService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
@RequestMapping("/combination")
public class DrugCombController extends BaseController {
    @Autowired
    private DrugCombService service;

    @GetMapping("/list")
    public Msg fetchDrugCombinationPages(@Param("page")
                                         @NotNull(message = "The parameter page is required!")
                                                 Integer page,
                                         @Param("size")
                                         @NotNull(message = "The parameter size is required!")
                                                 Integer size){
        return success(service.fetchDrugCombinationPages(page,size));
    }

    @GetMapping("/list/{id}")
    public Msg fetchDrugCombinationPages(@PathVariable("id")Integer id){
        List<DrugCombInfo>  drugCombInfoList = service.fetchIndividualDrugCombinations(id);
        return drugCombInfoList.size() > 0 ? success(drugCombInfoList) : notFound();
    }
}
