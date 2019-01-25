package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.entity.DrugCombInfo;

import java.util.List;

public interface DrugCombMapper {
    @Select("SELECT * FROM ${table} LIMIT 10")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugCombInfo> getTop10ByTableId(@Param("table") String tableName);

    @Select("SELECT * FROM ${table} LIMIT #{page},#{size}")
    @Results({
            @Result(property = "drugRowName",  column = "DrugRow"),
            @Result(property = "drugColName", column = "DrugCol")
    })
    List<DrugCombInfo> page(@Param("table") String tableName, @Param("page") int page, @Param("size") int size);

    @Select("SELECT count(*) FROM ${table}")
    Integer getTableSizeCount (@Param("table") String tableName);
}
