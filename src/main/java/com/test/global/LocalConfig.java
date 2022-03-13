package com.test.global;

import com.avis.utils.dataUtils.PropertyUtils;

public class LocalConfig {

    public static final String AGE_PREDICTOR_URL;
    public static final String SPACEX;

    static {
        try {
            PropertyUtils.getInstance().loadProperties("config.properties");
            AGE_PREDICTOR_URL = System.getProperty("AGE_PREDICTOR_URL",PropertyUtils.getInstance().getValue("AGE_PREDICTOR_URL"));
            SPACEX=System.getProperty("SPACEX",PropertyUtils.getInstance().getValue("SPACEX"));
        } catch (Throwable t) {
            t.printStackTrace();
            throw new RuntimeException("Something wrong !!! Check configurations.", t);
        }
    }
}
