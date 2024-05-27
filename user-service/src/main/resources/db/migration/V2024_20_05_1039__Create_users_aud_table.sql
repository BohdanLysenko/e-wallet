create table revinfo
(
    rev      integer not null
        primary key,
    revtstmp bigint
);

create table users_aud
(
    id                              bigint                not null,
    rev                             integer               not null
        constraint users_aud_revinfo_fk
            references revinfo,
    revtype                         smallint,
    created_by                      varchar(255),
    created_date                    timestamp(6) with time zone,
    last_modified_by                varchar(255),
    last_modified_date              timestamp(6) with time zone,
    created_at                      timestamp(6) with time zone,
    email                           varchar(120),
    enabled                         boolean default true  not null,
    encrypted_password              varchar(255),
    first_name                      varchar(50),
    is_suspicious_activity_detected boolean default false not null,
    is_transaction_blocked          boolean default false not null,
    last_name                       varchar(50),
    role                            varchar(255)
        constraint users_aud_role_check
            check ((role)::text = ANY
                   ((ARRAY ['ROLE_USER'::character varying, 'ROLE_ADMIN'::character varying])::text[])),
    primary key (rev, id)
);
