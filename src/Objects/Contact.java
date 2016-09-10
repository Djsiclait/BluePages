package Objects;

/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

public class Contact {

    // Attributes
    String firstName;
    String lastName;
    String company;
    Integer mobilePhone;
    Integer workPhone;
    Integer homePhone;
    String workEmail;
    String homeEmail;
    String street;
    String city;
    String zip;
    String state;
    String country;

    public Contact(){

    }

    public Contact(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
