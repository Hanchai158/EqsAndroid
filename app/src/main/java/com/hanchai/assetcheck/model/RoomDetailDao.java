package com.hanchai.assetcheck.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kogoeru on 4/24/2018.
 */

public class RoomDetailDao {

    @SerializedName("rm_id")
    private String rmId;
    @SerializedName("rm_name")
    private String rmName;
    @SerializedName("rm_no")
    private String rmNo;
    @SerializedName("rm_floor")
    private String rmFloor;
    @SerializedName("rm_capacity")
    private String rmCapacity;
    @SerializedName("rm_area")
    private String rmArea;
    @SerializedName("rm_fmst_id")
    private Object rmFmstId;
    @SerializedName("rm_bd_id")
    private String rmBdId;
    @SerializedName("rm_bdtype_id")
    private String rmBdtypeId;
    @SerializedName("rm_dpid")
    private String rmDpid;

    public String getRmId() {
        return rmId;
    }

    public void setRmId(String rmId) {
        this.rmId = rmId;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmNo() {
        return rmNo;
    }

    public void setRmNo(String rmNo) {
        this.rmNo = rmNo;
    }

    public String getRmFloor() {
        return rmFloor;
    }

    public void setRmFloor(String rmFloor) {
        this.rmFloor = rmFloor;
    }

    public String getRmCapacity() {
        return rmCapacity;
    }

    public void setRmCapacity(String rmCapacity) {
        this.rmCapacity = rmCapacity;
    }

    public String getRmArea() {
        return rmArea;
    }

    public void setRmArea(String rmArea) {
        this.rmArea = rmArea;
    }

    public Object getRmFmstId() {
        return rmFmstId;
    }

    public void setRmFmstId(Object rmFmstId) {
        this.rmFmstId = rmFmstId;
    }

    public String getRmBdId() {
        return rmBdId;
    }

    public void setRmBdId(String rmBdId) {
        this.rmBdId = rmBdId;
    }

    public String getRmBdtypeId() {
        return rmBdtypeId;
    }

    public void setRmBdtypeId(String rmBdtypeId) {
        this.rmBdtypeId = rmBdtypeId;
    }

    public String getRmDpid() {
        return rmDpid;
    }

    public void setRmDpid(String rmDpid) {
        this.rmDpid = rmDpid;
    }

}
