package com.kh.team.vo;

public class MessageToSendVo {
	private int message_no;
	private String message_descript;

	
	public MessageToSendVo() {
	}

	public MessageToSendVo(int message_no, String message_descript) {
		super();
		this.message_no = message_no;
		this.message_descript = message_descript;
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public String getMessage_descript() {
		return message_descript;
	}

	public void setMessage_descript(String message_descript) {
		this.message_descript = message_descript;
	}

	@Override
	public String toString() {
		return "MessageToSendVo [message_no=" + message_no + ", message_descript=" + message_descript + "]";
	}
	
	
}
