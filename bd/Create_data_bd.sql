
-- Insert de restaurantes
INSERT INTO `BOOKING_RESTAURANT`.`restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES ('1', 'Hamburguesa Rica', 'Ricas hamburguesas sin igual', 'dirección de las hamburguesas', 'https://www.eltiempo.com/files/image_640_428/uploads/2021/02/18/602efaab12112.jpeg');
INSERT INTO `BOOKING_RESTAURANT`.`restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES ('2', 'Pollos Ricos', 'Ricos pollos sin igual', 'dirección de los pollos', 'https://cdn.recetas360.com/wp-content/uploads/2020/03/como-hacer-el-pollo-kfc.jpeg');
INSERT INTO `BOOKING_RESTAURANT`.`restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES ('3', 'Pizzas Ricas', 'Ricas pizzas sin igual', 'dirección de las pizzas', 'https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2021/03/30/6063031b90a87.r_d.1083-871-0.jpeg');

-- Insert de turnos
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('1', 'Turno_10_00', '1');
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('2', 'Turno_11_00', '1');
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('3', 'Turno_12_00', '1');
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('4', 'Turno_13_00', '1');

INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('5', 'Turno_10_00', '2');
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('6', 'Turno_11_00', '2');
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('7', 'Turno_12_00', '2');
INSERT INTO `booking_restaurant`.`turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES ('8', 'Turno_13_00', '2');

-- Insert de mesas
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('1', '3', '1', '1');
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('2', '6', '2', '1');
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('3', '2', '3', '1');
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('4', '5', '4', '1');

INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('5', '4', '1', '2');
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('6', '6', '2', '2');
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('7', '7', '3', '2');
INSERT INTO `booking_restaurant`.`board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES ('8', '8', '4', '2');

-- inset reservation
INSERT INTO `booking_restaurant`.`reservation` (`ID`, `LOCATOR`, `PERSON`, `TURN`, `RESTAURANT_ID`) VALUES ('1', 'dirección de las hamburguesas', '6', 'Turno_10_00', '1');
INSERT INTO `booking_restaurant`.`reservation` (`ID`, `LOCATOR`, `PERSON`, `TURN`, `RESTAURANT_ID`) VALUES ('2', 'Ricos pollos sin igual', '4', 'Turno_10_00', '2');
