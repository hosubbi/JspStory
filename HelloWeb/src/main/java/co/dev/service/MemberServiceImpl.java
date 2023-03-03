package co.dev.service;

import java.util.List;

import co.dev.deo.MemberDAO;
import co.dev.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	MemberDAO dao = new MemberDAO();
	
	@Override
	public List<MemberVO> getMembers() {
		
		return dao.memberList();
	}

}
