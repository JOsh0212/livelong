package world.neverdie.livelong.bookreview.dto;

public enum ReadingStrategies { //독서전략
    Scanning("발췌독"),
    Skimming("훑어보기"),
    CloseReading("정독"),
    ReReading("회독"),
    SpeedReading("속독");

    private final String description;

    ReadingStrategies(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
}
