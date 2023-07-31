package com.project.apiserver.member.entity;

public enum MemberRole {
    ADMIN("USER_ADMIN"), FARMER("USER_FARMER"), CONSUMER("USER_CONSUMER");

    private final String value;


    MemberRole(String value){
        this.value = value;
    }
    public String getValue(){ return this.value;}


}
