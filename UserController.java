package jp.co.internous.lollipop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.lollipop.model.domain.MstUser;
import jp.co.internous.lollipop.model.form.UserForm;
import jp.co.internous.lollipop.model.mapper.MstUserMapper;
import jp.co.internous.lollipop.model.session.LoginSession;

@Controller
@RequestMapping("/lollipop/user")
public class UserController {
	@Autowired
	private MstUserMapper userMapper;
	@Autowired
	private LoginSession loginSession;
	
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		
		return "register_user";
	}
	//重複確認をする
	@RequestMapping("/duplicatedUserName")
	@ResponseBody
	public boolean duplicatedUserName(@RequestParam String userName){
		int count = userMapper.findCountByUserName(userName);
		return count > 0;
	}
	//mst_userにUserFormから得たユーザ情報を登録する
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int count = userMapper.insert(user);
		
		return count > 0;
	}
}
