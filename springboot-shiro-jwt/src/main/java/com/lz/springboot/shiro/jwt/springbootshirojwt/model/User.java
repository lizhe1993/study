package com.lz.springboot.shiro.jwt.springbootshirojwt.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 李哲 【wb71@yingu.com】
 * @date 2019/4/14 20:12
 */
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "t_user",uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

    private String permission;
}
