package com.asl.intern.survey.dto;

import java.io.Serializable;
import java.util.Date;

public class OptionsDTO implements Serializable {
    private Integer optionId;
    private String optionContent;
    private Integer questionId;
    private Date createTime;
    private Date updateTime;
    private Integer sequence;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "OptionDTO{" +
                "optionId=" + optionId +
                ", optionContent='" + optionContent + '\'' +
                ", questionId=" + questionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sequence=" + sequence +
                '}';
    }
}
