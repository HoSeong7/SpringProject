package com.keduit.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.Criteria;
import com.keduit.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//controller test를 위해
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	private Long[] bnoArr = { 1305602L, 1305601L, 1305600L, 1305599L, 1305598L };

	@Test
	public void testMapper() {
		log.info(mapper);
	}

	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();

			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("댓글 작성자" + i);

			mapper.insert(vo);
		});
		log.info(log);
	}

	@Test
	public void testRead() {
		Long targetRno = 10L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}

	@Test
	public void testDelete() {
		Long targetRno = 7L;
		int result = mapper.delete(targetRno);
		log.info("-------delete------" + result + "개");
	}

	@Test
	public void testUpdate() {

		ReplyVO vo = mapper.read(10L);
		vo.setReply("댓글 수정 테스트입니다.");
		int result = mapper.update(vo);
		log.info("update count =>" + result);
	}

	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		log.info("---------testList----------" + replies);
		log.info(cri.toString());
	}
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 294981L);
		replies.forEach(reply -> log.info(reply));
	}
}
