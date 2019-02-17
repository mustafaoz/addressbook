package uk.co.incircity.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Contact {

    private String name;
    private int sex;
    private LocalDate dateOfBirth;

    public Contact(String contactInput) {

        contactInput= Optional.of(contactInput).orElse(new String(",,01/01/00"));

        String[] inputParamArray = contactInput.split("[,]");

        if (inputParamArray.length == 3) {
            this.name = inputParamArray[0].trim();
            if( "Male".equals(inputParamArray[1].trim()) ) {
                this.sex = ModelConstants.MALE;
            }
            else if ( "Female".equals(inputParamArray[1].trim()) ) {
                this.sex = ModelConstants.FEMALE;
            }

            this.dateOfBirth = LocalDate.parse(inputParamArray[2].trim(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
        }

    }

    public Contact(String name, int sex, LocalDate dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
