package org.csu.drugcombserver.VO;

/**
 * 特定药物的化学信息
 */
public class DrugInfo {
    private String cIds;
    private String drugName;
    private String drugNameOfficial;
    private String img;
    private String originImgUrl;
    private String molecularWeight;
    private String smilesString;

    public String getcIds() {
        return cIds;
    }

    public void setcIds(String cIds) {
        this.cIds = cIds;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOriginImgUrl() {
        return originImgUrl;
    }

    public void setOriginImgUrl(String originImgUrl) {
        this.originImgUrl = originImgUrl;
    }

    public String getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(String molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getSmilesString() {
        return smilesString;
    }

    public void setSmilesString(String smilesString) {
        this.smilesString = smilesString;
    }

    public String getDrugNameOfficial() {
        return drugNameOfficial;
    }

    public void setDrugNameOfficial(String drugNameOfficial) {
        this.drugNameOfficial = drugNameOfficial;
    }
}
