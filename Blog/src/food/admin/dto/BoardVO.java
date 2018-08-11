package food.admin.dto;

import java.sql.Timestamp;

public class BoardVO {
	private int num;
	private String id;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
	private String fileRoad;
	private String boardkind;

	
	
	public String getBoardkind() {
		return boardkind;
	}
	public void setBoardkind(String boardkind) {
		this.boardkind = boardkind;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public String getFileRoad() {
		return fileRoad;
	}
	public void setFileRoad(String fileRoad) {
		this.fileRoad = fileRoad;
	}
	
	
}
