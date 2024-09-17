package Enum;


public enum ExamType {
    FINAL(120,7),
    LAB(300,6),
    MIDEXAM(60,6),
    MULTUPLE_CHOICE(45,6);

    private int duration;
    private int minScore;

    ExamType(int duration, int minScore){
        this.duration = duration;
        this.minScore = minScore;
    }

    public boolean isLongExam(){
        return this == FINAL  || this == LAB;
    }
}
