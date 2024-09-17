package Enum;

public enum BookType {

    FICTION("Novels and stories", 01),
    SCIENCE("Scientific papers", 02),
    HISTORY("History books", 03),
    MATHS("exercices book",04);

    private String description;
    private int code;

    BookType(String description, int code){
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static BookType getByCode(int code) {
        for (BookType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
