package com.company.patternsProject.abstractFactory.banking;

import com.company.patternsProject.abstractFactory.Developer;
import com.company.patternsProject.abstractFactory.TeamFactory;
import com.company.patternsProject.abstractFactory.ProjectManager;
import com.company.patternsProject.abstractFactory.Tester;

public class BankTeamFactory implements TeamFactory {
    @Override
    public Developer getDeveloper() {
        return new BankDeveloper();
    }

    @Override
    public Tester getTester() {
        return new BankTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankProjectManager();
    }
}
