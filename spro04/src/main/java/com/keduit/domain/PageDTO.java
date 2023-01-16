package com.keduit.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private int StartPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private Criteria cri;

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.StartPage = this.endPage - 9;
		int realPage = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realPage < this.endPage)
			this.endPage = realPage;

		this.prev = this.StartPage > 1;
		this.next = this.endPage < realPage;
	}
}
