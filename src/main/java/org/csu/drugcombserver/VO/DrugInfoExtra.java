package org.csu.drugcombserver.VO;

/**
 * 给drug chemical info 补充相关药物信息
 */
public class DrugInfoExtra {
    private String cIds;
    private String indication;
    private String pharmacoDynamics;

    public String getcIds() {
        return cIds;
    }

    public void setcIds(String cIds) {
        this.cIds = cIds;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getPharmacoDynamics() {
        return pharmacoDynamics;
    }

    public void setPharmacoDynamics(String pharmacoDynamics) {
        this.pharmacoDynamics = pharmacoDynamics;
    }
}
