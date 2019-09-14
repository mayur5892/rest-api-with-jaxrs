package com.myr.db;

import com.myr.model.Address;
import com.myr.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonTable {

    public List<Person> staticData(){
        List<Person> personList=new ArrayList<>();
        Address address = prepareAddress("Pune",411028);

        Person p1 = preparePerson("mayur","pandey",address);
        Person p2= preparePerson("kunal","pandey",address);

        personList.add(p1);
        personList.add(p2);
        return personList;
    }

    private Person preparePerson(String name,String lastName,Address address) {
        Person p=new Person();
        p.setName(name);
        p.setLastName(lastName);
        p.setAddress(address);
        return p;
    }

    private Address prepareAddress(String city, int pincode) {
        Address address=new Address();
        address.setCity(city);
        address.setPincode(pincode);
        return address;
    }
}
