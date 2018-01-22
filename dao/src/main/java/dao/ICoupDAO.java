package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ModelAdmin;
import model.ModelCoup;

public interface ICoupDAO extends JpaRepository< ModelCoup, Integer> {

}
