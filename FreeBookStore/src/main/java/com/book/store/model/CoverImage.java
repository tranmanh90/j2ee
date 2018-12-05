package com.book.store.model;

public class CoverImage {
	private String imageId;
	private String imageUrlId;
	private String imagePath;
	private String imageName;
	private String imageFormat;

	public CoverImage() {
		super();
	}

	public CoverImage(String imageId, String imageUrlId, String imagePath, String imageName, String imageFormat) {
		super();
		this.imageId = imageId;
		this.imageUrlId = imageUrlId;
		this.imagePath = imagePath;
		this.imageName = imageName;
		this.imageFormat = imageFormat;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageUrlId() {
		return imageUrlId;
	}

	public void setImageUrlId(String imageUrlId) {
		this.imageUrlId = imageUrlId;
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

	public String getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoverImage [imageId=");
		builder.append(imageId);
		builder.append(", imageUrlId=");
		builder.append(imageUrlId);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append(", imageName=");
		builder.append(imageName);
		builder.append(", imageFormat=");
		builder.append(imageFormat);
		builder.append("]");
		return builder.toString();
	}

}
