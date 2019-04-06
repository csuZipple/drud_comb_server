package org.csu.drugcombserver.VO;

/**
 * 药物键值对
 */
public class DrugKV {
    private Integer blockId;
    private String drugRowName;
    private String drugColName;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
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
}
