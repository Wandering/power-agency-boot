package com.power.dao.ex;

import java.util.List;

import com.power.entity.ex.QuestionAnswerEntity;

/**
 * 字典查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 11:49:16
 */
public interface QuestionNaireDao {
	List<QuestionAnswerEntity> queryQuestionAnswerList(Long id);
}
