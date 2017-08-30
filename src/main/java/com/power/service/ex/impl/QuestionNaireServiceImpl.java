package com.power.service.ex.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.power.dao.ex.QuestionNaireDao;
import com.power.entity.ex.QuestionAnswerEntity;
import com.power.service.ex.QuestionNaireService;



@Service("questionNaireService")
public class QuestionNaireServiceImpl implements QuestionNaireService {
	@Autowired
	private QuestionNaireDao questionNaireDao;

	@Override
	public List<QuestionAnswerEntity> queryQuestionAnswerList(Long id) {
		return questionNaireDao.queryQuestionAnswerList(id);
	}
	
	
	
}
