package Enum;

public enum SubjectCategory {

    MATHS("Math department", 150),
    BUSINESS("Business and Economic", 100),
    SCIENCE("Science and humanistics", 80),
    HUMANITIES("Art", 90);

    private String department;
    private int creditsRequired;

    SubjectCategory(String department, int creditsRequired){
        this.department = department;
        this.creditsRequired = creditsRequired;
    }

    public String getDepartment() {
        return department;
    }

    public int getCreditsRequired() {
        return creditsRequired;
    }

    public boolean availableToEnroll(int availableCredits){
        return availableCredits >= this.creditsRequired;
    }
}