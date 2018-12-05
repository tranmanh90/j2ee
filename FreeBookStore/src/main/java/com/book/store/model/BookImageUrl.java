package com.book.store.model;

public class BookImageUrl {
	private String imageId;
	private String imageUrl;

	public BookImageUrl(String imageId, String imageUrl) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
	}

	public BookImageUrl() {
		super();
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookImageUrl [imageId=");
		builder.append(imageId);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append("]");
		return builder.toString();
	}

}
