create table users
(
    id                              bigint                not null
        primary key,
    created_by                      varchar(255),
    created_date                    timestamp(6) with time zone,
    last_modified_by                varchar(255),
    last_modified_date              timestamp(6) with time zone,
    created_at                      timestamp(6) with time zone,
    email                           varchar(120)          not null
        constraint unique_email_idx
            unique,
    enabled                         boolean default true  not null,
    encrypted_password              varchar(255)          not null,
    first_name                      varchar(50)           not null,
    is_suspicious_activity_detected boolean default false not null,
    is_transaction_blocked          boolean default false not null,
    last_name                       varchar(50)           not null,
    role                            varchar(255)
        constraint users_role_check
            check ((role)::text = ANY
        ((ARRAY ['ROLE_USER'::character varying, 'ROLE_ADMIN'::character varying])::text[]))
    );

alter table users
    owner to admin;