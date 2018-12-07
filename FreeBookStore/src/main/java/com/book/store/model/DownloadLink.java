package com.book.store.model;

public class DownloadLink {
	private String linkId;
	private String linkUrl;

	public DownloadLink(String linkId, String linkUrl) {
		this.linkId = linkId;
		this.linkUrl = linkUrl;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DownloadLink [linkId=");
		builder.append(linkId);
		builder.append(", linkUrl=");
		builder.append(linkUrl);
		builder.append("]");
		return builder.toString();
	}

}
