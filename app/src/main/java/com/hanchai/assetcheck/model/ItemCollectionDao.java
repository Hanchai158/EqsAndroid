package com.hanchai.assetcheck.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hanchai on 21-Apr-18.
 */
public class ItemCollectionDao {


    @SerializedName("eqs_id")
    @Expose
    private String eqsId;
    @SerializedName("eqs_unit")
    @Expose
    private String eqsUnit;
    @SerializedName("eqs_amount")
    @Expose
    private String eqsAmount;
    @SerializedName("eqs_name")
    @Expose
    private String eqsName;
    @SerializedName("eqs_fmst_id")
    @Expose
    private String eqsFmstId;
    @SerializedName("eqs_fmnd_id")
    @Expose
    private String eqsFmndId;
    @SerializedName("eqs_fmrd_id")
    @Expose
    private String eqsFmrdId;
    @SerializedName("eqs_code_old")
    @Expose
    private String eqsCodeOld;
    @SerializedName("eqs_bd_id")
    @Expose
    private String eqsBdId;
    @SerializedName("eqs_rm_id")
    @Expose
    private String eqsRmId;
    @SerializedName("eqs_status")
    @Expose
    private String eqsStatus;
    @SerializedName("eqs_detail")
    @Expose
    private String eqsDetail;
    @SerializedName("eqs_active")
    @Expose
    private String eqsActive;
    @SerializedName("fmst_id")
    @Expose
    private String fmstId;
    @SerializedName("fmst_name")
    @Expose
    private String fmstName;
    @SerializedName("fmst_abbr")
    @Expose
    private String fmstAbbr;
    @SerializedName("fmst_year")
    @Expose
    private String fmstYear;

    public String getEqsId() {
        return eqsId;
    }

    public void setEqsId(String eqsId) {
        this.eqsId = eqsId;
    }

    public String getEqsUnit() {
        return eqsUnit;
    }

    public void setEqsUnit(String eqsUnit) {
        this.eqsUnit = eqsUnit;
    }

    public String getEqsAmount() {
        return eqsAmount;
    }

    public void setEqsAmount(String eqsAmount) {
        this.eqsAmount = eqsAmount;
    }

    public String getEqsName() {
        return eqsName;
    }

    public void setEqsName(String eqsName) {
        this.eqsName = eqsName;
    }

    public String getEqsFmstId() {
        return eqsFmstId;
    }

    public void setEqsFmstId(String eqsFmstId) {
        this.eqsFmstId = eqsFmstId;
    }

    public String getEqsFmndId() {
        return eqsFmndId;
    }

    public void setEqsFmndId(String eqsFmndId) {
        this.eqsFmndId = eqsFmndId;
    }

    public String getEqsFmrdId() {
        return eqsFmrdId;
    }

    public void setEqsFmrdId(String eqsFmrdId) {
        this.eqsFmrdId = eqsFmrdId;
    }

    public String getEqsCodeOld() {
        return eqsCodeOld;
    }

    public void setEqsCodeOld(String eqsCodeOld) {
        this.eqsCodeOld = eqsCodeOld;
    }

    public String getEqsBdId() {
        return eqsBdId;
    }

    public void setEqsBdId(String eqsBdId) {
        this.eqsBdId = eqsBdId;
    }

    public String getEqsRmId() {
        return eqsRmId;
    }

    public void setEqsRmId(String eqsRmId) {
        this.eqsRmId = eqsRmId;
    }

    public String getEqsStatus() {
        return eqsStatus;
    }

    public void setEqsStatus(String eqsStatus) {
        this.eqsStatus = eqsStatus;
    }

    public String getEqsDetail() {
        return eqsDetail;
    }

    public void setEqsDetail(String eqsDetail) {
        this.eqsDetail = eqsDetail;
    }

    public String getEqsActive() {
        return eqsActive;
    }

    public void setEqsActive(String eqsActive) {
        this.eqsActive = eqsActive;
    }

    public String getFmstId() {
        return fmstId;
    }

    public void setFmstId(String fmstId) {
        this.fmstId = fmstId;
    }

    public String getFmstName() {
        return fmstName;
    }

    public void setFmstName(String fmstName) {
        this.fmstName = fmstName;
    }

    public String getFmstAbbr() {
        return fmstAbbr;
    }

    public void setFmstAbbr(String fmstAbbr) {
        this.fmstAbbr = fmstAbbr;
    }

    public String getFmstYear() {
        return fmstYear;
    }

    public void setFmstYear(String fmstYear) {
        this.fmstYear = fmstYear;
    }
}