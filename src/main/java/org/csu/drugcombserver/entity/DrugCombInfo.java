package org.csu.drugcombserver.entity;

/**
 * 组合药物对靶细胞的拮抗信息
 */
public class DrugCombInfo {
    private Integer blockId;
    private Integer row;
    private Integer col;
    private String drugRowName;
    private String drugColName;
    private Double concRow;
    private Double concCol;
    private String concRowUnit;
    private String concColUnit;
    private Double response;

    public DrugCombInfo() {
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getDrugRowName() {
        return drugRowName;
    }

    public void setDrugRowName(String drugRowName) {
        this.drugRowName = drugRowName;
    }

    public String getDrugColName() {
        return drugColName;
    }

    public void setDrugColName(String drugColName) {
        this.drugColName = drugColName;
    }

    public Double getConcRow() {
        return concRow;
    }

    public void setConcRow(Double concRow) {
        this.concRow = concRow;
    }

    public Double getConcCol() {
        return concCol;
    }

    public void setConcCol(Double concCol) {
        this.concCol = concCol;
    }

    public String getConcRowUnit() {
        return concRowUnit;
    }

    public void setConcRowUnit(String concRowUnit) {
        this.concRowUnit = concRowUnit;
    }

    public String getConcColUnit() {
        return concColUnit;
    }

    public void setConcColUnit(String concColUnit) {
        this.concColUnit = concColUnit;
    }

    public Double getResponse() {
        return response;
    }

    public void setResponse(Double response) {
        this.response = response;
    }
}
