package com.myr.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private String name;
    private String lastName;
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
