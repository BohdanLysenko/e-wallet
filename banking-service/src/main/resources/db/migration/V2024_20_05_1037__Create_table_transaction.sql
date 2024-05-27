-- auto-generated definition
create table transaction
(
    transaction_type    varchar(31) not null,
    id                  bigserial
        primary key,
    created_by          varchar(255),
    created_date        timestamp(6) with time zone,
    last_modified_by    varchar(255),
    last_modified_date  timestamp(6) with time zone,
    amount              numeric(38, 2),
    card_id             bigint,
    is_successful       boolean     not null,
    is_suspicious       boolean     not null,
    transaction_uuid    uuid        not null
        constraint transaction_uuid_idx
            unique,
    merchant_id         bigint,
    destination_card_id bigint
);

alter table transaction
    owner to admin;

