package dmacc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hand {
	@Id
	@GeneratedValue
	private int id;
	String hand = "";

}
