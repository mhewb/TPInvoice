package io.m2i.TPInvoice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String PaymentMethod;
    private boolean status; // false = pending, true = paid
    private String note; // In case pending is for a good reason
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceLine> invoiceLineList;

    public void setDueDate() {
        this.dueDate = this.issueDate.plusMonths(1);
    }

}
