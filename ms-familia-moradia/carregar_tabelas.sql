insert into familia (id, nome, status) values (1,'Bortoletto','0');
insert into familia (id, nome, status) values (3,'Tropeço','2');
insert into familia (id, nome, status) values (4,'Brasil','3');
insert into familia (id, nome, status) values (5,'TI','0');

insert into status (id, codigo, descricao) values (1,0,'Cadastro Inválido');
insert into status (id, codigo, descricao) values (2,1,'Já possui uma casa');
insert into status (id, codigo, descricao) values (3,2,'Selecionada em outro processo de seleção');
insert into status (id, codigo, descricao) values (4,3,'Cadastro incompleto');
insert into status (id, codigo, descricao) values (5,4,'Contemplada');

insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (1,'João',2,'30-12-1989',3);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (2,'Maria',0,'30-12-1989',3);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (3,'José',1,'30-12-2015',3);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (4,'Angela',1,'30-12-2015',3);

insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (5,'Valter José',2,'02-06-1963',1);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (6,'Sandra Lilia',0,'10-02-1963',1);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (7,'Luis Felipe',1,'24-12-1992',1);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (8,'Valter Leonardo',1,'20-05-1991',1);

insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (13,'MS',2,'02-06-1963',4);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (14,'MT',0,'10-02-1963',4);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (15,'RIO',1,'24-12-1992',4);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (16,'SAMPA',1,'20-05-1991',4);

insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (17,'Pretendente',2,'30-12-1989',5);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (18,'Conjuge',0,'30-12-1989',5);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (19,'Dependente1',1,'30-12-2015',5);
insert into pessoa (id, nome, tipo, data_nascimento, familia_id) values (20,'Dependente2',1,'30-12-2015',5);

insert into renda (id, pessoa_id, valor) values (1,1,1500);
insert into renda (id, pessoa_id, valor) values (2,2,1500);
insert into renda (id, pessoa_id, valor) values (3,3,1500);
insert into renda (id, pessoa_id, valor) values (4,4,1500);
insert into renda (id, pessoa_id, valor) values (5,5,2500);
insert into renda (id, pessoa_id, valor) values (6,6,2500);
insert into renda (id, pessoa_id, valor) values (7,7,2500);
insert into renda (id, pessoa_id, valor) values (8,8,2500);
insert into renda (id, pessoa_id, valor) values (9,9,1500);
insert into renda (id, pessoa_id, valor) values (10,10,1500);
insert into renda (id, pessoa_id, valor) values (11,11,0);
insert into renda (id, pessoa_id, valor) values (12,12,0);
insert into renda (id, pessoa_id, valor) values (13,13,500);
insert into renda (id, pessoa_id, valor) values (14,14,100);
insert into renda (id, pessoa_id, valor) values (15,15,20);
insert into renda (id, pessoa_id, valor) values (16,16,10);
