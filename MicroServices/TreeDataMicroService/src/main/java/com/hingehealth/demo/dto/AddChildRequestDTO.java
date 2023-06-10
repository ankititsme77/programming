package com.hingehealth.demo.dto;

public  class AddChildRequestDTO {
    private String parent;
    private String label;

    // Getters and setters

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}