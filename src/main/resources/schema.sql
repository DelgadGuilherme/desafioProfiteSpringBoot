create table product (
    id int not null,
    name VARCHAR(90) not null,
    image VARCHAR(255) not null,
    oldPrice float not null,
    price float not null,
    description varchar(90),
    installments_id int not null
);

create table installments (
    id int not null,
    count int not null,
    value float not null
);
