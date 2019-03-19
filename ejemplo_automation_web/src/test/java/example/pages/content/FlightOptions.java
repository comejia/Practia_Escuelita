package example.pages.content;

public enum FlightOptions {
    ONE(1,"43"),
    TWO(2, "234"),
    THREE(3, "9696"),
    FOUR(4, "12"),
    FIVE(5, "4346");

    private final int options;
    private final String id;

    private FlightOptions(int options, String id){
        this.options = options;
        this.id = id;
    }

    public int getFlightOptions(){
        return this.options;
    }
    public String getIdFlight() {
        return this.id;
    }
}