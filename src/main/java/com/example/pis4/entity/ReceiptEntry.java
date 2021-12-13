package com.example.pis4.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "receipt_entry")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptEntry {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    Receipt receipt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "sum")
    Long sum;
}
