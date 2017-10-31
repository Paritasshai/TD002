//package com.tamdai.model.config.security;
//
//import com.tamdai.model.security.entity.UserEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
///**
// * Created by Dto on 4/19/2015.
// */
//public class SecurityUser extends UserEntity implements UserDetails {
//    private static final long serialVersionUID = 1L;
//    public SecurityUser(UserEntity user){
//        if (user != null){
//            this.setId(user.getId());
//            this.setFirstName(user.getFirstName());
//            this.setEmail(user.getEmail());
//            this.setPassword(user.getPassword());
//            this.setStatus(user.getStatus());
//        }
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        Collection<GrantedAuthority> authorities = new ArrayList<>();
////        Set<Role> userRoles = this.getRoles();
////
////        if (userRoles != null)
////        {
////            for (Role role: userRoles){
////                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
////                authorities.add(authority);
////            }
////        }
////        return authorities;
////    }
////
////    @Override
////    public String getUsername() {
////        return super.getUsername();
////    }
////
////    @Override
////    public String getPassword(){
////        return super.getPassword();
////    }
////    @Override
////    public boolean isAccountNonExpired() {
////        return true;
////    }
////
////    @Override
////    public boolean isAccountNonLocked() {
////        return true;
////    }
////
////    @Override
////    public boolean isCredentialsNonExpired() {
////        return true;
////    }
////
////    @Override
////    public boolean isEnabled() {
////        return true;
////    }
//}
