package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.VO.DrugProteinLinks;
import org.csu.drugcombserver.VO.ProteinLinks;

import java.util.List;

public interface ProteinMapper {
    @Select("select * from drug_protein where chemical = #{drugId} order by combined_score desc limit 10;")
    @Results({
            @Result(property = "drugId",  column = "chemical"),
            @Result(property = "proteinId", column = "protein"),
            @Result(property = "combinedScore", column = "combined_score")
    })
    List<DrugProteinLinks> getDrugProteinLinks(@Param("drugId") String drugId);

    @Select("select * from protein_links where protein1 = #{proteinId} order by combined_score desc limit 10;")
    @Results({
            @Result(property = "proteinId1",  column = "protein1"),
            @Result(property = "proteinId2", column = "protein2"),
            @Result(property = "combinedScore", column = "combined_score")
    })
    List<ProteinLinks> getProteinLinks(@Param("proteinId")String proteinId);
}
