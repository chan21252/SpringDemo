package com.chan.spring.controller;

import com.chan.spring.service.PersonService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.inject.Named;

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

    @Inject
    @Named("personService1")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
