package model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

@Entity
@Table(name="coup")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class ModelCoup {

	@ManyToOne
	@JoinColumn(name="COU_ADM_ID")
	private ModelAdmin admin;
}
