package com.company.patternsProject.abstractFactory.webSite;

import com.company.patternsProject.abstractFactory.ProjectManager;

public class WebProjectManager implements ProjectManager {
    @Override
    public void controlProcess() {
        System.out.println("ПМ контролирует разрабатываемый веб сайт");
    }
}
