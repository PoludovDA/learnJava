package com.company.patternsProject.abstractFactory;

public interface TeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}
