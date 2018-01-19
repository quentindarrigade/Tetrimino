package dao;
import org.springframework.data.jpa.repository.JpaRepository;

import model.*;

public interface IAdminDAO extends JpaRepository< ModelAdmin, Integer> {

}
