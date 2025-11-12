package ie.atu.sw;

import java.time.Year;

public class JournalArticle extends Publication {

	private String journalTitle;
	private int volume;
	private int issue;
	private String pageRange;
	private String doi;

	public JournalArticle(String title, Year year, String journalTitle, int volume, int issue, String pageRange,
			String doi) {
		super(title, year);
		this.journalTitle = journalTitle;
		this.volume = volume;
		this.issue = issue;
		this.pageRange = pageRange;
		this.doi = doi;
	}

	public String citation() {

		return journalTitle + ", " + volume + ", " + "(" + issue + "), pp: " + pageRange + ". doi " + doi;
	}

	public String getJournalTitle() {
		return journalTitle;
	}

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	public String getPageRange() {
		return pageRange;
	}

	public void setPageRange(String pageRange) {
		this.pageRange = pageRange;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

}
