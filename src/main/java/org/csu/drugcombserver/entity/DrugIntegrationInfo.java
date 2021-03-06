package org.csu.drugcombserver.entity;

/**
 * 组合药物对的原始信息 - 包含细胞系 计算方式 ZIP 得分等
 */
public class DrugIntegrationInfo {
    private Integer id;
    private String drugCombination;
    private String drug1;
    private String drug2;
    private String cellName;
    private Double synergyScore;
    private String source;


    public String getDrugCombination() {
        return drugCombination;
    }

    public void setDrugCombination(String drugCombination) {
        this.drugCombination = drugCombination;
    }

    public String getDrug1() {
        return drug1;
    }

    public void setDrug1(String drug1) {
        this.drug1 = drug1;
    }

    public String getDrug2() {
        return drug2;
    }

    public void setDrug2(String drug2) {
        this.drug2 = drug2;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public Double getSynergyScore() {
        return synergyScore;
    }

    public void setSynergyScore(Double synergyScore) {
        this.synergyScore = synergyScore;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "DrugIntegrationInfo{" +
                "id=" + id +
                ", drugCombination='" + drugCombination + '\'' +
                ", drug1='" + drug1 + '\'' +
                ", drug2='" + drug2 + '\'' +
                ", cellName='" + cellName + '\'' +
                ", synergyScore=" + synergyScore +
//                ", mostSynergisticAreaScore=" + mostSynergisticAreaScore +
                '}';
    }
}
