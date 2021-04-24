package com.example.backend.appUser;

import com.example.backend.entity.BillingAdress;
import com.example.backend.entity.Cart;
import com.example.backend.entity.DeliveryAdress;
import com.example.backend.entity.Rating;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "APP_USER")
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "test",
            sequenceName = "test",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;

    @OneToMany(mappedBy = "appUser")
    private Set<Cart> carts;

    @OneToMany(mappedBy = "appUser")
    private Set<Rating> ratings;

    @OneToOne()
    @JoinColumn(name = "BILLING_ADRESS_id")
    private BillingAdress billingAdress;

    @OneToOne()
    @JoinColumn(name = "DELIVERY_ADRESS_id")
    private DeliveryAdress deliveryAdress;




    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() { return firstName;};

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
