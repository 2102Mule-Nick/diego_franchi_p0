--drop table members;
--drop table messages;
--drop table pictures;

create table members (
	username text primary key,
	secretword text not null,
	ages int,
	sex text,
	locations text,
	bio text,
	interests text [],
	emoji int
);

create table messages (
	msg_id serial primary key,
	msg_from_username text not null,
	msg_to_username text not null,
	sent timestamp,
	subject text not null,
	msg text not null,
	foreign key (msg_from_username) references members (username),
	foreign key (msg_to_username) references members (username)
);

create table emojis (
	emoji_id serial primary key,
	emoji_data text not null
	--foreign key (member_username) references members (username)
);

--TODO: CREATE BRIDGE TABLE FOR MEMBER EMOJI ASSIGNMENT
--create table member_emoji (
--	member_username text refrences members (username)
--);

drop table emojis;

select * from messages join members on msg_from_member_id = member_id;
select * from members

update members set sex = '?' where username = 'test';

insert into members values ('kingslayer','vengence',22,'M','Elwyn Forest','I will avenge my father',null)
insert into members values ('satcom23','rageaholic',25,'M','Oregon','looking for some PvP action',null);
insert into members values ('manaboost','renegadeangel69',26,'M','Ireland','i drink therefore i am',null);
insert into members values ('alwayskins','qt3.14',27,'F','Japan','meow :3',null);
insert into members values ('shiftz','chihuahua1',28,'F','Mexico','hopeless dreamer',null);
insert into members values ('fotophest','pooplord2000',24,'F','California','lolol xD',null);

insert into emojis values (default,'( ?° ?? ?°)');
insert into emojis values (default,'?(?¯??)');
insert into emojis values (default,'?(? ? ? ? ?)?');
insert into emojis values (default,'(? ???) ???U?');
insert into emojis values (default,'?????????¤=[]:::::>');
insert into emojis values (default,'?(~•??•?~)????????');
insert into emojis values (default,'( ?? ?? ??)');
insert into emojis values (default,'??=???=??');
insert into emojis values (default,'?(????????)???.*???');
insert into emojis values (default,'????????');
insert into emojis values (default,'?? ? ? ? ??');
insert into emojis values (default,'?( ? ? ? )?');
insert into emojis values (default,'?( ? ? ? )???.*???');
insert into emojis values (default,'?( ? ? ? )?');
insert into emojis values (default,'?[???]?');
insert into emojis values (default,'?? ? ? ?? ??');
insert into emojis values (default,'o????? • ?? • ??o???');
insert into emojis values (default,'(?????)');
insert into emojis values (default,'?( , ? – ? , )?');
insert into emojis values (default,'?*:. o(???)o .:*?');
insert into emojis values (default,'(??° ?? ?°)????');
insert into emojis values (default,'????=?????=????');
insert into emojis values (default,'? ? ? ? ?');
insert into emojis values (default,'??(???)??');
insert into emojis values (default,'?? ? ?? ? ?? ? ??');
insert into emojis values (default,'?? ? ? ? ??');
insert into emojis values (default,'???????');
insert into emojis values (default,'(V???V)');
insert into emojis values (default,'? ? ? ? ? ?');
insert into emojis values (default,'?( ? ? ? )?');
insert into emojis values (default,'??? ? ? ? ???');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');
insert into emojis values (default,'');

-----------------------------------------------------------------
--OLD SCHEMA
-----------------------------------------------------------------
--create table members (
--	member_id serial primary key,
--	username text not null,
--	secretword text not null,
--	ages int,
--	sex text,
--	locations text,
--	bio text,
--	interests text []
--);
--
--create table messages (
--	msg_id serial primary key,
--	msg_from_member_id int not null,
--	msg_to_member_id int not null,
--	date_sent date,
--	subject text not null,
--	msg text not null,
--	foreign key (msg_from_member_id) references members (member_id),
--	foreign key (msg_to_member_id) references members (member_id)
--);
--
--create table pictures (
--	picture_id serial primary key,
--	member_id int,
--	picture_title text,
--	picture_name text,
--	picture_data text not null,
--	foreign key (member_id) references members (member_id)
--);