package org.csu.drugcombserver.controller;

import org.apache.ibatis.annotations.Param;
import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.entity.Code;
import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.service.DrugCombService;
import org.csu.drugcombserver.util.Constant;
import org.csu.drugcombserver.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class DrugCombController extends BaseController {
    @Autowired
    private DrugCombService service;
    @RequestMapping("/origin/{tableIndex}")
    public Msg getAll(@PathVariable("tableIndex") String tableIndex){
        int index; // start with 1
        try{
            index = Integer.parseInt(tableIndex);
        }catch (Exception e){
            return badRequest("Only accept integers.");
        }
        if(index > Constant.TABLELIST.length || index <= 0){
            return notFound();
        }else{
            try{
                return success(service.getTop10(Constant.TABLELIST[--index]));
            }catch (Exception e){
                return error();
            }
        }
    }

    @RequestMapping("/origin/{tableIndex}/page")
    public Msg page(@PathVariable("tableIndex") String tableIndex, @Param("page") String pageString, @Param("size") String sizeString){
       return Result.error(Code.SERVER_ERROR,"Do nothing.");
    }
}
