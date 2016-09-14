/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

import Objects.Contact;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    private String telephone;
    private String email;

    @PostConstruct
    public void init(){
        // Creating default person
        getPhoneBook().add(new Contact("Fulano", "DeTal", "8093230909"));
        System.out.println("\n\nCreated default contact");
    }

    //public List<Contact> getPhoneBook(){ return phoneBook; }

    // Functions
    public void CreateNewContact(String firstName, String lastName, String telephone){
        getPhoneBook().add(new Contact(firstName, lastName, telephone));
        System.out.println("New contact added...");
    }

    public void DeleteContact(String firstName, String lastName, Integer telephone){

        int count = 0;

        for (Contact contact: getPhoneBook()) {
            if(contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName) && contact.getTelephone().equals(telephone))
                break;

            count++;
        }

        getPhoneBook().remove(count);
    }

   /* public void EditContact(String firstName, String lastName, Integer telephone){

        for (Contact contact: getPhoneBook()) {
            if(contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName) && contact.getTelephone().equals(telephone)){
                contact.setFirstName(firstName);
                contact.setLastName(lastName);

                break;
            }
        }
    } */

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

    public List<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }
}
