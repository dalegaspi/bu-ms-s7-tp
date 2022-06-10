package edu.bu.cs622.bestpurchase;

import edu.bu.cs622.bestpurchase.controllers.RosieAppController;

import javax.inject.Inject;

public class Rosie {

    private final RosieAppController appController;

    @Inject
    public Rosie(RosieAppController appController) {
        this.appController = appController;
    }
}
