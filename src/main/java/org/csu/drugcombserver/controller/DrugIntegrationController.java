package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.entity.DrugIntegrationInfo;
import org.csu.drugcombserver.service.DrugCombService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/integration")
public class DrugIntegrationController extends BaseController {
    @Autowired
    private DrugCombService service;

    @GetMapping("/list")
    public Msg fetchDrugIntegrationPages(
            @Param("page")
            @NotNull(message = "The parameter page is required!")
                    Integer page,
            @Param("size")
            @NotNull(message = "The parameter size is required!")
                    Integer size){
        return success(service.fetchDrugIntegrationPages(page,size));
    }


    @GetMapping("/list/{id}")
    public Msg fetchDrugCombinationPages(@PathVariable("id")Integer id){
        DrugIntegrationInfo drugIntegrationInfo = service.fetchIndividualDrugIntegration(id);
        return drugIntegrationInfo != null ? success(drugIntegrationInfo) : notFound();
    }

    @GetMapping("/search/{keyword}")
    public Msg fetchDrugIntegrationPages(
            @PathVariable("keyword") @NotNull String keyword,
            @Param("page")
            @NotNull(message = "The parameter page is required!")
                    Integer page,
            @Param("size")
            @NotNull(message = "The parameter size is required!")
                    Integer size){
        return success(service.searchIntegrationPagesContainIndividualDrugPages(keyword,page,size));
    }

    @GetMapping("/search")
    public Msg fetchDrugIntegrationByCombinationName(@Param("combination")
                                                     @NotNull(message = "The parameter page is required!")
                                                             String combination,
                                                     @Param("page")
                                                     @NotNull(message = "The parameter page is required!")
                                                             Integer page,
                                                     @Param("size")
                                                         @NotNull(message = "The parameter size is required!")
                                                                 Integer size){
        return success(service.searchIntegrationByCombinationName(combination, page, size));
    }

    @GetMapping("/recommends")
    public Msg fetchRecommendDrugIntegration(){
        return success(service.fetchRecommendDrugIntegrationList());
    }
}
