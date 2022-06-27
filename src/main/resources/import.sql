insert into user (`id`, `login_id`, `name`, `login_pw`, `role`, `created_at`, `updated_at`, `approved`, `profile_img`) values (1, 'dldbwls', 'test', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/60947c86-8a91-431a-8aa7-f718acd6c130');
insert into user (`id`, `login_id`, `name`, `login_pw`, `role`, `created_at`, `updated_at`, `approved`, `profile_img`) values (2, 'test1', 'Moo', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/b6790a41-ad94-46ae-a4cf-47220f438a9e');
insert into user (`id`, `login_id`, `name`, `login_pw`, `role`, `created_at`, `updated_at`, `approved`, `profile_img`) values (3, 'test2', 'Jung', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/60947c86-8a91-431a-8aa7-f718acd6c130');
insert into user (`id`, `login_id`, `name`, `login_pw`, `role`, `created_at`, `updated_at`, `approved`, `profile_img`) values (4, 'test3', 'Su', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'ACCEPTED', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/b6790a41-ad94-46ae-a4cf-47220f438a9e');
insert into user (`id`, `login_id`, `name`, `login_pw`, `role`, `created_at`, `updated_at`, `approved`, `profile_img`) values (5, 'test4', 'test4', '{bcrypt}$2a$10$d3QK7jlUd8NI6EdHmILzfejSoF.XSlmT/eRdb9zaXuM8YuWmTdzSO', 'boss', now(), now(), 'PENDING', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/60947c86-8a91-431a-8aa7-f718acd6c130');


insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(0, 1, 'test1', 'test1', 'test1', 1, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(1, 1, 'test1', 'test1', 'test1', 2, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(2, 1, 'test1', 'test1', 'test1', 3, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(3, 1, 'test1', 'test1', 'test1', 4, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(4, 1, 'test1', 'test1', 'test1', 5, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(5, 1, 'test1', 'test1', 'test1', 6, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(6, 1, 'test1', 'test1', 'test1', 7, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(7, 1, 'test1', 'test1', 'test1', 8, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(8, 1, 'test1', 'test1', 'test1', 9, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(9, 1, 'test1', 'test1', 'test1', 10, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(10, 1, 'test1', 'test1', 'test1', 11, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(11, 1, 'test1', 'test1', 'test1', 12, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(12, 1, 'test1', 'test1', 'test1', 13, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(13, 1, 'test1', 'test1', 'test1', 14, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(14, 1, 'test1', 'test1', 'test1', 15, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(15, 1, 'test1', 'test1', 'test1', 16, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(16, 1, 'test1', 'test1', 'test1', 17, now());
insert into announce(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `updated_at`) values(17, 1, 'test1', 'test1', 'test1', 18, now());

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
insert into message(`id`, `message`, `message_type`, `room_id`, `user_id`) values(34, 'test message 34', 'TALK', 0, 2);

insert into news(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `is_main`) values(0, 1, 'test title 1', 'test context 1', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/60947c86-8a91-431a-8aa7-f718acd6c130', 0, 'Y');
insert into news(`id`, `user_id`, `title`, `context`, `img_url`, `view_count`, `is_main`) values(1, 1, 'test title 2', 'test context 2', 'https://mblockimg.s3.us-east-2.amazonaws.com/profile/60947c86-8a91-431a-8aa7-f718acd6c130', 0, 'N');

