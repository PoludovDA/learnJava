package com.company.patternsProject.abstractFactory.webSite;

import com.company.patternsProject.abstractFactory.Developer;

public class WebDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Разрабатывает веб сайт");
    }
}
