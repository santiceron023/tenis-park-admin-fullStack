package com.ceiba.AdminTenisPark.infraestructura.repositorio.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.AdminTenisPark.dominio.modelo.Tarifa;
import com.ceiba.AdminTenisPark.dominio.puerto.repositorio.TarifaRepositorio;
import com.ceiba.AdminTenisPark.infraestructura.repositorio.entity.TarifaEntity;
import com.ceiba.AdminTenisPark.infraestructura.repositorioJpa.TarifaRespositorioJpa;

@Repository
public class TarifaRepositorioPosgres implements TarifaRepositorio{

	private final TarifaRespositorioJpa repoJpa;	
	private ModelMapper modelMapper = new ModelMapper();

	public TarifaRepositorioPosgres(TarifaRespositorioJpa repoJpa) {
		this.repoJpa = repoJpa;
	}

	@Override
	public Tarifa consultar(int dia) {
		TarifaEntity tarifaEntity = repoJpa.consultarPorDia(dia);
		return modelMapper.map(tarifaEntity, Tarifa.class);
	}

	@Override
	public void crear(Tarifa tarifa) {
		TarifaEntity entity = modelMapper.map(tarifa, TarifaEntity.class);
		repoJpa.save(entity);
	}

}