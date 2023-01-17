package com.keduit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keduit.domain.Criteria;
import com.keduit.domain.ReplyPageDTO;
import com.keduit.domain.ReplyVO;
import com.keduit.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("------getList with page(service)------" + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("------read(service)------" + rno);
		return mapper.read(rno);
	}

	@Override
	public int register(ReplyVO vo) {
		log.info("------insert(service)------"+ vo);
		return mapper.insert(vo);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("------modify(service)------" + vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("------deleteservice)------" + rno);
		return mapper.delete(rno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		log.info("------ get List Page Reply ----- " + bno);
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}

}
