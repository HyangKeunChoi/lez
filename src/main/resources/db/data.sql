INSERT INTO events (name, start_at, end_at, created_at, updated_at) VALUES
('봄맞이 웹툰 할인 이벤트', '2025-05-01 00:00:00', '2025-05-15 23:59:59', NOW(), NOW()),
('인기 웹툰 무료 공개', '2025-05-05 10:00:00', '2025-05-12 18:00:00', NOW(), NOW()),
('신작 웹툰 런칭 기념 이벤트', '2025-05-10 00:00:00', '2025-05-24 23:59:59', NOW(), NOW()),
('웹툰 보고 코인 받자', '2025-05-15 09:00:00', '2025-05-22 21:00:00', NOW(), NOW()),
('첫 구매 감사 이벤트', '2025-05-20 00:00:00', '2025-06-03 23:59:59', NOW(), NOW()),
('여름 특집 공포 웹툰', '2025-06-01 00:00:00', '2025-06-15 23:59:59', NOW(), NOW()),
('액션 웹툰 주말 할인', '2025-06-07 00:00:00', '2025-06-09 23:59:59', NOW(), NOW()),
('로맨스 웹툰 정주행 이벤트', '2025-06-10 10:00:00', '2025-06-17 18:00:00', NOW(), NOW()),
('판타지 웹툰 댓글 이벤트', '2025-06-15 00:00:00', '2025-06-29 23:59:59', NOW(), NOW()),
('완결 웹툰 다시보기', '2025-06-20 09:00:00', '2025-06-27 21:00:00', NOW(), NOW());

INSERT INTO webtoons (name, created_at, updated_at) VALUES
('신의 탑', NOW(), NOW()),
('노블레스', NOW(), NOW()),
('랜덤채팅의 그녀!', NOW(), NOW()),
('여신강림', NOW(), NOW()),
('프리드로우', NOW(), NOW()),
('가우스전자', NOW(), NOW()),
('마음의 소리', NOW(), NOW()),
('문유', NOW(), NOW()),
('호랑이형님', NOW(), NOW()),
('테러맨', NOW(), NOW());

INSERT INTO event_webtoons (event_id, webtoon_id, created_at, updated_at) VALUES
(1, 1, NOW(), NOW()),
(1, 3, NOW(), NOW()),
(2, 2, NOW(), NOW()),
(2, 4, NOW(), NOW()),
(3, 5, NOW(), NOW()),
(3, 7, NOW(), NOW()),
(4, 6, NOW(), NOW()),
(4, 8, NOW(), NOW()),
(5, 9, NOW(), NOW()),
(5, 10, NOW(), NOW());

INSERT INTO payments (webtoon_id, payment_type, created_at, updated_at) VALUES
(1, 'PAID', NOW(), NOW()),
(2, 'PAID', NOW(), NOW()),
(3, 'FREE', NOW(), NOW()),
(4, 'PAID', NOW(), NOW()),
(5, 'PAID', NOW(), NOW()),
(6, 'FREE', NOW(), NOW()),
(7, 'PAID', NOW(), NOW()),
(8, 'PAID', NOW(), NOW()),
(9, 'FREE', NOW(), NOW()),
(10, 'PAID', NOW(), NOW());

INSERT INTO webtoon_histories (webtoon_id, user_id, created_at, updated_at) VALUES
(1, 101, NOW(), NOW()),
(2, 102, NOW(), NOW()),
(3, 101, NOW(), NOW()),
(4, 103, NOW(), NOW()),
(5, 102, NOW(), NOW()),
(6, 104, NOW(), NOW()),
(7, 101, NOW(), NOW()),
(8, 105, NOW(), NOW()),
(9, 103, NOW(), NOW()),
(10, 102, NOW(), NOW());