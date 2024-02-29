package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.dto.Product_QA_DTO;
import com.oz.ozHouse.dto.Product_reQA_DTO;
import com.oz.ozHouse.dto.Order_QADTO;
import com.oz.ozHouse.dto.Order_reQADTO;
import com.oz.ozHouse.dto.ReviewDTO;;

@Service
public class BoardMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	//�ֹ� ����
	public List<Order_QADTO> orderQAList(Map<String, String> map) {
		return sqlSession.selectList("orderQAList", map);
	}
	//��ǰ ����
	public List<Product_QA_DTO> productQAList(Map<String, String> map) {
		return sqlSession.selectList("productQAList", map);
	}
	//���� �ı�
	public List<ReviewDTO> reviewList(Map<String, String> map) {
		return sqlSession.selectList("reviewList", map);
	}
	//���� �ı� �󼼺���
	public List<ReviewDTO> reviewContent(int review_num) {
		return sqlSession.selectList("reviewContent", review_num);
	}
	//��ǰ ���� �󼼺���
	public List<Product_QA_DTO> productContent(int product_QA_num) {
		return sqlSession.selectList("productContent", product_QA_num);
	}
	//�ֹ� ���� �󼼺���
	public List<Order_QADTO> orderContent(int order_QA_num) {
		return sqlSession.selectList("orderContent", order_QA_num);
	}
	//��ǰ ���� �亯�ϱ�
	public int productReQa(Map<String, Object> map) {
		return sqlSession.insert("productReQa", map);
	}
	//��ǰ ���� �亯 �󼼺���
	public List<Product_reQA_DTO> productReContent(int product_reQA_num) {
		return sqlSession.selectList("productReContent", product_reQA_num);
	}
	//��ǰ ���� �亯�����ϱ�
	public int productReQaUpdate(Product_reQA_DTO dto) {
		return sqlSession.update("productReQaUpdate", dto);
	}
	//��ǰ ���� ���� �����ϱ�
	public int productQAstate(int product_QA_num) {
		return sqlSession.update("productQAstate", product_QA_num);
	}
	//�ֹ� ���� �亯�ϱ�
	public int orderReQa(Map<String, Object> map) {
		return sqlSession.insert("orderReQa", map);
	}
	//�ֹ� ���� �亯 �󼼺���
	public List<Order_reQADTO> orderReContent(int order_reQA_num) {
		return sqlSession.selectList("orderReContent", order_reQA_num);
	}
	//�ֹ� ���� �亯�����ϱ�
	public int orderReQaUpdate(Order_reQADTO dto) {
		return sqlSession.update("orderReQaUpdate", dto);
	}
	//�ֹ� ���� ���� �����ϱ�
	public int orderQAstate(int order_QA_num) {
		return sqlSession.update("orderQAstate", order_QA_num);
	}
	
	public int productqaCount(Map<String, String> map) {
	    return sqlSession.selectOne("productqaCount", map);
	}
	
	public int orderqaCount(Map<String, String> map) {
	    return sqlSession.selectOne("orderqaCount", map);
	}

	public int reviewqaCount(Map<String, String> map) {
	    return sqlSession.selectOne("reviewqaCount", map);
	}
}
