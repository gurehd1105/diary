package com.example.diary.vo;

import lombok.Data;

@Data
public class Comment {
	//FK: notice_no, member_id;
		//private boolean isSecret;	// true: 비밀글(본인, 관리자)
		private int commentNo;
		private int noticeNo;
		private String memberId;
		private String commentContent;
		private String createdate;
}
