package diduler.model;

public enum SearchType {
	TITLE("力格"), TITLE_CONTENT("力格+郴侩");
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
