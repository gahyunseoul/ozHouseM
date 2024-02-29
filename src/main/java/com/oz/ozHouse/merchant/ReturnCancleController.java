package com.oz.ozHouse.merchant;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oz.ozHouse.dto.ListDTO;
import com.oz.ozHouse.merchant.service.ReturnCancleMapper;

@Controller
public class ReturnCancleController {

	@Autowired
	private ReturnCancleMapper returnCancleMapper;
	
	@RequestMapping(value="/returnCancle_returnList.do", method=RequestMethod.GET)
	public String returnCancelList(@RequestParam Map<String, String> map, HttpServletRequest req) {
		List<ListDTO> list = returnCancleMapper.returnCancleList(map);
		int returnCount = returnCancleMapper.countReturn(map);
		req.setAttribute("searchOptions", settinOption("all"));
		req.setAttribute("radioOptions", settinRadio("all"));
		req.setAttribute("orderReturnList", list);
		req.setAttribute("returnCount", returnCount);
		req.setAttribute("map", map);
		return "merchant/store/returnCancle/returnCancle_returnList";
	}
	//�˻� ����
	@RequestMapping(value="/returnCancle_returnListSearch.do", method=RequestMethod.POST)
	public String returnCancelListSearch(@RequestParam Map<String, String> map, HttpServletRequest req) {
		try {
			char a = map.get("startDate").charAt(0);
			char b = map.get("endDate").charAt(0);
		}catch(StringIndexOutOfBoundsException e) {
			map.put("startDate", null);
			map.put("endDate", null);
		}
		List<ListDTO> list;
		list = returnCancleMapper.searchReturnCancleList(map);
		int returnCount = returnCancleMapper.countSearchReturn(map);
		String searchOptions = settinOption(map.get("search"));
		String radioOptions = settinRadio(map.get("order_refund"));
		req.setAttribute("returnCount", returnCount);
		req.setAttribute("orderReturnList", list);
		req.setAttribute("searchOptions", searchOptions);
		req.setAttribute("radioOptions", radioOptions);
		req.setAttribute("map", map);
		return "merchant/store/returnCancle/returnCancle_returnList";
	}
	//���� ����
	@RequestMapping(value="/returnCancel_check.do")
	public ModelAndView returnCancelCheck(@RequestParam Map<String, String> map) {
		System.out.println("order_orderlike : " + map.get("order_orderlike"));
		int res = returnCancleMapper.returnCancelCheck(map);
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		String msg = null;
		String url = "returnCancle_returnList.do?mer_num=" + map.get("mer_num") + "&order_orderlike=" + map.get("order_orderlike"); //login �����ϸ� ����
		if (res > 0) {
			msg = "Ȯ���� �Ϸ�Ǿ����ϴ�.";
		}else {
			msg = "Ȯ�� �ݿ� �� ������ �߻��Ͽ����ϴ�.";
		}
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	private String settinOption(String search) {
		String options = "";
		if(search.equals("all")) {
			options = "<option value=\"all\" selected='selected'>��ü</option>"
				 	+ "<option value=\"product_name\">id</option>\n"
				 	+ "<option value=\"product_name\">��ǰ��</option>\n"
				 	+ "<option value=\"order_num\">�ֹ���ȣ</option>";
		}else if(search.equals("member_id")) {
			options = "<option value=\"all\">��ü</option>"
				 	+ "<option value=\"member_id\" selected='selected'>id</option>\n"
				 	+ "<option value=\"product_name\">��ǰ��</option>\n"
				 	+ "<option value=\"order_num\">�ֹ���ȣ</option>";
		}else if(search.equals("product_name")) {
			options = "<option value=\"all\">��ü</option>"
				 	+ "<option value=\"member_id\">id</option>\n"
				 	+ "<option value=\"product_name\" selected='selected'>��ǰ��</option>\n"
				 	+ "<option value=\"order_num\">�ֹ���ȣ</option>";
		}else if(search.equals("order_num")) {
			options = "<option value=\"all\">��ü</option>"
				 	+ "<option value=\"member_id\">id</option>\n"
				 	+ "<option value=\"product_name\">��ǰ��</option>\n"
				 	+ "<option value=\"order_num\" selected='selected'>�ֹ���ȣ</option>";
		}
		return options;
	}
	
	private String settinRadio(String order_refund) {
		String options = "";
		if(order_refund.equals("all")) {
			options = "<input type=\"radio\" name=\"order_refund\" value=\"all\" checked=\"checked\">��ü\n" + 
					"<input type=\"radio\" name=\"order_refund\" value=\"t\">�Ϸ�\n" + 
					"<input type=\"radio\" name=\"order_refund\" value=\"f\">�̿Ϸ�";
		}else if(order_refund.equals("t")) {
			options = "<input type=\"radio\" name=\"order_refund\" value=\"all\">��ü\n" + 
					"<input type=\"radio\" name=\"order_refund\" value=\"t\" checked=\"checked\">�Ϸ�\n" + 
					"<input type=\"radio\" name=\"order_refund\" value=\"f\">�̿Ϸ�";
		}else if(order_refund.equals("f")) {
			options = "<input type=\"radio\" name=\"order_refund\" value=\"all\">��ü\n" + 
					"<input type=\"radio\" name=\"order_refund\" value=\"t\">�Ϸ�\n" + 
					"<input type=\"radio\" name=\"order_refund\" value=\"f\" checked=\"checked\">�̿Ϸ�";
		}
		return options;
	}
}
