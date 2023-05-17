DROP DATABASE IF EXISTS TPInvoice;
CREATE DATABASE TPInvoice;
USE TPInvoice;

create table if not exists address
(
    id            bigint auto_increment
        primary key,
    city          varchar(255) null,
    street_name   varchar(255) null,
    street_number varchar(255) null,
    zip_code      varchar(255) null
);

create table if not exists users
(
    id         bigint auto_increment
        primary key,
    email      varchar(255) null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    password   varchar(255) null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email)
);

create table if not exists clients
(
    id           bigint auto_increment
        primary key,
    company_name varchar(255) null,
    phone_number varchar(255) null,
    address_id   bigint       null,
    user_id      bigint       null,
    constraint UK_fs667xslr12dy0tbqohssdw99
        unique (company_name),
    constraint FK5mji06wnp82ijq4297i6vfnfq
        foreign key (address_id) references address (id),
    constraint FKtiuqdledq2lybrds2k3rfqrv4
        foreign key (user_id) references users (id)
);

create table if not exists invoices
(
    id             bigint auto_increment
        primary key,
    payment_method varchar(255) null,
    due_date       date         null,
    issue_date     date         null,
    note           varchar(255) null,
    status         bit          not null,
    client_id      bigint       null,
    constraint FK9ioqm804urbgy986pdtwqtl0x
        foreign key (client_id) references clients (id)
);

create table if not exists products
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    priceht     double       not null,
    user_id     bigint       null,
    constraint FKdb050tk37qryv15hd932626th
        foreign key (user_id) references users (id)
);

create table if not exists invoice_line
(
    id         bigint auto_increment
        primary key,
    quantity   double not null,
    invoice_id bigint null,
    product_id bigint null,
    constraint FK2b91edluue12qy0l4ttn2comt
        foreign key (invoice_id) references invoices (id),
    constraint FKkcyquhshtjlug2hvypkmrwnyh
        foreign key (product_id) references products (id)
);

##### INSERTS

INSERT INTO users(id, email, first_name, last_name, password) VALUES
  (1, 'admin@my-invoice.fr', 'prénom', 'nom', 'qwerty')

