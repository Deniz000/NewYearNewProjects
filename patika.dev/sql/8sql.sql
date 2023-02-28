--test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50),
--birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.

create table employee(
	id int not null,
	name VARCHAR(50),
	birthday DATE, 
	email VARCHAR(100)
)

--Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.

insert into employee (id, name, email) values (1, 'Papagena', 'pfairnington0@domainmarket.com');
insert into employee (id, name, email) values (2, 'Almira', 'aprando1@furl.net');
insert into employee (id, name, email) values (3, 'Gretel', 'gpheazey2@homestead.com');
insert into employee (id, name, email) values (4, 'Sunny', 'skeemar3@samsung.com');
insert into employee (id, name, email) values (5, 'Any', 'abewick4@reverbnation.com');
insert into employee (id, name, email) values (6, 'Pascal', 'pwybrew5@google.ca');
insert into employee (id, name, email) values (7, 'Drusy', 'dlangton6@weibo.com');
insert into employee (id, name, email) values (8, 'Freeland', 'fmarquet7@joomla.org');
insert into employee (id, name, email) values (9, 'Wittie', 'wlife8@gizmodo.com');
insert into employee (id, name, email) values (10, 'Kaycee', 'kwatkin9@addtoany.com');
insert into employee (id, name, email) values (11, 'Kass', 'krowdena@multiply.com');
insert into employee (id, name, email) values (12, 'Bancroft', 'bgrolmannb@samsung.com');
insert into employee (id, name, email) values (13, 'Teodor', 'tmartuginc@mozilla.com');
insert into employee (id, name, email) values (14, 'Amalita', 'acaudelld@msn.com');
insert into employee (id, name, email) values (15, 'Theodor', 'tsevillee@dedecms.com');
insert into employee (id, name, email) values (16, 'Temple', 'tsisnerosf@prnewswire.com');
insert into employee (id, name, email) values (17, 'Reggie', 'rgehrelsg@forbes.com');
insert into employee (id, name, email) values (18, 'Launce', 'lphinnessyh@theatlantic.com');
insert into employee (id, name, email) values (19, 'Onfre', 'ovankini@wordpress.org');
insert into employee (id, name, email) values (20, 'Marieann', 'mkalkerj@flavors.me');
insert into employee (id, name, email) values (21, 'Cecile', 'cpillingtonk@cargocollective.com');
insert into employee (id, name, email) values (22, 'Arie', 'apaul@google.it');
insert into employee (id, name, email) values (23, 'Constantino', 'charronm@amazonaws.com');
insert into employee (id, name, email) values (24, 'Olenolin', 'opon@ifeng.com');
insert into employee (id, name, email) values (25, 'Nickolaus', 'nwicklingo@harvard.edu');
insert into employee (id, name, email) values (26, 'Berty', 'bsterlandp@canalblog.com');
insert into employee (id, name, email) values (27, 'Shane', 'sstedellq@google.it');
insert into employee (id, name, email) values (28, 'Nonah', 'nninnisr@usnews.com');
insert into employee (id, name, email) values (29, 'Salvidor', 'smallens@aboutads.info');
insert into employee (id, name, email) values (30, 'Rowan', 'rgalierot@google.com.au');
insert into employee (id, name, email) values (31, 'Lynnelle', 'ljoirisu@uol.com.br');
insert into employee (id, name, email) values (32, 'Morgana', 'mrhulev@tmall.com');
insert into employee (id, name, email) values (33, 'Kally', 'kramsbottomw@skyrock.com');
insert into employee (id, name, email) values (34, 'Ailina', 'aconnaughtonx@livejournal.com');
insert into employee (id, name, email) values (35, 'Ester', 'eleinthally@weibo.com');
insert into employee (id, name, email) values (36, 'Viv', 'vlindwasserz@friendfeed.com');
insert into employee (id, name, email) values (37, 'Liana', 'lcaltun10@ucsd.edu');
insert into employee (id, name, email) values (38, 'Jerad', 'jtomaszczyk11@yale.edu');
insert into employee (id, name, email) values (39, 'Bastian', 'bganderton12@wufoo.com');
insert into employee (id, name, email) values (40, 'Antonius', 'awrennall13@illinois.edu');
insert into employee (id, name, email) values (41, 'Howey', 'hwaywell14@cloudflare.com');
insert into employee (id, name, email) values (42, 'Vivienne', 'vtuite15@wordpress.org');
insert into employee (id, name, email) values (43, 'Kevin', 'kvasentsov16@goodreads.com');
insert into employee (id, name, email) values (44, 'Lianne', 'lharnell17@mapy.cz');
insert into employee (id, name, email) values (45, 'Leonanie', 'lritchings18@wordpress.org');
insert into employee (id, name, email) values (46, 'Padriac', 'pgrzelak19@vk.com');
insert into employee (id, name, email) values (47, 'Barty', 'baspole1a@biglobe.ne.jp');
insert into employee (id, name, email) values (48, 'Emmery', 'eandreia1b@boston.com');
insert into employee (id, name, email) values (49, 'Pierrette', 'plamy1c@sphinn.com');
insert into employee (id, name, email) values (50, 'Monroe', 'mhavock1d@sphinn.com');

--Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
update employee
set birthday = '1972-01-28'
where id < 6


--Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
delete from employee
where id between 6 and 10 or name = 'Onfre' or email = 'apaul@google.it'

