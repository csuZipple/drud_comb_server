package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.entity.Code;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.service.DrugCombService;
import org.csu.drugcombserver.util.Constant;
import org.csu.drugcombserver.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/convert")
public class DrugCombController extends BaseController {
    @Autowired
    private DrugCombService service;
    @RequestMapping("/origin/{tableIndex}")
    public Msg getAll(@PathVariable("tableIndex")
                      @Max(value = 4,message = "Maximum is 4")
                      @Min(value = 1,message = "Minimum is 1") int tableIndex){
        return success(service.getTop10(Constant.TABLELIST[--tableIndex]));
    }

    @RequestMapping("/origin/{tableIndex}/page")
    public Msg page(@PathVariable("tableIndex")
                    @Max(value = 4,message = "Maximum is 4")
                    @Min(value = 1,message = "Minimum is 1") int tableIndex,
                    @Param("page") String pageString,
                    @Param("size") String sizeString){
       return Result.error(Code.SERVER_ERROR,"Do nothing.");
    }
}
