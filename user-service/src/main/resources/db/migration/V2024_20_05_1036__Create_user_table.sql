create table users
(
    id                              bigint                not null
        primary key,
    first_name                      varchar(50)           not null,
    last_name                       varchar(50)           not null,
    email                           varchar(120)          not null
        constraint unique_user_email
            unique,
    encrypted_password              varchar(255)          not null,
    role                            varchar(10)
        constraint role_check
            check ((role)::text = ANY
        ((ARRAY ['ROLE_USER'::character varying, 'ROLE_ADMIN'::character varying])::text[])),
    is_suspicious_activity_detected boolean default false not null,
    is_transaction_blocked          boolean default false not null,
    enabled                         boolean default true  not null,
--     account_non_expired             boolean default true  not null,
--     account_non_locked              boolean default true  not null,
--     credentials_non_expired         boolean default true  not null,
    created_at                      timestamp(6) with time zone
);