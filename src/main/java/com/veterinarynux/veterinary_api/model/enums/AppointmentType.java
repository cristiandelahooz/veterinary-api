package com.veterinarynux.veterinary_api.model.enums;

public enum AppointmentType {
  VACCINATION("oklch(0.65 0.5 120)"),
  CHECKUP("oklch(0.7 0.4 240)"),
  SURGERY("oklch(0.6 0.5 0)"),
  DENTAL_CLEANING("oklch(0.8 0.3 200)"),
  GROOMING("oklch(0.75 0.4 90)");

  private final String color;

  AppointmentType(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }
}
