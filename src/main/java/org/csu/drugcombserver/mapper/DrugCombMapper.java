package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.entity.CellLine;
import org.csu.drugcombserver.entity.DrugCombInfo;
import org.csu.drugcombserver.entity.DrugCombinationInfo;

import java.util.List;

public interface DrugCombMapper {
    @Select("SELECT * FROM ${table} LIMIT #{page},#{size}")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugCombInfo> page(@Param("table") String tableName, @Param("page") int page, @Param("size") int size);

    @Select("SELECT count(*) FROM ${table}")
    Integer getTableSizeCount (@Param("table") String tableName);

    /**
     * 分页查询表中所有药物对
     * @param tableName 表名
     * @param page 当前页
     * @param size 每页所含数据量
     * @return 返回药物对列表
     */
    @Select("SELECT * FROM ${table} LIMIT #{page},#{size}")
    @Results({
            @Result(property = "drugCombination",  column = "Drug.combination"),
            @Result(property = "synergyScore", column = "Synergy.score"),
            @Result(property = "mostSynergisticAreaScore", column = "Most.synergistic.area.score")
    })
    List<DrugCombinationInfo> drugMapPage(@Param("table") String tableName,  @Param("page") int page, @Param("size") int size);

    /**
     * 获取特定药物对中的所有信息
     * @param tableName 表名
     * @param blockId 特定药物对ID
     * @return 返回药物信息列表
     */
    @Select("SELECT * FROM ${table} WHERE BlockID = #{blockId}")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugCombInfo> drugKV(@Param("table") String tableName, @Param("blockId") int blockId);

    @Select("SELECT * FROM ${table} WHERE PairIndex = #{pairIndex}")
    @Results({
            @Result(property = "drugCombination",  column = "Drug.combination"),
            @Result(property = "synergyScore", column = "Synergy.score"),
            @Result(property = "mostSynergisticAreaScore", column = "Most.synergistic.area.score")
    })
    DrugCombinationInfo getDrugCombinationInfoByPairIndex(@Param("table") String tableName, @Param("pairIndex") int pairIndex);

    @Select("SELECT * FROM cell_line WHERE cellName = #{name}")
    CellLine getCellInfoByName(@Param("name") String name);

}
