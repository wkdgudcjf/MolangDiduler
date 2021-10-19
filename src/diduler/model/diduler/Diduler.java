package diduler.model.diduler;

import java.util.Calendar;
import java.util.Date;

public abstract class Diduler implements java.io.Serializable{
	private String title;
	private String content;
	private boolean isPublic;
	private Date writtenDate;
	
	public Diduler()
	{
		this("","",true);
	}
	public Diduler(String title, String content)
	{
		this(title, content, true);
	}
	public Diduler(String title, String content, boolean isPublic)
	{
		this.title = title;
		this.content =content;
		this.isPublic = isPublic;
		this.writtenDate = new Date(Calendar.getInstance().get(Calendar.YEAR)-1900, Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DATE));
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
	public boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
}
