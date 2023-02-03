package com.company.patternsProject.factory;

public class CppDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper() {
        return new SppDeveloper();
    }
}
