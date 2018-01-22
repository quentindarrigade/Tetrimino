package dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.ModelAdmin;

public interface IAdminDAO extends JpaRepository< ModelAdmin, Integer> {
	
	
	
	@Query("select a from ModelAdmin a where a.login=:reference1 and a.password =:reference2")
	public ModelAdmin auth(@Param("reference1") String ref1,  @Param("reference2") String ref2);
	

}
