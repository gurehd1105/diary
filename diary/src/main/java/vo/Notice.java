package vo;

public class Notice {
	//FK: member.member_id
	private int noticeNo;
	private String memberId;
	private String noticeTitle;
	private String noticeContent;
	private String createdate;
	private String updatedate;
	
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
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memberId=" + memberId + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", createdate=" + createdate + ", updatedate=" + updatedate
				+ "]";
	}
	
	
}
