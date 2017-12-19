package com.cuiniaohelp;


import com.cuiniaohelp.model.Company;

/**
 * Created: 2017-09-10 20:47:40
 *
 * @author Michael.Zhang
 */
public class Application {

    public static void main(String[] args) {
        Company company = new Company();
        company.setName("michael");
        company.setId(2L);
        System.out.println(company);
    }

}
