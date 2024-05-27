create table wallet
(
    id                 bigserial
        primary key,
    created_by         varchar(255),
    created_date       timestamp(6) with time zone,
    last_modified_by   varchar(255),
    last_modified_date timestamp(6) with time zone,
    active             boolean default true not null,
    user_id            bigint
        constraint user_id_idx
            unique,
    wallet_number      uuid
);

alter table wallet
    owner to admin;
