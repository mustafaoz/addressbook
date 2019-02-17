package uk.co.incircity.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.incircity.model.Contact;
import uk.co.incircity.model.ModelConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressBookServiceTest {

    @Autowired
    AddressBookService service;

    @Test
    public void isCountOfMales_5() {
        assertEquals (3, service.getCountOfSex(ModelConstants.MALE));
    }

    @Test
    public void whoIsTheOldestPerson() {
        System.out.println("Oldest person is: " + service.getOldestPerson().toString());
        assertEquals( new Contact("Wes Jackson, Male, 14/08/1974"), service.getOldestPerson() );
    }

    @Test
    public void ageDifferenceBetweenBillAndPaul() {
        System.out.println("Age Diff: " + service.ageDifferenceBetweenTwoContacts("Bill", "Paul"));
        assertEquals(2862, service.ageDifferenceBetweenTwoContacts("Bill", "Paul"));
    }


}
