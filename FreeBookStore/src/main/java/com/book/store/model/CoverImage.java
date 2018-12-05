package com.book.store.model;

public class CoverImage {
	private String imageId;
	private String imageUrl;
	private String imagePath;
	private String imageName;

	public CoverImage(String imageId, String imageUrl, String imagePath, String imageName) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.imagePath = imagePath;
		this.imageName = imageName;
	}

	public CoverImage() {
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoverImage [imageId=");
		builder.append(imageId);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append(", imageName=");
		builder.append(imageName);
		builder.append("]");
		return builder.toString();
	}

}
