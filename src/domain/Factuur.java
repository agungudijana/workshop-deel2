package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Factuur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "factuur_id")
	private long id;
	
	@Column(name = "factuurnummer")
	private String factuurNummer;
	
	@Column
	private Date bestelDatum;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy= "id")
	private Set<Betaling> betalingSet;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bestelling_id")
	private Bestelling bestelling;
	
	public Factuur() {
	}

	public long getFactuur_id() {
		return id;
	}
	
	public void setFactuur_id(long id) {
		this.id = id;
	}
	
	public String getFactuurNummer() {
		return factuurNummer;
	}
	
	public void setFactuurNummer(String factuurNummer) {
		this.factuurNummer = factuurNummer;
	}
	
	public Date getBestelDatum() {
		return bestelDatum;
	}

	public void setBestelDatum(Date bestelDatum) {
		this.bestelDatum = bestelDatum;
	}
	
	public Set<Betaling> getBetalingSet() {
		return betalingSet;
	}
	
	public void setBetalingSet(Set<Betaling> betalingSet) {
		this.betalingSet = betalingSet;
	}
	
	public Bestelling getBestelling() {
		return bestelling;
	}
	
	public void setBestelling(Bestelling bestelling) {
		this.bestelling = bestelling;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestelDatum == null) ? 0 : bestelDatum.hashCode());
		result = prime * result + ((bestelling == null) ? 0 : bestelling.hashCode());
		result = prime * result + ((betalingSet == null) ? 0 : betalingSet.hashCode());
		result = prime * result + ((factuurNummer == null) ? 0 : factuurNummer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factuur other = (Factuur) obj;
		if (bestelDatum == null) {
			if (other.bestelDatum != null)
				return false;
		} else if (!bestelDatum.equals(other.bestelDatum))
			return false;
		if (bestelling == null) {
			if (other.bestelling != null)
				return false;
		} else if (!bestelling.equals(other.bestelling))
			return false;
		if (betalingSet == null) {
			if (other.betalingSet != null)
				return false;
		} else if (!betalingSet.equals(other.betalingSet))
			return false;
		if (factuurNummer == null) {
			if (other.factuurNummer != null)
				return false;
		} else if (!factuurNummer.equals(other.factuurNummer))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
