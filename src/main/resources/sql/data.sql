INSERT INTO `favourite_movie`.`movie` (`Id_movie`, `name`, `url_image`, `year`, `type`, `score`, `status`) VALUES ('1NADG231', 'Chiến Tranh ', 'https://translate.google.com.vn/?sl=vi&tl=en&op=translate', '2000', 'Hành Động', '9', 'Đang Chiếu');
INSERT INTO `favourite_movie`.`movie` (`Id_movie`, `name`, `url_image`, `year`, `type`, `score`, `status`) VALUES ('2NMDAJH3', 'Chiến Lang', 'https://translate.google.com.vn/?sl=vi&tl=en&op=translate', '2001', 'Tình Cảm', '8', 'Đang Chiếu');
INSERT INTO `favourite_movie`.`movie` (`Id_movie`, `name`, `url_image`, `year`, `type`, `score`, `status`) VALUES ('3NCHAHSA', 'Cuộc Sống', 'https://translate.google.com.vn/?sl=vi&tl=en&op=translate', '1995', 'Tình Cảm', '6', 'Chưa Chiếu');
INSERT INTO `favourite_movie`.`movie` (`Id_movie`, `name`, `url_image`, `year`, `type`, `score`, `status`) VALUES ('4HADUIOS', 'Nhân Loại', 'https://translate.google.com.vn/?sl=vi&tl=en&op=translate', '1875', 'Chính Trị', '7', 'Đang Chiếu');
INSERT INTO `favourite_movie`.`movie` (`Id_movie`, `name`, `url_image`, `year`, `type`, `score`, `status`) VALUES ('5SAYYHSQ', 'Âm Nhạc', 'https://translate.google.com.vn/?sl=vi&tl=en&op=translate', '2012', 'Giải Trí', '8.5', 'Chưa Chiếu');

INSERT INTO `favourite_movie`.`rank_board` (`STT`, `view`, `Id_movie`) VALUES ('1', '50000', '1NADG231');
INSERT INTO `favourite_movie`.`rank_board` (`STT`, `view`, `Id_movie`) VALUES ('2', '40000', '4HADUIOS');
INSERT INTO `favourite_movie`.`rank_board` (`STT`, `view`, `Id_movie`) VALUES ('3', '30000', '2NMDAJH3');


INSERT INTO `favourite_movie`.`viewer` (`id_viewer`, `user_name`, `pass_word`, `email`) VALUES ('1111', 'Trịnh Văn Nhàn', 'trinhvannhan', 'trinh@gmail.com');
INSERT INTO `favourite_movie`.`viewer` (`id_viewer`, `user_name`, `pass_word`, `email`) VALUES ('2222', 'Đinh Tiến Hoàng', 'dinhtienhoang', 'dinhhoang@gmail.com');
INSERT INTO `favourite_movie`.`viewer` (`id_viewer`, `user_name`, `pass_word`, `email`) VALUES ('3333', 'Trịnh Kiều Mai', 'trinhkieumai', 'kieumai@gmail.com');



INSERT INTO `favourite_movie`.`favourite_list` (`id_viewer`, `Id_movie`) VALUES ('1111', '1NADG231');
INSERT INTO `favourite_movie`.`favourite_list` (`id_viewer`, `Id_movie`) VALUES ('1111', '4HADUIOS');
INSERT INTO `favourite_movie`.`favourite_list` (`id_viewer`, `Id_movie`) VALUES ('1111', '2NMDAJH3');
INSERT INTO `favourite_movie`.`favourite_list` (`id_viewer`, `Id_movie`) VALUES ('2222', '2NMDAJH3');
INSERT INTO `favourite_movie`.`favourite_list` (`id_viewer`, `Id_movie`) VALUES ('2222', '4HADUIOS');
INSERT INTO `favourite_movie`.`favourite_list` (`id_viewer`, `Id_movie`) VALUES ('3333', '2NMDAJH3');
