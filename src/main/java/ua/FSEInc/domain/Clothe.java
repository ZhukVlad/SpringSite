package ua.FSEInc.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.enums.Size;


@Entity
@Table(catalog = "site")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode(of = ("id"))
@SelectBeforeUpdate
public class Clothe {
	
	public Clothe() {}


	public Clothe(Long id, String name, Gender gender, Type type, Size size, BigDecimal price, String color,
			String material, byte[] image, String descr, int avgRating, long totalRating, long totalVoteCount,
			long viewCount) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.type = type;
		this.size = size;
		this.price = price;
		this.color = color;
		this.material = material;
		this.image = image;
		this.descr = descr;
		this.avgRating = avgRating;
		this.totalRating = totalRating;
		this.totalVoteCount = totalVoteCount;
		this.viewCount = viewCount;
	}


	public Clothe(Long id, byte[] image) {
		this.id = id;
		this.image = image;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender_id")
	private Gender gender;
	
	@ManyToOne
	@JoinColumn
	private Type type;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "size_id")
	private Size size; 
	
	private BigDecimal price;
	
	private String color; 
	
	private String material;
	
	private byte[] image;
	
	private String descr;
	
	@Column(name = "avg_rating")
	private int avgRating;
	
	@Column(name = "total_rating")
	private long totalRating;
	
	@Column(name = "total_vote_count")
	private long totalVoteCount;
	
	@Column(name = "view_count")
	private long viewCount;
	
	@Override
	public String toString() {
		return name;
	}
}
