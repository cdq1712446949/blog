package com.cdq.blog.dto;

import com.cdq.blog.model.Advertisement;
import com.cdq.blog.state.AdvertisementStateEnum;

import java.io.Serializable;
import java.util.List;

public class AdvertisementExecution implements Serializable {

    private int state;
    private String stateInfo;
    private Advertisement advertisement;
    private List<Advertisement> advertisementList;
    private int count;

    public AdvertisementExecution(AdvertisementStateEnum advertisementStateEnum) {
        this.state = advertisementStateEnum.getState();
        this.stateInfo = advertisementStateEnum.getStateInfo();
    }

    public AdvertisementExecution(AdvertisementStateEnum advertisementStateEnum, Advertisement advertisement) {
        this.state = advertisementStateEnum.getState();
        this.stateInfo = advertisementStateEnum.getStateInfo();
        this.advertisement = advertisement;
    }

    public AdvertisementExecution(AdvertisementStateEnum advertisementStateEnum, List<Advertisement> advertisementList) {
        this.state = advertisementStateEnum.getState();
        this.stateInfo = advertisementStateEnum.getStateInfo();
        this.advertisementList = advertisementList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public List<Advertisement> getAdvertisementList() {
        return advertisementList;
    }

    public void setAdvertisementList(List<Advertisement> advertisementList) {
        this.advertisementList = advertisementList;
    }

    public int getCount() {
        return advertisementList.size();
    }

}
