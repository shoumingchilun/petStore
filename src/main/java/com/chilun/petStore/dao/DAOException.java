package com.chilun.petStore.dao;

import com.chilun.petStore.Util.Logback;

import java.io.IOException;
import java.util.logging.Level;

public class DAOException extends RuntimeException{
    public DAOException(String msg){
        super(msg);
        try {
            Logback.getlog().log(Level.WARNING,msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}