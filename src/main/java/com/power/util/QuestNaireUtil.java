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
		qnlist.add(getQusetionNaire(1,"1. 您的性别:","radio","A,B","男,女",list));
		qnlist.add(getQusetionNaire(2,"2. 您的年龄:","radio","A,B,C,D","20岁以下,21-35,36-49,50岁以上",list));
		qnlist.add(getQusetionNaire(3,"3. 您之前是否使用过共享充电宝:","radio","0,1","是,否",list));
		qnlist.add(getQusetionNaire(4,"4. 您不使用的原因是什么（若您使用，请跳过此题）:","checkbox","A,B,C,D","随身携带充电宝,不配充电线，麻烦,归还充电宝不方便,附近没有共享充电宝",list));
		qnlist.add(getQusetionNaire(5,"5. 您经常使用的是哪种共享充电宝:","checkbox","A,B,C,D","来电,街电,云充吧,其他",list));
		qnlist.add(getQusetionNaire(6,"6. 您使用共享充电宝的频率大致是多少:","radio","A,B,C,D","每天,每周1-3次,每月1-3次,其他",list));
		qnlist.add(getQusetionNaire(7,"7. 您总是能在需要时找到身边的共享充电宝吗？","radio","A,B,C,D,E","总是能,一般都能,有时不能,经常不能,总是不能",list));
		qnlist.add(getQusetionNaire(8,"8. 您一般在什么情况下需要共享充电宝:","checkbox","A,B,C,D,E,F","逛街,看电影,咖啡厅,旅游,学校,大街上",list));
		qnlist.add(getQusetionNaire(9,"9. 您在使用共享充电宝故障几率大吗？","radio","A,B,C,D,E","小,较小,一般,较大,大",list));
		qnlist.add(getQusetionNaire(10,"10. 您愿意以何种方式租借充电宝:","radio","A,B,C","按次收费，1元/小时,包月，5元/月,包年，50元/年",list));
		qnlist.add(getQusetionNaire(11,"11. 您对PP充电的改进有什么建议？","text","","",list));
		return qnlist;
	}
	
	public static QuestionNaireEntity getQusetionNaire(int no,String content,String type,String option,String remark,List<QuestionAnswerEntity> list){
		QuestionNaireEntity qn = new QuestionNaireEntity();
		qn.setQuestionNo(no);
		qn.setContent(content);
		qn.setType(type);
		qn.setRemark(remark);
		int annum = 0;
		List<QuestionAnswerEntity> qalist = new ArrayList<>();
		for(String opt:option.split(",")){
			QuestionAnswerEntity questionAnswer = new QuestionAnswerEntity();
			questionAnswer.setAnnum(0);
			questionAnswer.setContent(opt);
			questionAnswer.setQuestionNo(no);
			if(!opt.equals("")){
				qalist.add(questionAnswer);
			}
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
