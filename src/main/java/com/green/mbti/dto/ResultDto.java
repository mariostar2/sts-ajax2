package com.green.mbti.dto;

import com.green.mbti.value.MptiListType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
	private String mbti;
	private String desc; //질문 
	private MptiListType mptiListType;
}
