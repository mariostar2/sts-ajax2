package com.green.mbti.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.green.mbti.dto.AnswerDto;
import com.green.mbti.dto.QuectionDto;
import com.green.mbti.dto.ResultDto;
import com.green.mbti.service.MbtiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin( origins  = {
		 "http://localhost:8090",
		 "http://192.168.0.3:8090",
		 "http://192.168.0.80:8090"
})
public class MbtiController {


	private final MbtiService mbtiService;
	
	//질문리스트 
	@RequestMapping("/quection")
	public List<QuectionDto> index(){
		return mbtiService.getQuectionList();
	}
	
	//점수계산
	@RequestMapping("/calculation")
	public ResultDto calculation(@RequestBody AnswerDto dto) {
		return mbtiService.calculation(dto);
	}
	
	
	
	
}

