package org.csu.drugcombserver.VO;

/**
 * 药物对应的靶标蛋白
 */
public class DrugProteinLinks {
    private String drugId;
    private String proteinId;
    private String experimental;
    private String prediction;
    private String database;
    private Double textmining;
    private Double combinedScore;

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getProteinId() {
        return proteinId;
    }

    public void setProteinId(String proteinId) {
        this.proteinId = proteinId;
    }

    public String getExperimental() {
        return experimental;
    }

    public void setExperimental(String experimental) {
        this.experimental = experimental;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Double getTextmining() {
        return textmining;
    }

    public void setTextmining(Double textmining) {
        this.textmining = textmining;
    }

    public Double getCombinedScore() {
        return combinedScore;
    }

    public void setCombinedScore(Double combinedScore) {
        this.combinedScore = combinedScore;
    }
}
