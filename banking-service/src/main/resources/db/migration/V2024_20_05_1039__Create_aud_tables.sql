create table revinfo
(
    rev      integer not null
        primary key,
    revtstmp bigint
);

alter table revinfo
    owner to admin;

create table wallet_aud
(
    id                 bigint               not null,
    rev                integer              not null
        constraint wallet_aud_revinfo_fk
            references revinfo,
    revtype            smallint,
    created_by         varchar(255),
    created_date       timestamp(6) with time zone,
    last_modified_by   varchar(255),
    last_modified_date timestamp(6) with time zone,
    active             boolean default true not null,
    user_id            bigint,
    wallet_number      uuid,
    primary key (rev, id)
);

alter table wallet_aud
    owner to admin;
create table card_aud
(
    id                 bigint  not null,
    rev                integer not null
        constraint card_aud_revinfo_fk
            references revinfo,
    revtype            smallint,
    created_by         varchar(255),
    created_date       timestamp(6) with time zone,
    last_modified_by   varchar(255),
    last_modified_date timestamp(6) with time zone,
    active             boolean,
    balance            numeric(38, 2),
    card_number        varchar(255),
    cvv                integer,
    expiration_date    timestamp(6),
    wallet_id          bigint,
    primary key (rev, id)
);

alter table card_aud
    owner to admin;

create table transaction_aud
(
    id                  bigint      not null,
    rev                 integer     not null
        constraint transaction_aud_revinfo_fk
            references revinfo,
    transaction_type    varchar(31) not null,
    revtype             smallint,
    created_by          varchar(255),
    created_date        timestamp(6) with time zone,
    last_modified_by    varchar(255),
    last_modified_date  timestamp(6) with time zone,
    amount              numeric(38, 2),
    card_id             bigint,
    is_successful       boolean,
    is_suspicious       boolean,
    transaction_uuid    uuid,
    merchant_id         bigint,
    destination_card_id bigint,
    primary key (rev, id)
);

alter table transaction_aud
    owner to admin;

