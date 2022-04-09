package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.dto.ClientResponseDTO;

public interface ClientService {
	
	public void guardarCliente(ClientRequestDTO c);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClientRequestDTO c);
	public List<ClientResponseDTO> listarCliente();
	public ClientResponseDTO clienteById(Integer id);
	

}
