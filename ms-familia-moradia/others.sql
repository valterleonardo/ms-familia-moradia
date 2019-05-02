select 

	f.nome,
	sum(r.valor)

from familia f
join pessoa p on p.familia_id = f.id
join renda r on r.pessoa_id = p.id
where f.status = 0
group by f.nome;


select * from pessoa where id = 20;
update pessoa set data_nascimento = '2001-01-15' where id = 20


select * from familia f 
join pessoa p on p.familia_id = f.id
join renda r on r.pessoa_id = p.id
where f.status = 0;

select * from pessoa where id in (17,5);

select * from familia;
select * from status;
select * from renda;
select * from pessoa;
select * from familias_contempladas;


drop table status;
drop table renda;
drop table pessoa;
drop table familia;
drop table familias_contempladas;