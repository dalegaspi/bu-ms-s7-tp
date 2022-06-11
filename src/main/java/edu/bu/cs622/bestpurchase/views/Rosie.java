package edu.bu.cs622.bestpurchase.views;

import edu.bu.cs622.bestpurchase.controllers.app.RosieAppController;

import javax.inject.Inject;

public class Rosie {

    private final RosieAppController appController;

    @Inject
    public Rosie(RosieAppController appController) {
        this.appController = appController;
    }
}
