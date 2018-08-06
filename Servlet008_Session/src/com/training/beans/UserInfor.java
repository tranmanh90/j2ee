package com.training.beans;

public class UserInfor {
	public String userName;
	private int post;
	private String country;

	public UserInfor() {
		super();
	}

	public UserInfor(String userName, int post, String country) {
		super();
		this.userName = userName;
		this.post = post;
		this.country = country;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the post
	 */
	public int getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(int post) {
		this.post = post;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfor [userName=");
		builder.append(userName);
		builder.append(", post=");
		builder.append(post);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}
}
