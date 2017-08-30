package com.power.util;

import com.power.entity.ex.QuestionAnswerEntity;
import com.power.entity.ex.QuestionNaireEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/8/29.
 * 问卷工具类
 */
public class QuestNaireUtil {
	
	public static List<QuestionNaireEntity> formatQusetionNaire(List<QuestionAnswerEntity> list){
		List<QuestionNaireEntity> qnlist = new ArrayList<>();
		qnlist.add(getQusetionNaire(1,"radio","A,B",list));
		qnlist.add(getQusetionNaire(2,"radio","A,B,C,D",list));
		qnlist.add(getQusetionNaire(3,"radio","0,1",list));
		qnlist.add(getQusetionNaire(4,"checkbox","A,B,C,D",list));
		qnlist.add(getQusetionNaire(5,"checkbox","A,B,C,D",list));
		qnlist.add(getQusetionNaire(6,"radio","A,B,C,D",list));
		qnlist.add(getQusetionNaire(7,"radio","A,B,C,D,E",list));
		qnlist.add(getQusetionNaire(8,"checkbox","A,B,C,D,E,F",list));
		qnlist.add(getQusetionNaire(9,"radio","A,B,C,D,E",list));
		qnlist.add(getQusetionNaire(10,"radio","A,B,C",list));
		qnlist.add(getQusetionNaire(11,"text","",list));
		return qnlist;
	}
	
	public static QuestionNaireEntity getQusetionNaire(int no,String type,String option,List<QuestionAnswerEntity> list){
		QuestionNaireEntity qn = new QuestionNaireEntity();
		qn.setQuestionNo(no);
		qn.setType(type);
		int annum = 0;
		List<QuestionAnswerEntity> qalist = new ArrayList<>();
		for(String opt:option.split(",")){
			QuestionAnswerEntity questionAnswer = new QuestionAnswerEntity();
			questionAnswer.setAnnum(0);
			questionAnswer.setContent(opt);
			questionAnswer.setQuestionNo(no);
			qalist.add(questionAnswer);
		}
		int optnum = 0;
		for(int i=0;i<list.size();i++){
			QuestionAnswerEntity qa = list.get(i);
			switch(type){
				case "radio":
					if(qa.getQuestionNo()==no&&qalist.get(optnum).getContent().equals(qa.getContent())){
						qalist.get(optnum).setAnnum(qa.getAnnum());
						annum += qa.getAnnum();
						optnum++;
					}
				break;
				case "checkbox":
					if(qa.getQuestionNo()==no){
						String str = qa.getContent();
						for(String k : str.substring(1,str.length()-1).split(",")){
							for(int j=0;j<qalist.size();j++){
								if(k.indexOf(qalist.get(j).getContent())!=-1){
									qalist.get(j).setAnnum(qalist.get(j).getAnnum()+1*qa.getAnnum());
								}
							}
						}
						annum += qa.getAnnum();
					}
				break;
				default:
					if(qa.getQuestionNo()==no){
						qalist.add(qa);
						annum += qa.getAnnum();
					}
			}
		}
		qn.setEffectNum(annum);
		qn.setAnswers(qalist);
		return qn;
	}

}
