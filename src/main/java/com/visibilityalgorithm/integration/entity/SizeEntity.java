package com.visibilityalgorithm.integration.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "size")
public class SizeEntity {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "back_soon")
    private boolean backSoon;

    @Column(name = "special")
    private boolean special;

    @OneToMany( mappedBy = "size", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REMOVE} )
    private List<StockEntity> stocks;

}
