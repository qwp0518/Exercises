package com.example.visualization.pojo;

import javax.validation.constraints.NotBlank;

/**
 * @author William Tsien
 */
public class RequestLabels {

    @NotBlank(message = "custNo不能为空")
    private String custNo;

    @NotBlank(message = "startDay不能为空")
    private String startDay;

    @NotBlank(message = "endDay不能为空")
    private String endDay;

    public Integer pageSize;
    public Integer pageNum;
    public String acctNo = "12";

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    @Override
    public String toString() {
        return "RequestLabels{" +
                "custNo='" + custNo + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", acctNo='" + acctNo + '\'' +
                '}';
    }
}
