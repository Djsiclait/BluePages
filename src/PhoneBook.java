/**
 * Created by Djidjelly Siclait on 9/10/2016.
 */

import Objects.Contact;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
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
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
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

    // Event Functions
    public void OnContactSelect(SelectEvent event){
        firstName = ((Contact) event.getObject()).getFirstName();
        lastName = ((Contact) event.getObject()).getLastName();
        telephone = ((Contact) event.getObject()).getTelephone();
        address = ((Contact) event.getObject()).getAddress();
        email = ((Contact) event.getObject()).getEmail();
        getPhoneBook().add(new Contact("Moca", "Colmado", "8093230909", "", ""));

        FacesMessage msgs = new FacesMessage("You've Selected ...", lastName + ", " + firstName);
        // TODO: Figure out why this doesn't work
        FacesContext.getCurrentInstance().addMessage(null, msgs);
    }

    // Auxiliary Functions
    private void CleanBuffer(){
        firstName = lastName = address = telephone = email = "";
    }

    // Functions
    public void CreateNewContact(){
        getPhoneBook().add(new Contact(firstName, lastName, telephone, email, address));
        System.out.println("New contact added...");

        CleanBuffer();
    }

    public void DeleteContact(){

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
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setTelephone(telephone);
                contact.setEmail(email);
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
