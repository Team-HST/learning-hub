package com.hst.learninghub.user.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.user.type.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "user")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseTimeEntity implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_no")
	private Long no;

	@Column(name = "user_id")
	private String id;

	@Column(name = "USER_NM")
	private String name;

	@Column(name = "user_pwd")
	private String password;

	@Column(name = "user_birth")
	private LocalDate birthDate;

	@Column(name = "user_role_cd")
	@Convert(converter = UserRole.Converter.class)
	private UserRole roleType;

	@Column(name = "user_join_cd")
	private String joinType;

	@Column(name = "del_yn")
	private Boolean deleted;

	@OneToOne
	@JoinColumn(name = "profile_image_file_no")
	private FileInfo profileImage;

	@Transient
	private Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

	public void changeUserProfile(FileInfo profileImage) {
		this.profileImage = profileImage;
	}

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
