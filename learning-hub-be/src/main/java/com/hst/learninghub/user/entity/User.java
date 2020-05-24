package com.hst.learninghub.user.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "USER")
@Getter
public class User extends BaseTimeEntity implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NO")
	private Long no;

	@Column(name = "USER_ID")
	private String id;

	@Column(name = "USER_NM")
	private String name;

	@Column(name = "USER_BIRTH")
	private LocalDateTime birthDate;

	@Column(name = "USER_ROLE_CD")
	private String roleType;

	@Column(name = "USER_JOIN_CD")
	private String joinType;

	@Column(name = "DEL_YN")
	private boolean deleted;

	@Column(name = "USER_PWD")
	private String password;

	@Transient
	private Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return this.no.toString();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
