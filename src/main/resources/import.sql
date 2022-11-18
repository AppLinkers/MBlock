insert into user (`id`, `login_id`, `name`, `login_pw`, `position`, `created_at`, `updated_at`, `role`, `profile_img`) values (0, 'admin', 'admin', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'admin', now(), now(), 'SYSTEM', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png');
insert into user (`id`, `login_id`, `name`, `login_pw`, `position`, `created_at`, `updated_at`, `role`, `profile_img`) values (1, 'dldbwls', 'test', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png');
insert into user (`id`, `login_id`, `name`, `login_pw`, `position`, `created_at`, `updated_at`, `role`, `profile_img`) values (2, 'test1', 'Moo', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png');
insert into user (`id`, `login_id`, `name`, `login_pw`, `position`, `created_at`, `updated_at`, `role`, `profile_img`) values (3, 'test2', 'Jung', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png');
insert into user (`id`, `login_id`, `name`, `login_pw`, `position`, `created_at`, `updated_at`, `role`, `profile_img`) values (4, 'test3', 'Su', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png');
insert into user (`id`, `login_id`, `name`, `login_pw`, `position`, `created_at`, `updated_at`, `role`, `profile_img`) values (5, 'test4', 'test4', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'PENDING', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png');


insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(0, 1, 'test1', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 1, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(1, 1, 'test2', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 2, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(2, 1, 'test3', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 3, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(3, 2, 'test4', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 4, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(4, 2, 'test5', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 5, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(5, 2, 'test6', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 6, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(6, 1, 'test7', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 7, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(7, 1, 'test8', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 8, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(8, 1, 'test9', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 9, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(9, 1, 'test10', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 10, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(10, 1, 'test11', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 11, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(11, 1, 'test12', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 12, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(12, 1, 'test13', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 13, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(13, 1, 'test14', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 14, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(14, 1, 'test15', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 15, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(15, 1, 'test16', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 16, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(16, 1, 'test17', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 17, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(17, 1, 'test18', 'test1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 18, now());

insert into room(`id`) values (0);

insert into user_and_room(`id`, `room_id`, `user_id`) values(0, 0, 2);
insert into user_and_room(`id`, `room_id`, `user_id`) values(1, 0, 3);
insert into user_and_room(`id`, `room_id`, `user_id`) values(2, 0, 4);

insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(0, 'test message 0', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(1, 'test message 1', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(2, 'test message 2', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(3, 'test message 3', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(4, 'test message 4', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(5, 'test message 5', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(6, 'test message 6', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(7, 'test message 7', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(8, 'test message 8', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(9, 'test message 9', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(10, 'test message 10', 'TALK', 0, 4);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(11, 'test message 11', 'TALK', 0, 4);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(12, 'test message 12', 'TALK', 0, 4);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(13, 'test message 13', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(14, 'test message 14', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(15, 'test message 15', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(16, 'test message 16', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(17, 'test message 17', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(18, 'test message 18', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(19, 'test message 19', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(20, 'test message 20', 'TALK', 0, 4);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(21, 'test message 21', 'TALK', 0, 4);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(22, 'test message 22', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(23, 'test message 23', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(24, 'test message 24', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(25, 'test message 25', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(26, 'test message 26', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(27, 'test message 27', 'TALK', 0, 4);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(28, 'test message 28', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(29, 'test message 29', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(30, 'test message 30', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(31, 'test message 31', 'TALK', 0, 3);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(32, 'test message 32', 'TALK', 0, 2);
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(33, 'test message 33', 'TALK', 0, 2);

insert into news(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `is_main`, `updated_at`) values(0, 1, 'test title 1', 'test context 1', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 0, 'Y', DATEADD('DAY', -3, CURRENT_DATE));
insert into news(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `is_main`, `updated_at`) values(1, 1, 'test title 2', 'test context 2', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 0, 'N', DATEADD('DAY', -7, CURRENT_DATE));
insert into news(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `is_main`, `updated_at`) values(2, 2, 'test title 2', 'test context 2', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 0, 'N', DATEADD('DAY', -5, CURRENT_DATE));
insert into news(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `is_main`, `updated_at`) values(3, 2, 'test title 3', 'test context 3', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png', 0, 'N', CURRENT_DATE );

insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(0,'KRW-BTC','비트코인', 'https://static.upbit.com/logos/BTC.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(1,'KRW-ETH','이더리움', 'https://static.upbit.com/logos/ETH.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(2,'KRW-SOL','솔라나', 'https://static.upbit.com/logos/SOL.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(3,'KRW-AVAX','아발란체', 'https://static.upbit.com/logos/AVAX.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(4,'KRW-MATIC','폴리곤', 'https://static.upbit.com/logos/MATIC.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(5,'KRW-NEAR','니어 프로토콜', 'https://static.upbit.com/logos/NEAR.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(6,'KRW-ATOM','코스모스', 'https://static.upbit.com/logos/ATOM.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(7,'KRW-ALGO','알고랜드', 'https://static.upbit.com/logos/ALGO.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(8,'KRW-ADA','에이다', 'https://static.upbit.com/logos/ADA.png','UPBIT');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(9,'KRW-DOT','폴카닷', 'https://static.upbit.com/logos/DOT.png','UPBIT');


insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(10,'ethusdt@ticker','이더리움', 'https://static.upbit.com/logos/ETH.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(11,'algousdt@ticker','알고랜드', 'https://static.upbit.com/logos/ALGO.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(12,'adausdt@ticker','에이다', 'https://static.upbit.com/logos/ADA.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(13,'dotusdt@ticker','폴카닷', 'https://static.upbit.com/logos/DOT.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(14,'solusdt@ticker','솔라나', 'https://static.upbit.com/logos/SOL.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(15,'avaxusdt@ticker','아발란체', 'https://static.upbit.com/logos/AVAX.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(16,'maticusdt@ticker','폴리곤', 'https://static.upbit.com/logos/MATIC.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(17,'nearusdt@ticker','니어 프로토콜', 'https://static.upbit.com/logos/NEAR.png','BINANCE');
insert into currency_info(`id`,`code`,`name`,`img_url`,`trading_site`) values(18,'atomusdt@ticker','코스모스', 'https://static.upbit.com/logos/ATOM.png','BINANCE');

insert into youtube(`id`,`title`,`info`,`url`,`hot_clip`,`subscribers`,`img_url`,`on_air`,`api_key`,`secret_key`) values(0, '막노동 고등어', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium ea blanditiis soluta culpa quis cum dolorum quaerat, magni libero nostrum porro voluptates. Labore, explicabo! Voluptatibus!', 'https://www.youtube.com/channel/UC7CIHYoacocIh93lEoUtzOA', 'https://www.youtube.com/embed/OfDt8Hfl6tk', 17700, 'https://yt3.ggpht.com/R_-Y0G2e-5--s5wC1zS87Bc85iTh2mrUdKVSR4ymwUuWg57WmEz4alt-qzQ9RXhoA2QSK2lYYf4=s88-c-k-c0x00ffffff-no-rj', 'Y', '', '');
insert into youtube(`id`,`title`,`info`,`url`,`hot_clip`,`subscribers`,`img_url`,`on_air`,`api_key`,`secret_key`) values(1, '막노동 고등어-2', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium ea blanditiis soluta culpa quis cum dolorum quaerat, magni libero nostrum porro voluptates. Labore, explicabo! Voluptatibus!', 'https://www.youtube.com/channel/UC7CIHYoacocIh93lEoUtzOA', 'https://www.youtube.com/embed/OfDt8Hfl6tk', 10, 'https://yt3.ggpht.com/R_-Y0G2e-5--s5wC1zS87Bc85iTh2mrUdKVSR4ymwUuWg57WmEz4alt-qzQ9RXhoA2QSK2lYYf4=s88-c-k-c0x00ffffff-no-rj', 'N', '', '');