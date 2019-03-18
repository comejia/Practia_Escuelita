package example.pages.content;

import Test.BaseTest;
import org.openqa.selenium.By;

public class PurchaseFormData extends BaseTest {

    private String _name;
    private String _address;
    private String _city;
    private String _state;
    private String _zip;
    private String _cardNum;
    private String _month;
    private String _year;
    private String _nameCard;



    public PurchaseFormData(String name,String address, String city, String state, String zip, String cardNum, String month, String year, String nameCard){
        this._name = name;
        this._address = address;
        this._city = city;
        this._state = state;
        this._zip = zip;
        this._cardNum = cardNum;
        this._month = month;
        this._year = year;
        this._nameCard = nameCard;
    }

    public PurchaseFormData(String month,String year)
    {
        this._month = month;
        this._year = year;

    }

    public String get_name() {
        return _name;
    }

    public String get_address() {
        return _address;
    }

    public String get_city() {
        return _city;
    }
    public String get_state() {
        return _state;
    }
    public String get_zip() {
        return _zip;
    }
    public String get_cardNum() {
        return _cardNum;
    }
    public String get_month() {
        return _month;
    }
    public String get_year() {
        return _year;
    }
    public String get_nameCard() {
        return _nameCard;
    }
}
