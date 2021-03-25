package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-03-23T12:26:04.584-0500")
@StaticMetamodel(Post.class)
public class Post_ {
	public static volatile SingularAttribute<Post, String> postBody;
	public static volatile SingularAttribute<Post, Timestamp> postCreatedAt;
	public static volatile SingularAttribute<Post, Integer> postId;
	public static volatile SingularAttribute<Post, String> title;
}
