/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

import Objects.Contact;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.SystemEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean (name = "myPhoneBook")
@SessionScoped
public class PhoneBook implements Serializable{

    // Attribute
    private List<Contact> phoneBook = new ArrayList<>();

    // Auxiliary Variables
    private String firstName;
    private String lastName;
    private String address;
    private Integer telephone;
    private String email;

    @PostConstruct
    public void init(){
        // Creating default person
        phoneBook.add(new Contact("Fulano", "DeTal", "8093230909"));
        System.out.println("\n\nCreated default contact");
    }

    // Functions
    public void CreateNewContact(String firstName, String lastName, String telephone){
        phoneBook.add(new Contact(firstName, lastName, telephone));
        System.out.println("New contact added...");
    }

    public void DeleteContact(String firstName, String lastName, Integer telephone){

        int count = 0;

        for (Contact contact: phoneBook) {
            if(contact.firstName.equals(firstName) && contact.lastName.equals(lastName) && contact.telephone.equals(telephone))
                break;

            count++;
        }

        phoneBook.remove(count);
    }

    public void EditContact(String firstName, String lastName, Integer telephone){

        for (Contact contact: phoneBook) {
            if(contact.firstName.equals(firstName) && contact.lastName.equals(lastName) && contact.telephone.equals(telephone)){
                contact.firstName = firstName;
                contact.lastName = lastName;

                break;
            }
        }
    }

    // Getters and Setters
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

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
