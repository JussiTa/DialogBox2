package fi.isokaju.DialogBox2.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorFormula;




/**
 * @author Jussi
 * 
 */

//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorFormula(name = "tyyppi", length = 15)
@DiscriminatorValue(value = "p308")
//@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", insertable = false, updatable = false)

@Entity
@Table(name = "models")
public class P308 extends Peugeot {

	private String info = " 308 on 3. sukupolven auto 300- sarjasta. Se voitti vuoden auto 2014 tittelin.";

	public P308() {
		
	}

	/**
	 * @param malli
	 */
	public P308(String malli, String moottori, String korimalli) {
		super(malli, moottori, korimalli);
		// TODO Auto-generated constructor stub
	}
	
	@Column(name = "info", unique = true, nullable = false, length=300,insertable = false, updatable = false)
	// virtual function
	@Override
	public String getInfo() {
		String parentinfo = null;
	//	parentinfo = super.getInfo();
		return parentinfo + info;

	}
	@Override
	public void setInfo(String info){
		this.info =info;
		
		
		
		
	}

}
