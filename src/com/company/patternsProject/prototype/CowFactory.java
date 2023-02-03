package com.company.patternsProject.prototype;

public class CowFactory {
    private Cow cow;

    public CowFactory(Cow cow) {
        this.cow = cow;
    }

    public Cow createCloneCow() {
        return (Cow) cow.copy();
    }
}
