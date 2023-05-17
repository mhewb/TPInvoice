DROP DATABASE IF EXISTS TPInvoice;
CREATE DATABASE TPInvoice;
USE TPInvoice;

create table address
(
    id            bigint auto_increment
        primary key,
    city          varchar(255) null,
    street_name   varchar(255) null,
    street_number varchar(255) null,
    zip_code      varchar(255) null
);

create table role
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null,
    constraint UK_8sewwnpamngi6b1dwaa88askk
        unique (name)
);

create table users
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

create table clients
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

create table invoices
(
    id             bigint auto_increment
        primary key,
    payment_method varchar(255) null,
    due_date       date         null,
    issue_date     date         null,
    note           varchar(255) null,
    status         bit          not null,
    client_id      bigint       null,
    user_id        bigint       null,
    constraint FK9ioqm804urbgy986pdtwqtl0x
        foreign key (client_id) references clients (id),
    constraint FKbwr4d4vyqf2bkoetxtt8j9dx7
        foreign key (user_id) references users (id)
);

create table products
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    priceht     double       not null,
    user        bigint       null,
    user_id     bigint       null,
    constraint FKdb050tk37qryv15hd932626th
        foreign key (user_id) references users (id),
    constraint FKt2biqpcikn4bppo3qpqlwoh1w
        foreign key (user) references users (id)
);

create table invoice_line
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

create table users_role_list
(
    user_id      bigint not null,
    role_list_id bigint not null,
    constraint FK2oga5218nq5f1133098iwq6r5
        foreign key (user_id) references users (id),
    constraint FK6i3vy3o43ojqp827igbjxenyb
        foreign key (role_list_id) references role (id)
);





##### INSERTS

INSERT INTO role(name) VALUES
 ('USER'), ('ADMIN');

