package jp.co.internous.lollipop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import jp.co.internous.lollipop.model.domain.dto.PurchaseHistoryDto;
import jp.co.internous.lollipop.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.lollipop.model.session.LoginSession;

@Controller
@RequestMapping("/lollipop/history")
public class PurchaseHistoryController {
	@Autowired 
	private LoginSession loginSession;
	
	@Autowired 
	private TblPurchaseHistoryMapper purchaseHistoryMapper;
	
	///lollipop/history/にアクセスしたときメソッドが呼び出される
	//ログインしたユーザーIDに紐づく購入履歴を表示
	@RequestMapping("/")
	public String index(Model m) {
		//ユーザーIDを取得
		int userId = loginSession.getUserId();
		//purchaseHistoryMapperのfindByUserIdを呼び出してユーザーIDに紐づく履歴情報を取得
		List<PurchaseHistoryDto> historyList = purchaseHistoryMapper.findByUserId(userId);
		
		m.addAttribute("historyList",historyList);
		m.addAttribute("loginSession",loginSession);
		
		return "purchase_history";
	}
	//購入履歴をDBの購入履歴情報Tblから論理削除する
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete() {
		int userId = loginSession.getUserId();
		int result = purchaseHistoryMapper.logicalDeleteByUserId(userId);
		
		return result > 0;
	}
}
