package com.power.service.ex;

import java.util.List;

import com.power.entity.ex.QuestionAnswerEntity;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
public interface QuestionNaireService {
	
	List<QuestionAnswerEntity> queryQuestionAnswerList(Long id);
}
