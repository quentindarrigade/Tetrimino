package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ModelAdmin;
import model.ModelJoueur;

public interface IJoueurDAO extends JpaRepository< ModelJoueur, Integer> {

}
