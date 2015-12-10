package com.taobao.diamond.client;

import org.apache.commons.lang.StringUtils;

/**
 * Created by diwayou on 2015/12/10.
 */
public class DiamondConfigureUtil {

    public static final String DIAMOND_CONFIG_SERVER_ADDRESS = "DIAMOND_CONFIG_SERVER_ADDRESS";

    public static final String DIAMOND_CONFIG_SERVER_PORT = "DIAMOND_CONFIG_SERVER_PORT";

    public static final String DIAMOND_POLL_TIME_INTERVAL = "DIAMOND_POLL_TIME_INTERVAL";

    public static DiamondConfigure getFromEnv() {
        DiamondConfigure diamondConfigure = new DiamondConfigure();

        String configServerAddress = System.getenv(DIAMOND_CONFIG_SERVER_ADDRESS);
        if (StringUtils.isNotBlank(configServerAddress)) {
            diamondConfigure.setConfigServerAddress(configServerAddress);
        }

        String configServerPort = System.getenv(DIAMOND_CONFIG_SERVER_PORT);
        if (StringUtils.isNumeric(configServerPort)) {
            diamondConfigure.setConfigServerPort(Integer.parseInt(configServerPort));
        } else if (configServerPort != null) {
            throw new RuntimeException("Env " + DIAMOND_CONFIG_SERVER_PORT + " format error: " + configServerPort);
        }

        String pollTimeInterval = System.getenv(DIAMOND_POLL_TIME_INTERVAL);
        if (StringUtils.isNumeric(pollTimeInterval)) {
            diamondConfigure.setPollingIntervalTime(Integer.parseInt(pollTimeInterval));
        } else if (pollTimeInterval != null) {
            throw new RuntimeException("Env " + DIAMOND_POLL_TIME_INTERVAL + " format error: " + pollTimeInterval);
        }

        return diamondConfigure;
    }
}
