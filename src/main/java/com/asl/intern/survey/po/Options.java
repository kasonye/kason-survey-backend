package com.asl.intern.survey.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "options")
public class Options implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optionId;
    @Column(name = "option_content",length = 50,nullable = false)
    private String optionContent;
    @Column(name = "question_id",nullable = false)
    private Integer questionId;
    @Column(name = "create_time",nullable = false)
    private Date createTime;
    @Column(name = "update_time",nullable = false)
    private Date updateTime;
    @Column(name = "sequence",nullable = false)
    private Integer sequence;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

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

    @Override
    public String toString() {
        return "Options{" +
                "optionId=" + optionId +
                ", optionContent='" + optionContent + '\'' +
                ", questionId=" + questionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sequence=" + sequence +
                '}';
    }
}
