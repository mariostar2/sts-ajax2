package com.green.mbti.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.green.mbti.dto.AnswerDto;
import com.green.mbti.dto.QuectionDto;
import com.green.mbti.dto.ResultDto;
import com.green.mbti.value.MbtiType;

@Service
public class MbtiService {
	public List<QuectionDto>  getQuectionList(){
		List<QuectionDto> list = new ArrayList<>();
		list.add(new QuectionDto(1,"사람들과 어울리는게 즐겁다",MbtiType.EI, "E"));
		list.add(new QuectionDto(2,"혼자만의 시간을 보내면서 에너지를 충전하는 편이다.",MbtiType.EI,"I"));
		list.add(new QuectionDto(3,"여러 사람과 대화할 때 에너지를 얻는다.",MbtiType.EI,"E"));
		list.add(new QuectionDto(4,"생각을 충분히 정리한 후 다른 사람에게 이야기하는 편이다.",MbtiType.EI,"I"));
		list.add(new QuectionDto(5,"혼자 있는 시간보다 사람들과 함께하는 시간이 좋다.",MbtiType.EI,"E"));
		
		list.add(new QuectionDto(6,"실제 경험과 구체적인 사실을 중요하게 생각한다.",MbtiType.SN,"S"));
		list.add(new QuectionDto(7,"현실적인 방법보다 새로운 가능성을 상상하는 것을 좋아한다.",MbtiType.SN,"N"));
		list.add(new QuectionDto(8,"일을 할 때 세부적인 내용부터 확인하는 편이다.",MbtiType.SN,"S"));
		list.add(new QuectionDto(9,"하나의 사건에서 숨겨진 의미나 전체적인 흐름을 생각한다.",MbtiType.SN,"N"));
		list.add(new QuectionDto(10,"검증된 방법보다 새로운 방법을 시도하는 것이 흥미롭다.",MbtiType.SN,"N"));
		
		
		list.add(new QuectionDto(11,"결정을 내릴 때 논리와 객관성을 중요하게 생각한다.",MbtiType.TF,"T"));
		list.add(new QuectionDto(12,"다른 사람의 감정을 먼저 고려하는 편이다.",MbtiType.TF,"F"));
		list.add(new QuectionDto(13,"문제를 해결할 때 감정보다 원인과 해결책을 먼저 생각한다.",MbtiType.TF,"T"));
		list.add(new QuectionDto(14,"다른 사람과 의견이 다르면 상대방의 입장을 이해하려고 한다.",MbtiType.TF,"F"));
		list.add(new QuectionDto(15,"공정한 판단을 내리는 것이 개인적인 관계보다 중요하다.",MbtiType.TF,"T"));
		
		
		list.add(new QuectionDto(16,"일을 시작하기 전에 계획을 세우는 편이다.",MbtiType.JP,"J"));
		list.add(new QuectionDto(17,"갑작스러운 일정 변경도 유연하게 받아들이는 편이다.",MbtiType.JP,"P"));
		list.add(new QuectionDto(18,"해야 할 일을 미리 끝내야 마음이 편하다.",MbtiType.JP,"J"));
		list.add(new QuectionDto(19,"계획을 정하기보다 상황에 맞춰 행동하는 것이 좋다.",MbtiType.JP,"P"));
		list.add(new QuectionDto(20,"정해진 일정과 규칙을 지키는 것을 중요하게 생각한다.",MbtiType.JP,"J"));
		
		return list;
		
	}
	
	public ResultDto calculation(AnswerDto dto) {
		int e = 0;
		int iScore = 0;
		
		int s = 0;
		int n = 0;
		
		int t = 0;
		int f = 0;
		
		int j = 0;
		int p = 0;
		
		List<QuectionDto>list = getQuectionList();
		 
		int index = 0;
		
		for(QuectionDto quection :  list) {
			int score = dto.getAnswer().get(index);
			
			//선호점수
			int positiveScore = score;
			//부정점수(반대타입) 
			int negativeScore = 6 - score; 
			//동의?
			String agreeType = quection.getAgreeType();
			if(agreeType.equals("E")) {
				e+= positiveScore;
				iScore += negativeScore;
			}else if(agreeType.equals("I")) {
				iScore+= positiveScore;	
				e+= negativeScore;
			}else if(agreeType.equals("S")) {
				s += positiveScore;
				n += negativeScore;
			}
		    else if(agreeType.equals("N")) {
		        n += positiveScore;
		        s += negativeScore;
		    }
		    else if(agreeType.equals("T")) {
		        t += positiveScore;
		        f += negativeScore;
		    }
		    else if(agreeType.equals("F")) {
		        f += positiveScore;
		        t += negativeScore;
		    }
		    else if(agreeType.equals("J")) {
		        j += positiveScore;
		        p += negativeScore;
		    }
		    else if(agreeType.equals("P")) {
		        p += positiveScore;
		        j += negativeScore;
		    }
			
			index ++;
			
		}
		String mbti = "";
		if(e >=iScore) {
			mbti += "E";
		}else {
			mbti += "I";
		}
		
		if(s>=n){
			mbti += "S";
		}else {
			mbti += "N";
		}
		
		if(t>=f){
			mbti += "T";
		}else {
			mbti += "F";
		}
		if(j>=p){
			mbti += "J";
		}else {
			mbti += "P";
		}
		
		System.out.println("님의 MBTI 는" + mbti + "입니다");
		
		ResultDto result = new ResultDto();
		result.setMbti(mbti);
		
		return result;
		
	}
		

	
}
