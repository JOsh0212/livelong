package world.neverdie.livelong.bookreview.dto;

public enum BookType {  //책 타입
    LONG("장편"),
    SHORT("단편"),
    SERIES("시리즈");

    private final String description;

    BookType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
