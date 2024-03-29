package com.keduit.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ReplyPageDTO {

	private int replyCnt;
	private List<ReplyVO> list;
	
}
