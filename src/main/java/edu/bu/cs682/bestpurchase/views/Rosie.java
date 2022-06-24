package edu.bu.cs682.bestpurchase.views;

import edu.bu.cs682.bestpurchase.controllers.app.RosieAppController;

import javax.inject.Inject;

public class Rosie {

    private final RosieAppController appController;

    @Inject
    public Rosie(RosieAppController appController) {
        this.appController = appController;
    }

    public RosieAppController getAppController() {
        return appController;
    }
}
