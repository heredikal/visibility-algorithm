package com.visibilityalgorithm.integration.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "sequence")
    private int sequence;

    @OneToMany( mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REMOVE} )
    private List<SizeEntity> sizes;

}
