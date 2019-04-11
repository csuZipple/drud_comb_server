package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.VO.DrugInfo;

import java.util.List;

public interface DrugChemicalMapper {
    @Select("SELECT * FROM drug_chemical_info")
    List<DrugInfo> getAllDrugInfo ();

    @Select("SELECT * FROM drug_chemical_info WHERE cIds = #{cIds}")
    DrugInfo getDrugInfoByDrugCIDs (@Param("cIds") String cIds);
}
