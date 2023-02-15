package com.hotmail.oberziner.paulo.media.Repositorio;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.hotmail.oberziner.paulo.media.modelo.AlunoModelo;

public interface AlunoRepositorio extends Repository<AlunoModelo,Integer>{
	void save (AlunoModelo colaborador);
	List<AlunoModelo> findAll();
	AlunoModelo findByCodigo(Integer codigo);
	void delete(AlunoModelo colaborador);
	AlunoModelo findBySituacao(String situacao);
}
