package Objects;

/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

public class Contact {

    // Attributes
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private String email;

    public Contact(){

    }

    public Contact(String firstName, String lastName, String telephone){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTelephone(telephone);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
