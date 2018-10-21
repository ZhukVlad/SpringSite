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
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@EqualsAndHashCode(of = ("id"))
@SelectBeforeUpdate
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String value;
	
	@Column(name="clothe_id")
	private long clotheId;
	
	private String username;
}
