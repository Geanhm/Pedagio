create database pedagio;

create table veiculos(

id int not null auto_incremente primary key,
modelo varchar(40),
placa varchar(9),
dataCadastro date);


create table passantes(

id int not null auto_incremente primary key,
veiculo_id int,
data datetime);