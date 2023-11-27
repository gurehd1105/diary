package vo;

public class Comment {
	//FK: notice_no, member_id;
	//private boolean isSecret;	// true: 비밀글(본인, 관리자)
	private int commentNo;
	private int noticeNo;
	private String memberId;
	private String commentContent;
	private String createdate;
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", noticeNo=" + noticeNo + ", memberId=" + memberId
				+ ", commentContent=" + commentContent + ", createdate=" + createdate + "]";
	}
	
	
}
