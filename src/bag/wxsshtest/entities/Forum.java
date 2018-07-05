package bag.wxsshtest.entities;

public class Forum {
	private Integer id;
	private String name;
	private String picture;
	private String date;
	private String opinion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	@Override
	public String toString() {
		return "Forum [id=" + id + ", name=" + name + ", picture=" + picture + ", date=" + date + ", opinion=" + opinion
				+ "]";
	}

}
