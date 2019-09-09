package com.cdq.blog.model;

public class PersonInfo {
    private Integer personInfoId;

    private User user;

    private Byte secretStatus;

    private Byte sexStatus;

    //身份证号码
    private String idNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(Integer personInfoId) {
        this.personInfoId = personInfoId;
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