package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.VO.DrugKV;
import org.csu.drugcombserver.entity.DrugCombInfo;

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
    @Select("SELECT BlockID, DrugRow, DrugCol FROM ${table} GROUP BY BlockID ORDER BY BlockID LIMIT #{page},#{size}")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugKV> drugMapPage(@Param("table") String tableName,  @Param("page") int page, @Param("size") int size);

    /**
     * 查询表中药物对的数量
     * @param tableName 表名
     * @return 返回药物对的总数
     */
    @Select("SELECT max(BlockID) FROM ${table}")
    Integer getDrugMapSizeCount (@Param("table") String tableName);

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
}
