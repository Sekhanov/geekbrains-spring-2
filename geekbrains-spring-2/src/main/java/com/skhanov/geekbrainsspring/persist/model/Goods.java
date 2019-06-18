package com.skhanov.geekbrainsspring.persist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "goods_type_id")
    private GoodsType goodsType;

    @ManyToOne
    @JoinColumn(name = "goods_brand_id")
    private GoodsBrand goodsBrand;

    @ManyToOne
    @JoinColumn(name = "goods_color_id")
    private GoodsColor goodsColor;



}