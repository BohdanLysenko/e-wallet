create table card
(
    id                 bigserial
        primary key,
    created_by         varchar(255),
    created_date       timestamp(6) with time zone,
    last_modified_by   varchar(255),
    last_modified_date timestamp(6) with time zone,
    active             boolean not null,
    balance            numeric(38, 2),
    card_number        varchar(255),
    cvv                integer not null,
    expiration_date    timestamp(6),
    wallet_id          bigint
        constraint wallet_id_idx
            references wallet
);

alter table card
    owner to admin;
