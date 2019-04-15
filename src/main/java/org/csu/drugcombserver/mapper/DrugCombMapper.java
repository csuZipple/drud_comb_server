package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.entity.DrugCombInfo;
import org.csu.drugcombserver.entity.DrugIntegrationInfo;

import java.util.List;

public interface DrugCombMapper {

    @Select("select * from combination limit #{page},#{size}")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugCombInfo> getDrugCombinationPages(@Param("page") Integer page, @Param("size") Integer size);

    @Select("select * from combination where BlockId = #{blockId}")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugCombInfo>  getIndividualDrugCombination(@Param("blockId")Integer blockId);

    @Select("select count(*) from ${tableName}")
    Integer getTableSize(@Param("tableName") String tableName);

    @Select("select * from integration limit #{page},#{size}")
    @Results({
            @Result(property = "drugCombination",  column = "Drug.combination"),
            @Result(property = "synergyScore", column = "Synergy.score"),
            @Result(property = "mostSynergisticAreaScore", column = "Most.Synergistic.area.score")
    })
    List<DrugIntegrationInfo> getDrugIntegrationPages(@Param("page") Integer page, @Param("size") Integer size);
    @Select("select * from integration where id = #{blockId}")
    DrugIntegrationInfo getIndividualDrugIntegration(@Param("blockId")Integer blockId);

    @Select("select * from integration where concat(Drug1,Drug2) like #{drugName} limit #{page},#{size}")
    @Results({
            @Result(property = "drugCombination",  column = "Drug.combination"),
            @Result(property = "synergyScore", column = "Synergy.score"),
            @Result(property = "mostSynergisticAreaScore", column = "Most.Synergistic.area.score")
    })
    List<DrugIntegrationInfo> searchIntegrationPagesContainIndividualDrugPages(@Param("drugName") String name,@Param("page") Integer page, @Param("size") Integer size);

    @Select("select count(*) from integration where concat(Drug1,Drug2) like #{drugName}")
    Integer getSearchSize(@Param("drugName") String name);
}
