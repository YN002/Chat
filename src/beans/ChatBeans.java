package beans;

public class ChatBeans {
	private int id;
	private String userName;
	private String comment;
	private String date;
	private String icon;

	public ChatBeans() {}

	public ChatBeans(int id, String userName, String comment, String date, String icon) {
		super();
		this.userName = userName;
		this.comment = comment;
		this.date = date;
		this.icon = icon;
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}



}
