package ru.durnov.entity;

import java.nio.file.Path;

public class Device {
    private String title;
    private String description;
    private String accuracyClass;
    private String measurementRange;
    private String dateOfVerification;
    private String dateOfNextVerification;
    private String imageOfDevice;
    private String sertificate;

    public Device() {
    }

    @Override
    public String toString(){
        return title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccuracyClass() {
        return accuracyClass;
    }

    public void setAccuracyClass(String accuracyClass) {
        this.accuracyClass = accuracyClass;
    }

    public String getMeasurementRange() {
        return measurementRange;
    }

    public void setMeasurementRange(String measurementRange) {
        this.measurementRange = measurementRange;
    }

    public String getDateOfVerification() {
        return dateOfVerification;
    }

    public void setDateOfVerification(String dateOfVerification) {
        this.dateOfVerification = dateOfVerification;
    }

    public String getDateOfNextVerification() {
        return dateOfNextVerification;
    }

    public void setDateOfNextVerification(String dateOfNextVerification) {
        this.dateOfNextVerification = dateOfNextVerification;
    }

    public String getImageOfDevice() {
        return imageOfDevice;
    }

    public void setImageOfDevice(String imageOfDevice) {
        this.imageOfDevice = imageOfDevice;
    }

    public String getSertificate() {
        return sertificate;
    }

    public void setSertificate(String sertificate) {
        this.sertificate = sertificate;
    }
}
