package com.napptilus.reto.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Brands")
public class Brand {

    static final long serialVersionUID = 1511590038487230103L;
    
	@Id
	private Integer id;
	
	@NonNull
	private String name;
	
}
