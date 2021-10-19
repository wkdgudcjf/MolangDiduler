package diduler.model.diduler;

public interface DidulerAdd {
	public abstract void add(Diduler diduler);
	public abstract void add(String title, String content);
	public abstract void add(String title, String content, boolean isPublic);
}
