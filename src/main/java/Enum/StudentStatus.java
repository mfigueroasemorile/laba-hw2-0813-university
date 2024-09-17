package Enum;

public enum StudentStatus {

    ACTIVE("Student is active", 01),
    INACTIVE("Student is inactive", 02),
    GRADUATED("Student is graduated", 03);

    private String message;
    private int code;

    StudentStatus(String message, int code){
        this.message = message;
        this.code = code;
    }

    public boolean canEnrollToSubject() {
        return this == ACTIVE;
    }
}
