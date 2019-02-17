package uk.co.incircity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressBookRepositoryTest {

    @Autowired
    AddressBookRepository repository;

    @Test
    public void testRepo() {

        assertEquals(5, repository.getAddressBookLineList().stream().count());

    }
}
