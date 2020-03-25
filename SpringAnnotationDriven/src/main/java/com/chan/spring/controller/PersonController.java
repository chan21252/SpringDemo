package com.chan.spring.controller;

import com.chan.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * PersonController
 *
 * @author Chan
 * @since 2020/3/23
 */
@Controller
public class PersonController {

    private PersonService personService;

    public PersonService getPersonService() {
        return personService;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
