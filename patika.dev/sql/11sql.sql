--actor ve customer tablolarında bulunan first_name sütunları için tüm verileri sıralayalım.

select first_name from actor 
union 
select first_name from customer 

--actor ve customer tablolarında bulunan first_name sütunları için kesişen verileri sıralayalım.

select first_name from actor 
intersect
select first_name from customer 


--actor ve customer tablolarında bulunan first_name sütunları için ilk tabloda bulunan ancak ikinci
--tabloda bulunmayan verileri sıralayalım.

select first_name from actor 
except
select first_name from customer 

