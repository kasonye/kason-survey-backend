package com.asl.intern.survey.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Survey implements Serializable {
    private Integer questionId;
    private String questionTitle;
    private Integer sequence;
    private Integer enabled;
    private Date createTime;
    private Date updateTime;
    private String value;
    private List<OptionsDTO> options;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<OptionsDTO> getOptions() {
        return options;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setOptions(List<OptionsDTO> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "questionId=" + questionId +
                ", questionTitle='" + questionTitle + '\'' +
                ", sequence=" + sequence +
                ", enabled=" + enabled +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", value='" + value + '\'' +
                ", options=" + options +
                '}';
    }
}
