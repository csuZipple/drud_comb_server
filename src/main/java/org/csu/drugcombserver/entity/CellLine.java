package org.csu.drugcombserver.entity;

public class CellLine {
    private String cellName;
    private String cosmicId;
    private String tag;

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getCosmicId() {
        return cosmicId;
    }

    public void setCosmicId(String cosmicId) {
        this.cosmicId = cosmicId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
