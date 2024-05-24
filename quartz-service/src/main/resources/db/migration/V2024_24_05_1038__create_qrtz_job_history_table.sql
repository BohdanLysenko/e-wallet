-- auto-generated definition
create table qrtz_job_history
(
    id            bigserial
        primary key,
    error_message varchar(255),
    fire_time     timestamp(6),
    job_class     varchar(255),
    run_time      bigint,
    status        varchar(255)
);

alter table qrtz_job_history
    owner to admin;

