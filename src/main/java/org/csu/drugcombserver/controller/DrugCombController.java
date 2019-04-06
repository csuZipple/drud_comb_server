package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.service.DrugCombService;
import org.csu.drugcombserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/convert")
public class DrugCombController extends BaseController {
    @Autowired
    private DrugCombService service;
    @RequestMapping("/origin/{tableIndex}")
    public Msg getAll(@PathVariable("tableIndex")
                      @Max(value = 4,message = "Maximum is 4")
                      @Min(value = 1,message = "Minimum is 1") Integer tableIndex){
        return success(Constant.TABLELIST[--tableIndex]);
    }

    @RequestMapping("/origin/{tableIndex}/page")
    public Msg page(@PathVariable("tableIndex")
                    @NotNull
                    @Max(value = 4,message = "Maximum is 4")
                    @Min(value = 1,message = "Minimum is 1") Integer tableIndex,
                    @Param("page")
                    @NotNull(message = "Parameter page must not be null")
                    @Min(value = 1,message = "The minimum page is 1")Integer page,
                    @Param("size")
                    @NotNull(message = "Parameter size must not be null")
                    @Min(value = 2,message = "The minimum size is 2")Integer size){
       return success(service.page(Constant.TABLELIST[--tableIndex],page,size));
    }
}
