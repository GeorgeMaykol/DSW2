package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.dto.ClientResponseDTO;
import com.idat.idatapirest.model.Client;
import com.idat.idatapirest.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository repository;

	@Override
	public void guardarCliente(ClientRequestDTO c) {
		Client cliente = new Client();
		cliente.setIdCliente(c.getIdRequest());
		cliente.setCliente(c.getClienteRequest());
		cliente.setCelular(c.getCelularRequest());
		repository.save(cliente);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarCliente(ClientRequestDTO c) {
		Client cliente = new Client();
		cliente.setIdCliente(c.getIdRequest());
		cliente.setCliente(c.getClienteRequest());
		cliente.setCelular(c.getCelularRequest());
		repository.saveAndFlush(cliente);
		
	}

	@Override
	public List<ClientResponseDTO> listarCliente() {
		List<Client> cliente = repository.findAll();
		List<ClientResponseDTO> dto = new ArrayList<ClientResponseDTO>();
		ClientResponseDTO clienteDTO = null;
		
		for (Client clientes : cliente) {
			clienteDTO = new ClientResponseDTO();
			clienteDTO.setIdResponse(clientes.getIdCliente());
			clienteDTO.setClienteResponse(clientes.getCliente());
			clienteDTO.setCelularResponse(clientes.getCelular());
			dto.add(clienteDTO);			
		}
		return dto;
	}

	@Override
	public ClientResponseDTO clienteById(Integer id) {
		Client cliente = repository.findById(id).orElse(null);
		ClientResponseDTO clienteDTO = new ClientResponseDTO();
		clienteDTO = new ClientResponseDTO();
		clienteDTO.setIdResponse(cliente.getIdCliente());
		clienteDTO.setClienteResponse(cliente.getCliente());
		clienteDTO.setCelularResponse(cliente.getCelular());
		return clienteDTO;
	}

}
