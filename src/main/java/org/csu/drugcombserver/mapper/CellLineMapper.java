package org.csu.drugcombserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.csu.drugcombserver.entity.CellLine;

public interface CellLineMapper {
    @Select("select * from cell_line where cellName = #{name}")
    CellLine getCellLineInfo(@Param("name") String cellName);
}
