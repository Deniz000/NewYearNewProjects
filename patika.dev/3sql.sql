--country tablosunda bulunan country sütunundaki ülke isimlerinden 'A'
--karakteri ile başlayıp 'a' karakteri ile sonlananları sıralayınız.
select * from country where country like 'A%a'

--country tablosunda bulunan country sütunundaki ülke isimlerinden en az 6 karakterden 
--oluşan ve sonu 'n' karakteri ile sonlananları sıralayınız.

select * from country where length(country)>5 and country like '%a'

--film tablosunda bulunan title sütunundaki film isimlerinden en az 4 adet büyük ya da küçük harf 
--farketmesizin 'T' karakteri içeren film isimlerini sıralayınız.
--eksik düşünülmüş
select * from film where title ilike 't%t%t' 

--film tablosunda bulunan tüm sütunlardaki verilerden title 'C' karakteri ile başlayan ve 
--uzunluğu (length) 90 dan büyük olan ve rental_rate 2.99 olan verileri sıralayınız.

select * from film where title Ilike 'c%' and length(title) > 90 and rental_rate =2.99

