package com.example.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diary.mapper.MemberMapper;
import com.example.diary.vo.Member;

@Service 
@Transactional
public class MemberService {
	@Autowired	
	private MemberMapper memberMapper;
		
	public Member login(Member paramMember) {
		
		Member loginMember = memberMapper.login(paramMember);
		return loginMember;
	}
	
	// 회원가입
	public int addMember(Member paramMember) {
		
		int row = memberMapper.insertMember(paramMember);	
		return row;
	}
	
	// 회원탈퇴
    public int removeMember(Member paramMember) {
       
    	int row = memberMapper.deleteMember(paramMember);
        return row;
     }
    
    // 비밀번호 수정
    public int modifyPw(Member parmMember) {
    	int row = memberMapper.updatePw(parmMember);
    	return row;
    }
	
	
}
