package com.power.controller.ex;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.power.util.QuestNaireUtil;
import com.power.entity.ex.QuestionAnswerEntity;
import com.power.entity.ex.QuestionNaireEntity;
import com.power.service.ex.QuestionNaireService;

import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
@RestController
@RequestMapping("questionNaire")
public class QuestionNaireController {
	
	@Autowired
	private QuestionNaireService questionNaireService;
	
	/**
	 * 查询字典
	 */
	@RequestMapping("/{id}")
	public R listbytype(@PathVariable("id") Long id){
		List<QuestionAnswerEntity> list = questionNaireService.queryQuestionAnswerList(id);
		List<QuestionNaireEntity> answerList = QuestNaireUtil.formatQusetionNaire(list);
		return R.ok().put("data", answerList);
	}

	
}
