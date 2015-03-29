package fi.isokaju.DialogBox2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity

//@Table(name = "models")
//@MappedSuperclass
public abstract class Peugeot {
	private String malli;
	private String moottori;
	private String korityyppi;
	private Long id;

	public Peugeot(String malli, String moottori, String korityyppi) {
		this.malli = malli;
		this.setMoottori(moottori);
		this.setKorityyppi(korityyppi);

	}

	public Peugeot() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(long id){
		this.id=id;
		
		
		
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	@Column(name = "moottori")
	public String getMoottori() {
		return moottori;
	}

	public void setMoottori(String moottori) {
		this.moottori = moottori;
	}

	public String getKorityyppi() {
		return korityyppi;
	}

	@Column(name = "korityyppi")
	public void setKorityyppi(String korityyppi) {
		this.korityyppi = korityyppi;
	}
	
	public String getInfo() {
		return "Peugeot";

	}
	
	public void setInfo(String info){
		
		
	}

	// @Override
	public String toString() {
		return this.malli + " " + this.moottori + " " + this.korityyppi;

	}

}
