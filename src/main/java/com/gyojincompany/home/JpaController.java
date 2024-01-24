package com.gyojincompany.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.home.entity.Member;
import com.gyojincompany.home.repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JpaController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping("/memberlist")
	public String memberlist(Model model) {
		
		List<Member> members = memberRepository.findAll();
		
		model.addAttribute("memberlist", members);
		
		return "memberlist";
	}
	
	@RequestMapping("/memberjoin")
	public String memberjoin() {
		return "memberjoin";
	}
	
	@RequestMapping("/join")
	public String join(HttpServletRequest request) {
		
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		int mage = Integer.parseInt(request.getParameter("memberage"));
		
		Member member = new Member();
		member.setMemberid(mid);
		member.setMemberpw(mpw);
		member.setMembername(mname);
		member.setMemberage(mage);
		
		memberRepository.save(member);
		
		return "redirect:memberlist";
	}
	

}
