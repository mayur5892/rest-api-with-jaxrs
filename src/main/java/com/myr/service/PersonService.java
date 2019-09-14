package com.myr.service;

import com.myr.db.PersonTable;
import com.myr.model.Person;

import java.util.List;

public class PersonService {


    public List<Person> fetchAllPerson(){
        PersonTable personTable=new PersonTable();
        List<Person> personList = personTable.staticData();
        return  personList;
    }
}
