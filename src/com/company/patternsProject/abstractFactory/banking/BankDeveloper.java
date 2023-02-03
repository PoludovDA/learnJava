package com.company.patternsProject.abstractFactory.banking;

import com.company.patternsProject.abstractFactory.Developer;

public class BankDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Пишет банковский код");
    }
}
