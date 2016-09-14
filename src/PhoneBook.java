/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

import Objects.Contact;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.TagException;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.SelectableDataModel;

@ManagedBean (name = "myPhoneBook")
@SessionScoped
public class PhoneBook implements Serializable{

    // Attribute
    private List<Contact> phoneBook = new ArrayList<>();

    // Auxiliary Variables
    @Size(max = 50)
    private String firstName;
    @Size(max = 50)
    private String lastName;
    //TODO: Investigate why this condition interferes with the delete method
    //@Size(min = 10, max = 10)
    private String telephone;
    private String address;
    private String email;

    private Contact selectedContact;

    @PostConstruct
    public void init(){
        // Creating default person
        getPhoneBook().add(new Contact("Fulano", "DeTal", "8093230909", "", ""));
        getPhoneBook().add(new Contact("Fulana", "DeTal", "8093230909", "", ""));
        System.out.println("\n\nCreated default contact");

        // Initializing form Auxiliary Variables
        CleanBuffer();
    }

    // Auxiliary Functions
    private void CleanBuffer(){
        firstName = lastName = address = telephone = email = "";

        Collections.sort(phoneBook, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }

    private boolean IsRegistered(){
        for (Contact contact: getPhoneBook()) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName) && contact.getTelephone().equals(telephone)) {
                return true;
            }
        }
        return false;
    }

    // Functions
    public void CreateNewContact(){

        if(!IsRegistered()) {
            getPhoneBook().add(new Contact(firstName, lastName, telephone, email, address));
            System.out.println("New contact added...");
        }
        else
            System.out.println("Contact Already Registered!");

        CleanBuffer();
    }

    public void DeleteContact(String firstName, String lastName, String telephone){

        int count = 0;

        for (Contact contact: getPhoneBook()) {
            if(contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName) && contact.getTelephone().equals(telephone))
                break;

            count++;
        }

        getPhoneBook().remove(count);

        CleanBuffer();
    }

    public void EditContact(){
        for (Contact contact: getPhoneBook()) {
                    if(contact.getFirstName().equals(selectedContact.getFirstName()) && contact.getLastName().equals(selectedContact.getLastName()) && contact.getTelephone().equals(selectedContact.getTelephone())){
                        if(!firstName.equals(""))
                            contact.setFirstName(firstName);
                        if(!lastName.equals(""))
                            contact.setLastName(lastName);
                        if(!telephone.equals(""))
                            contact.setTelephone(telephone);
                        if(!email.equals(""))
                            contact.setEmail(email);
                        if(!address.equals(""))
                            contact.setAddress(address);

                break;
            }
        }

        CleanBuffer();
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

    public Contact getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
    }
}
