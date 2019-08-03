package org.csu.drugcombserver.VO;

public class ProteinInfo {
    private String id;
    private String preferredName;
    private String proteinSize;
    private String annotation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getProteinSize() {
        return proteinSize;
    }

    public void setProteinSize(String proteinSize) {
        this.proteinSize = proteinSize;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
