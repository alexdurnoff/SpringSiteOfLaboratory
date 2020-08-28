package ru.durnov.entity;

public class Calculate {
    private String title;
    private String unit;
    private int coast;
    private int coast_fr;

    public Calculate(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public int getCoast_fr() {
        return coast_fr;
    }

    public void setCoast_fr(int coast_fr) {
        this.coast_fr = coast_fr;
    }
}
