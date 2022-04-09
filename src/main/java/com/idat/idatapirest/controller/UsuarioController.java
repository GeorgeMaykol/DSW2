package com.idat.idatapirest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatapirest.dto.UserRequestDTO;
import com.idat.idatapirest.dto.UserResponseDTO;
import com.idat.idatapirest.security.JWTUserDetailService;
import com.idat.idatapirest.security.JWTTokenUtil;

@RestController
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private JWTTokenUtil tokenUtil;
	
	@Autowired
	private JWTUserDetailService userDetails;
	
	@RequestMapping(method = RequestMethod.POST, path ="/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UserRequestDTO request){
		
		UserDetails userDetail = userDetails.loadUserByUsername(request.getUsuario());
		
		return ResponseEntity.ok(new UserResponseDTO(tokenUtil.generateToken(userDetail.getUsername())));
	}

	
}
