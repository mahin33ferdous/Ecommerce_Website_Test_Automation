package utils;

import com.github.javafaker.Faker;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    private String firstName;
    private String lastName;
    private String company;
    private String address;
   
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


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

    public String getCompanyName() {
        return company;
    }

    public void setCompanyName(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getCity() {
        return city;
    }
    

    public void setCity(String city) {
        this.city = city;
    }



    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void generateUserEmail(){
        Faker faker = new Faker();
        setEmail(faker.internet().emailAddress());
    }

    public void generateUserSignUpAddressInfo(){
        Faker faker = new Faker();
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setCompanyName(faker.company().name());
        setAddress(faker.company().name());
        setState(faker.address().state());
        setCity(faker.address().city());
        setZipCode(faker.address().zipCode());
        setPhone(faker.phoneNumber().phoneNumber());
        
        //setPassword("Clown@13");
       
    }
//    public void generateEmployeeAddress(){
//        Faker faker = new Faker();
//        setStreet(faker.address().streetAddress());
//        setCity(faker.address().city());
//        setState(faker.address().state());
//        setZipCode(faker.address().zipCode());
//        setEmail(faker.internet().emailAddress());
//    }




    public static void replaceJsonFile() throws IOException {
        String fileName="./src/test/resources/Users.json";
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("[]");
        fileWriter.flush();
        fileWriter.close();
    }
}


//gradle clean test
//allure generate allure-results --clean -output allure-report
//allure serve allure-results