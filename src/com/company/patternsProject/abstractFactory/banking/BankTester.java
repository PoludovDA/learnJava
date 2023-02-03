package com.company.patternsProject.abstractFactory.banking;

import com.company.patternsProject.abstractFactory.Tester;

public class BankTester implements Tester {
    @Override
    public void test() {
        System.out.println("Тестер тестирует банк");
    }
}
