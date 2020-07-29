package gov.naco.soch.enums;

public enum BeneficiaryCategoryEnum {

    INFANT(1l), PAEDIATRIC(2l), ADULT(3l),BENEFICIARY_WITH_DISPENSATION_HISTORY(4l),BENEFICIARY_IN_PRESENT_FACILITY(5l);

    private Long categoryType;

    BeneficiaryCategoryEnum(Long categoryType) {
        this.categoryType = categoryType;
    }

    public Long getCategoryType() {
        return categoryType;
    }
}
