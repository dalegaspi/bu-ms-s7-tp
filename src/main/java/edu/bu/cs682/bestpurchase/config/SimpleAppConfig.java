package edu.bu.cs682.bestpurchase.config;

import javax.inject.Inject;

public class SimpleAppConfig implements AppConfig {

    @Inject
    public SimpleAppConfig() {

    }

    @Override
    public long getWaitTimeoutMillis() {
        return 1000;
    }

    @Override
    public boolean isDebugMode() {
        return false;
    }
}
