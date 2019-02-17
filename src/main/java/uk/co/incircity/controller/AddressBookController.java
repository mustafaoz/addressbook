package uk.co.incircity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.incircity.service.AddressBookService;


@RestController
public class AddressBookController {

    @Autowired
    AddressBookService service;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("/stats")
    public Object getOldestPerson(
              @RequestParam(name="type") String type
            , @RequestParam(name = "sex", required = false) Integer sex
            , @RequestParam(name = "name1", required = false) String name1
            , @RequestParam(name = "name2", required = false) String name2
                                  ) {

        if ("1".equals(type)) {
            return service.getCountOfSex(sex);
        }
        else if ("2".equals(type)) {
            return service.getOldestPerson();
        }
        else if ("3".equals(type)) {
            return service.ageDifferenceBetweenTwoContacts(name1, name2);
        }
        else {
            return "Please choose an option, from 1 to 3.";
        }
    }
}
