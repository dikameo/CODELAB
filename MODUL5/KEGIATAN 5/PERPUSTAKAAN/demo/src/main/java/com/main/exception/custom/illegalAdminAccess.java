package com.main.exception.custom;

public class illegalAdminAccess extends Exception{
    public illegalAdminAccess(String massage){
        super(massage);
    }
    illegalAdminAccess(String massage, Throwable cause){
        super(massage, cause);
    }
}
