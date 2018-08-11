package food.board.dto;

import java.sql.Timestamp;

public class foodVO {


	   private int num;
	   private String id;
	   private String pass;
	   private String name;
	   private String email;
	   private String title;
	   private String content;
	   private int readcount;
	   private Timestamp writedate;
	   private String fileRoad;
	   private String image;
	   private int boardkind;
	   public int getNum() {
	      return num;
	   }
	   
	  public String getId() {
		return id;
	}
	  
	public int getBoardkind() {
		return boardkind;
	}

	public void setBoardkind(int boardkind) {
		this.boardkind = boardkind;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNum(int num) {
	      this.num = num;
	   }
	   public String getPass() {
	      return pass;
	   }
	   public void setPass(String pass) {
	      this.pass = pass;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getEmail() {
	      return email;
	   }
	   public void setEmail(String email) {
	      this.email = email;
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
	   public void setImage(String image) {
		      this.image = image;
		   }
	   
	}

