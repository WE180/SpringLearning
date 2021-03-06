package com.we.springboot.mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * @author sudingkun
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户id
     * 下面两个注解是在使用mybatis通用mapper加的
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

}