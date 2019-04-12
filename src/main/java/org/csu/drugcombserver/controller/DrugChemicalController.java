package org.csu.drugcombserver.controller;

import org.csu.drugcombserver.VO.DrugInfo;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.service.DrugChemicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/chemical")
public class DrugChemicalController extends BaseController {
    @Autowired
    private DrugChemicalService service;

    @RequestMapping("/list")
    public Msg list(){
        return success(service.list());
    }

    @RequestMapping("/list/{CIDs}")
    public Msg getIndividualDrugInfoByCIDs(@PathVariable("CIDs") @NotNull(message = "Parameter CIDs must not be null") String id){
        DrugInfo drugInfo = service.getDrugInfoById(id);
        if(drugInfo == null){
            return notFound();
        }
        return success(drugInfo);
    }
    @RequestMapping("/info/{drugName}")
    public Msg getIndividualDrugInfoByDrugNames(@PathVariable("drugName") @NotNull(message = "Parameter drugName must not be null") String drugName){
        DrugInfo drugInfo = service.getDrugInfoByDrugName(drugName);
        if(drugInfo == null){
            return notFound();
        }
        return success(drugInfo);
    }

    //Todo: something interesting ...
}
