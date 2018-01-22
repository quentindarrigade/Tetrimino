package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ModelFAQ;

public interface IFAQDAO extends JpaRepository< ModelFAQ, Integer>{

}
