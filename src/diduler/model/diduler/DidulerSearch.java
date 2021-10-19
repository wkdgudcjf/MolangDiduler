package diduler.model.diduler;

import java.util.Date;
import java.util.List;

import diduler.model.SearchType;;
public interface DidulerSearch {
	public abstract Diduler[] search(SearchType t, String content);
	public abstract Diduler[] search(Date date);
}
