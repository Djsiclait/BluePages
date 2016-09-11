package Objects;

/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

public class Contact {

    // Attributes
    public String firstName;
    public String lastName;
    public String address;
    public Integer telephone;
    public String email;

    public Contact(){

    }

    public Contact(String firstName, String lastName, Integer telephone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

}
