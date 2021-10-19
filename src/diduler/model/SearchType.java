package diduler.model;

public enum SearchType {
	TITLE("제목"), TITLE_CONTENT("제목+내용");
	private String searchType;
	private SearchType(String searchType)
	{
		this.searchType = searchType;
	}
	public String getSearchType()
	{
		return this.searchType;
	}
	
}
