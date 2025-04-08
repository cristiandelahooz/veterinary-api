package com.veterinarynux.veterinary_api.model.enums;

public enum Specialty {
  ANESTHESIOLOGY("Anesthesiology"),
  BEHAVIOR("Behavior"),
  DENTISTRY("Dentistry"),
  DERMATOLOGY("Dermatology"),
  EMERGENCY_AND_CRITICAL_CARE("Emergency and Critical Care"),
  INTERNAL_MEDICINE("Internal Medicine"),
  MICROBIOLOGY("Microbiology"),
  NUTRITION("Nutrition"),
  ONCOLOGY("Oncology"),
  RADIOLOGY("Radiology"),
  SURGERY("Surgery"),
  ZOOLOGICAL_MEDICINE("Zoological Medicine");

  private final String displayName;

  Specialty(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
