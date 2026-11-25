package com.green.mbti.dto;

import com.green.mbti.value.MbtiType;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuectionDto {
	private int qno;
	private String quection;
	private MbtiType mbtiType;
	private String  agreeType; //점수 성향
}
