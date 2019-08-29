package com.cdq.blog.model;

public class PersonInfo {
    private Integer personInfoId;

    private Integer userId;

    private Byte secretStatus;

    private Byte sexStatus;

    public Integer getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(Integer personInfoId) {
        this.personInfoId = personInfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getSecretStatus() {
        return secretStatus;
    }

    public void setSecretStatus(Byte secretStatus) {
        this.secretStatus = secretStatus;
    }

    public Byte getSexStatus() {
        return sexStatus;
    }

    public void setSexStatus(Byte sexStatus) {
        this.sexStatus = sexStatus;
    }
}