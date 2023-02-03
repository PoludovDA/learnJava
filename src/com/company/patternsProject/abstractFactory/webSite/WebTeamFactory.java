package com.company.patternsProject.abstractFactory.webSite;

import com.company.patternsProject.abstractFactory.Developer;
import com.company.patternsProject.abstractFactory.ProjectManager;
import com.company.patternsProject.abstractFactory.TeamFactory;
import com.company.patternsProject.abstractFactory.Tester;

public class WebTeamFactory implements TeamFactory {
    @Override
    public Developer getDeveloper() {
        return new WebDeveloper();
    }

    @Override
    public Tester getTester() {
        return new WebTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebProjectManager();
    }
}
