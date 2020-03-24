package com.chan.spring.service;

import org.springframework.stereotype.Service;

/**
 * PersonService
 *
 * @author Chan
 * @since 2020/3/23
 */
@Service("personServiceScan")
public class PersonService {

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "label='" + label + '\'' +
                '}';
    }
}
