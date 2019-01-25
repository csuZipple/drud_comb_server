package org.csu.drugcombserver.controller;

import org.csu.drugcombserver.entity.Code;
import org.csu.drugcombserver.entity.Msg;
import org.csu.drugcombserver.mapper.DrugCombMapper;
import org.csu.drugcombserver.util.Constant;
import org.csu.drugcombserver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class DrugCombController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DrugCombMapper drugCombMapper;
    @RequestMapping("/origin/{tableIndex}")
    public Msg getAll(@PathVariable("tableIndex") String tableIndex){
        int index;
        try{
            index = Integer.parseInt(tableIndex);
        }catch (Exception e){
            return Result.error(Code.BAD_REQUEST,"Only accept integers.");
        }
        if(index>= Constant.TABLELIST.length){
            return Result.error(Code.NOT_FOUND,"Data not found");
        }else{
            try{
                return Result.success(drugCombMapper.getTop10ByTableId(Constant.TABLELIST[index]));
            }catch (Exception e){
                return Result.error(Code.SERVER_ERROR,"Server error.");
            }
        }
    }
}
