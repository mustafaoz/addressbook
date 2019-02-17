package uk.co.incircity.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressBookRepository {

    private final List<String> addressBookLineList;

    public AddressBookRepository() {

        addressBookLineList = new ArrayList<>();
        try {
            InputStream in 			    = getClass().getClassLoader().getResourceAsStream ("AddressBook" );
            InputStreamReader insReader = new InputStreamReader ( in, "UTF-8" );
            BufferedReader bufReader 	= new BufferedReader	( insReader	  );

            for (String line; (line = bufReader.readLine()) != null;) {
                addressBookLineList.add(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<String> getAddressBookLineList() {
        return addressBookLineList;
    }
}
