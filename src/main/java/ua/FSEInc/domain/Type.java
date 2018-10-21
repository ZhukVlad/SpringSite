package ua.FSEInc.domain;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.FSEInc.enums.Gender;

@Entity
@Table(catalog = "site")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode(of = ("id"))
@SelectBeforeUpdate
public class Type {
	
	public Type() {}
	
	public Type(long id, String name, Gender gernder) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender_id")
	private Gender gender;
	
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "type")
	private List<Clothe> clothes;
	
	@Override
	public String toString() {
		return name;
	}

}
