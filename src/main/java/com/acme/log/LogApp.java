package com.acme.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogApp
{
    private static Logger log = LoggerFactory.getLogger(LogApp.class);
    public static void main( String[] args )
    {
        log.debug("debug log");
        log.info("info log");
        log.warn("log log");
        log.error("error log");
    }
}