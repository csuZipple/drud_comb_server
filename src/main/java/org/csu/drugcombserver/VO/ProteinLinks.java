package org.csu.drugcombserver.VO;

/**
 * 蛋白质之间的联系
 */
public class ProteinLinks {
   private String proteinId1;
   private String proteinId2;
   private Double combinedScore;

    public String getProteinId1() {
        return proteinId1;
    }

    public void setProteinId1(String proteinId1) {
        this.proteinId1 = proteinId1;
    }

    public String getProteinId2() {
        return proteinId2;
    }

    public void setProteinId2(String proteinId2) {
        this.proteinId2 = proteinId2;
    }

    public Double getCombinedScore() {
        return combinedScore;
    }

    public void setCombinedScore(Double combinedScore) {
        this.combinedScore = combinedScore;
    }
}
