package com.company.patternsProject.abstractFactory.banking;

import com.company.patternsProject.abstractFactory.ProjectManager;

public class BankProjectManager implements ProjectManager {

    @Override
    public void controlProcess() {
        System.out.println("ПМ контролирует в банке процесс создания банковского ПО");
    }
}
