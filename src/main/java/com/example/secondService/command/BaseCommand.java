package com.example.secondService.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseCommand<R> {
     protected   final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected boolean canExecute() throws Exception {
        return true;
    }

    public R execute() throws Exception {
        return null;
    }
}
