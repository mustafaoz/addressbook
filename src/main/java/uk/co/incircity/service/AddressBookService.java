package uk.co.incircity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.incircity.model.Contact;
import uk.co.incircity.model.ModelConstants;
import uk.co.incircity.repository.AddressBookRepository;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class AddressBookService {

    @Autowired
    AddressBookRepository repository;

    public AddressBookService() {

    }

    public int getCountOfSex(int type) {
        if (type == ModelConstants.MALE)
            return getCountOfMales();
        else if (type == ModelConstants.FEMALE)
            return getCountOfFemales();
        else
            return 0;
    }

    public Contact getOldestPerson(){
        return repository.getContactList().stream().sorted((o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth())).findFirst().get();
    }

    public int ageDifferenceBetweenTwoContacts(String nameOfFirstContact, String nameOfSecondContact) {
        Contact firstContact = repository.getContactList().stream().filter(o1 -> o1.getName().contains(nameOfFirstContact)).findFirst().orElse(new Contact(",,01/10/1900"));
        Contact secondContact = repository.getContactList().stream().filter(o1 -> o1.getName().contains(nameOfSecondContact)).findFirst().orElse(new Contact(",,01/10/1900"));
        return Long.valueOf( DAYS.between( firstContact.getDateOfBirth(), secondContact.getDateOfBirth() ) ) .intValue();
    }

    private int getCountOfMales() {
        return Long.valueOf(repository.getContactList().stream().filter(next -> next.getSex() == ModelConstants.MALE).count()).intValue();
    }

    private int getCountOfFemales() {
        return Long.valueOf(repository.getContactList().stream().filter(next -> next.getSex() == ModelConstants.FEMALE).count()).intValue();
    }

}
