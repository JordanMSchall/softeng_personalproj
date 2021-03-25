package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Post database table.
 * 
 */
@Entity
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="post_body")
	private String postBody;

	@Column(name="post_created_at")
	private Timestamp postCreatedAt;
	
	@Id
	@Column(name="post_id")
	private int postId;

	private String title;

	public Post() {
	}

	public Post(String title, String body) {
		this.title = title; 
		this.postBody = body;
	}

	public String getPostBody() {
		return this.postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public Timestamp getPostCreatedAt() {
		return this.postCreatedAt;
	}

	public void setPostCreatedAt(Timestamp postCreatedAt) {
		this.postCreatedAt = postCreatedAt;
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}