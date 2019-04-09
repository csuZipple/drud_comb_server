package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.VO.DrugInfo;

import java.util.List;

public interface DrugChemicalMapper {
    @Select("SELECT a.drugName,a.img,a.origin_img_url,a.drugId, b.molecularWeight,b.smilesString from druglist as a INNER JOIN drug_chemical_info as b ON a.drugId = b.id;")
    @Results({
            @Result(property = "cIds",  column = "drugId"),
            @Result(property = "originImgUrl",  column = "origin_img_url")
    })
    List<DrugInfo> getAllDrugInfo ();

    @Select("SELECT * FROM (\n" +
            "  SELECT a.drugName,a.img,a.origin_img_url,a.drugId, b.drugName as drugName2,b.molecularWeight,b.smilesString from druglist as a INNER JOIN drug_chemical_info as b ON  a.drugId = b.id\n" +
            ") as v WHERE v.drugId = #{cIds}")
    @Results({
            @Result(property = "cIds",  column = "drugId"),
            @Result(property = "originImgUrl",  column = "origin_img_url")
    })
    DrugInfo getDrugInfoByDrugCIDs (@Param("cIds") String cIds);
}
