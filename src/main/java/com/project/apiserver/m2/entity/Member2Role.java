package com.project.apiserver.m2.entity;

public enum Member2Role {

    ADMIN("USER_ADMIN"), FARMER("USER_FARMER"), CONSUMER("USER_CONSUMER");

    private final String value;


    Member2Role(String value){
        this.value = value;
    }
    public String getValue(){ return this.value;}


}
