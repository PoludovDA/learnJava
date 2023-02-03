package com.company.patternsProject.abstractFactory.webSite;

import com.company.patternsProject.abstractFactory.Tester;

public class WebTester implements Tester {
    @Override
    public void test() {
        System.out.println("Тестер тестирует веб сайт");
    }
}
