package dao;

import java.util.*;

import vo.Comment;

public class CommentDao {
	public int insertComment(Comment comment) {
		return 0;	
	}
	
	// 글쓴이 or member_level > 0
	public int deleteComment(Comment comment) {
		return 0;
		
	}
	// 글쓴이만
	public int updateComment(Comment comment) {
		return 0;		
	}
	
	// 비밀글: 본인 or member_level > 0, 본인/관리자가 아닌경우 -> view에서 비밀글입니다
	// 공개글: 
	public List<Comment> selectCommentList(Map<String, Object>paramMap){
		return null;
	
	}
}
