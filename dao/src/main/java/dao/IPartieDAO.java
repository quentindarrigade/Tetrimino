package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ModelAdmin;

public interface IPartieDAO extends JpaRepository< ModelAdmin, Integer>{

}
