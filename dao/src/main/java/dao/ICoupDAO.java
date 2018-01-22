package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ModelAdmin;

public interface ICoupDAO extends JpaRepository< ModelAdmin, Integer> {

}
