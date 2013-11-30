# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table articulo (
  id                        bigint not null,
  name                      varchar(255),
  amount                    integer,
  my_list_id                bigint,
  constraint pk_articulo primary key (id))
;

create table lista (
  id                        bigint not null,
  name                      varchar(255),
  created_at                timestamp not null,
  constraint pk_lista primary key (id))
;

create table usuario (
  id                        bigint not null,
  nick_name                 varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (id))
;


create table usuario_lista (
  usuario_id                     bigint not null,
  lista_id                       bigint not null,
  constraint pk_usuario_lista primary key (usuario_id, lista_id))
;
create sequence articulo_seq;

create sequence lista_seq;

create sequence usuario_seq;

alter table articulo add constraint fk_articulo_myList_1 foreign key (my_list_id) references lista (id) on delete restrict on update restrict;
create index ix_articulo_myList_1 on articulo (my_list_id);



alter table usuario_lista add constraint fk_usuario_lista_usuario_01 foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;

alter table usuario_lista add constraint fk_usuario_lista_lista_02 foreign key (lista_id) references lista (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists articulo;

drop table if exists lista;

drop table if exists usuario_lista;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists articulo_seq;

drop sequence if exists lista_seq;

drop sequence if exists usuario_seq;

