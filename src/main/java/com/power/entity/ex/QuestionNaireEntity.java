package com.power.entity.ex;

import java.io.Serializable;
import java.util.List;



/**
 * 字典管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:31:08
 */
public class QuestionNaireEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//问题编号
	private Integer questionNo;
	//问题类型
	private String type;
	//问题内容
	private String content;
	//回答列表
	private List<QuestionAnswerEntity> answers;
	//有效回答次数
	private Integer effectNum;
	//备注
	private String remark;
	public Integer getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<QuestionAnswerEntity> getAnswers() {
		return answers;
	}
	public void setAnswers(List<QuestionAnswerEntity> answers) {
		this.answers = answers;
	}
	public Integer getEffectNum() {
		return effectNum;
	}
	public void setEffectNum(Integer effectNum) {
		this.effectNum = effectNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
