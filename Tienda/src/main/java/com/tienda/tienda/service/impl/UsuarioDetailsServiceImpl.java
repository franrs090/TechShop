package com.tienda.tienda.service.impl;

import com.tienda.tienda.Domain.Rol;
import com.tienda.tienda.Domain.Usuario;
import com.tienda.tienda.dao.UsuarioDao;
import com.tienda.tienda.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Se busca el usuario en la base de datos
        Usuario usuario = usuarioDao.findByUsername(username);

        //Se valida que el usuario se encontrar
        if (usuario == null) {
            //No se encontro el usuario
            throw new UsernameNotFoundException(username);
        }

        session.setAttribute("usuarioImagen", usuario.getRutaImagen());

        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol rol : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
                
        return new User(usuario.getUsername(),
        usuario.getPassword(),
        roles);
    }

}
