package diduler.model;

public enum SearchType {
	TITLE("����"), TITLE_CONTENT("����+����");
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
