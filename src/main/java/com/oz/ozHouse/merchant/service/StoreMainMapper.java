package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.dto.NoticeDTO;

@Service
public class StoreMainMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	//������ Ȩ ��������
	public List<NoticeDTO> noticeTitleList() {
		return sqlSession.selectList("noticeTitleList");
	}
	
	//��ü count
	public int allCount(Map map) {
		return sqlSession.selectOne("allCount",map);
	}
	
	//���δ�� count
	public int waitCount(Map map) {
		return sqlSession.selectOne("waitCount", map);
	}
	
	//���κ��� count
	public int requestCount(Map map) {
		return sqlSession.selectOne("requestCount", map);
	}
	
	//�����ݷ� count
	public int cancleCount(Map map) {
		return sqlSession.selectOne("cancleCount", map);
	}

	//�Ǹ��� count
	public int saleOk(Map map) {
		return sqlSession.selectOne("saleOk", map);
	}
	
	//������� count
	public int requestCancle(Map map) {
		return sqlSession.selectOne("requestCancle", map);
	}
	
	//��ǰ���� count
	public int productCount(Map map) {
		return sqlSession.selectOne("productCount", map);
	}
	
	//�ֹ����� count
	public int orderCount(Map map) {
		return sqlSession.selectOne("orderCount", map);
	}
	
	//��ȯ count
	public int exchangeCount(Map map) {
		return sqlSession.selectOne("exchangeCount", map);
	}
	
	//ȯ�� count
	public int returnCount(Map map) {
		return sqlSession.selectOne("returnCount", map);
	}
	
	//�߼��غ� count
	public int readyCount(Map map) {
		return sqlSession.selectOne("readyCount", map);
	}
	
	//����� count
	public int deliveryCount(Map map) {
		return sqlSession.selectOne("deliveryCount", map);
	}
	
	//��ۿϷ� count
	public int completeCount(Map map) {
		return sqlSession.selectOne("completeCount", map);
	}
}
