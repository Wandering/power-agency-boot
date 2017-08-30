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
public class QuestionAnswerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//问题编号
	private Integer questionNo;
	//问题内容
	private String content;
	//回答次数
	private Integer annum;
	public Integer getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAnnum() {
		return annum;
	}
	public void setAnnum(Integer annum) {
		this.annum = annum;
	}
	
	
}
