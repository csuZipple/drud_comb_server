package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.VO.DrugInfo;
import org.csu.drugcombserver.VO.DrugInfoDescription;
import org.csu.drugcombserver.VO.DrugInfoExtra;

import java.util.List;

public interface DrugChemicalMapper {
    @Select("SELECT * FROM drug_chemical_info")
    List<DrugInfo> getAllDrugInfo ();

    @Select("SELECT * FROM drug_chemical_info WHERE cIds = #{cIds}")
    DrugInfo getDrugInfoByDrugCIDs (@Param("cIds") String cIds);

    @Select("SELECT Indication,Pharmacodynamics FROM drug_chemical_info_extra WHERE CID = #{cIds}")
    @Results({
            @Result(property = "indication",  column = "Indication"),
            @Result(property = "pharmacoDynamics", column = "Pharmacodynamics")
    })
    DrugInfoExtra getDrugInfoExtraByDrugCIDs (@Param("cIds") String cIds);

    @Select("SELECT * FROM drug_chemical_info_description WHERE CID = #{cIds}")
    @Results({
            @Result(property = "drugName",  column = "DrugName(unofficial)"),
            @Result(property = "description", column = "Description")
    })
    DrugInfoDescription getDrugInfoDescriptionByDrugCIDs (@Param("cIds") String cIds);

    @Select("SELECT * FROM drug_chemical_info WHERE drugName = #{name}")
    DrugInfo getDrugInfoByDrugName(@Param("name") String name);
}
