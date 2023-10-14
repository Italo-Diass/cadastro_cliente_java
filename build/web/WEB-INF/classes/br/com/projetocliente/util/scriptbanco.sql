create table profissao(
	idprofissao serial not null,
	nomeprofissao varchar(30),
	constraint pk_profissao primary key(idprofissao)
);

create table pessoa(
        idpessoa serial not null,
        nomepessoa varchar(40),
        enderecopessoa varchar(40),
        cidadepessoa varchar(40),
        estadopessoa varchar(2),
        constraint pk_pessoa primary key(idpessoa)
);
create table cliente(
	idcliente serial not null,
	telefonecliente varchar(40),
	idprofissao integer,
        idpessoa integer,
	constraint pk_cliente primary key (idcliente),
	constraint fk_cliente_profissao foreign key(idprofissao) references profissao(idprofissao),
        constraint fk_cliente_pessoa foreign key(idpessoa) references pessoa(idpessoa)
        
);
create table usuario(
	idusuario serial not null,
	nomeusuario varchar(40),
	loginusuario varchar(40),
	senhausuario varchar(40),
	constraint pk_usuario primary key(idusuario)
);