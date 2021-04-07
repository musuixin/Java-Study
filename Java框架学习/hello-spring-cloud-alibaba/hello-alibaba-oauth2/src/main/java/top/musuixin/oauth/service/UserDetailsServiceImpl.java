package top.musuixin.oauth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义用户认证与授权
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-04-04 23:57:04
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
        grantedAuthorities.add(grantedAuthority);
        return new User("user", "$2a$10$ONGHb81UYytGiiYHDUFQTOurJH1pUMQiB/2jEWKDL6MFzvXZ9sR.u", grantedAuthorities);
    }
}