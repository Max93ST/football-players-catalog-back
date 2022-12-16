insert into team (id, name)
values (1, 'Perm');

insert into team (id, name)
values (2, 'Moscow');

insert into player (id, first_name, second_name, gender, birthday, team_id, country, deleted)
values  (1, 'Max', 'Starkov', 'MALE', '1993-01-29', 1, 'RU', false);

insert into player (id, first_name, second_name, gender, birthday, team_id, country, deleted)
values  (2, 'Petr', 'Ivanov', 'FEMALE', '1934-11-24', 2, 'IT', false);

insert into player (id, first_name, second_name, gender, birthday, team_id, country, deleted)
values  (3, 'Ivan', 'Petrov', 'MALE', '2001-06-05', 2, 'US', false);