--city tablosu ile country tablosunda bulunan şehir (city) ve ülke 
--(country) isimlerini birlikte görebileceğimiz LEFT JOIN sorgusunu yazınız.

select city, country from city
left join country
on country.country_id = city.country_id


--customer tablosu ile payment tablosunda bulunan payment_id ile customer
--tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz RIGHT JOIN sorgusunu yazınız.

select payment_id, first_name || ' '|| last_name as "fullname" from payment
right join customer
on payment.customer_id = customer.customer_id

--customer tablosu ile rental tablosunda bulunan rental_id ile customer
--tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz FULL JOIN sorgusunu yazınız.

select rental_id, first_name || ' '|| last_name as "fullname" from payment
full join customer
on payment.customer_id = customer.customer_id
