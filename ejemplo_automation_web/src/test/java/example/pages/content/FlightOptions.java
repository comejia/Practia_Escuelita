package example.pages.content;

public enum FlightOptions {
    ONE(1),
    TWO(2),
    THREE(3);

    private final int options;

    private FlightOptions(int options){
        this.options = options;
    }

    public int getFlightOptions(){
        return this.options;
    }
}
