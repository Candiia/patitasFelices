INSERT INTO tipo_animal(id, tipo) VALUES (1,'Perro');
INSERT INTO tipo_animal(id,tipo) VALUES (2,'Gato');
ALTER SEQUENCE tipo_animal_seq RESTART WITH 100;

INSERT INTO animal (id, nombre, apodo, aspectos_veterinarios, fecha_nacimiento, genero, foto, tipo_animal_id, historia, adoptado, raza) VALUES (1, 'lucas', 'dfkagdfgj', 'asdjkjasgjdhasd', '2014-02-25', 'Macho','https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg' ,1, 'dkjasgdjagsdasgdjsd', true, 'jhhgdasjhgashd' );
INSERT INTO animal (id, nombre, apodo, aspectos_veterinarios, fecha_nacimiento, genero, foto, tipo_animal_id, historia, adoptado, raza) VALUES (2, 'mdh', 'dfkagdfgj', 'asdjkjasgjdhasd', '2014-02-25', 'Macho','https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg' ,1, 'dkjasgdjagsdasgdjsd', true, 'jhhgdasjhgashd' );
INSERT INTO animal (id, nombre, apodo, aspectos_veterinarios, fecha_nacimiento, genero, foto, tipo_animal_id, historia, adoptado, raza) VALUES (3, 'dsadas', 'dfkagdfgj', 'asdjkjasgjdhasd', '2014-02-25', 'Macho','https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg' ,2, 'dkjasgdjagsdasgdjsd', false, 'jhhgdasjhgashd' );
INSERT INTO animal (id, nombre, apodo, aspectos_veterinarios, fecha_nacimiento, genero, foto, tipo_animal_id, historia, adoptado, raza) VALUES (4, 'ytiouty', 'dfkagdfgj', 'asdjkjasgjdhasd', '2014-02-25', 'Macho','https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg' ,1, 'dkjasgdjagsdasgdjsd', true, 'jhhgdasjhgashd' );
INSERT INTO animal (id, nombre, apodo, aspectos_veterinarios, fecha_nacimiento, genero, foto, tipo_animal_id, historia, adoptado, raza) VALUES (5, 'wrerr', 'dfkagdfgj', 'asdjkjasgjdhasd', '2014-02-25', 'Macho','https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg' ,2, 'dkjasgdjagsdasgdjsd', false, 'jhhgdasjhgashd' );
ALTER SEQUENCE animal_seq RESTART WITH 100;

INSERT INTO categoria_producto(id, categoria) VALUES (1,'Medicinas');
INSERT INTO categoria_producto(id, categoria) VALUES (2,'Juguetes');
INSERT INTO categoria_producto(id, categoria) VALUES (3,'Alimentos');
INSERT INTO categoria_producto(id, categoria) VALUES (4,'Accesorios');
ALTER SEQUENCE categoria_producto_seq RESTART WITH 100;

INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (1, 'TREATTRICKS PUPPY MORDEDOR EN FORMA DE T-REX PARA PERROS', 7.99, 'Este juguete para perros es de goma en color morado. La forma simula un dinosaurio T-Rex, es de un material flexible y muy resistente para que pueda jugar sin poner en peligro su salud. Además, sirve para colocar snacks y que tu peludo pueda jugar con él hasta conseguir comérselos. Es una forma de premiarle y que se entretenga durante el día. Este tipo de juguetes ayudan a desarrollar la parte inteligente del cerebro de tu perro. Deberás dar este alimento complementario a tu peludo junto con una alimentación sana y equilibrada. Además de hidratarle siempre con agua fresca. Este producto junto sus snacks deberás mantenerle un lugar fresco y seco. No está indicado para perros menores de 6 meses.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw43a14d2c/images/juguetes_perro_treat_tricks_dental_puppy_trex_TRT88638_M.jpg?sw=780&sh=780&q=85', 2);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (2, 'HILLS SCIENCE PLAN ADULT MEDIUM POLLO PIENSO PARA PERROS', 20.50, 'El pienso para perros Hills Adult Light  con pollo es un pienso para perros de 1 a 7 años de edad que necesiten una menor cantidad de calorías: perros poco activos, esterilizados o con tendencia al sobrepeso. ', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dwcb551f6d/images/pienso_perros_hills_adult_light_pollo_newpack_HIL7703DA_M_JN23%20(1).jpg?sw=528&sh=528', 3);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (3, 'NOVA CLEAN PORTA BOLSAS + 360 BOLSAS HIGIÉNICAS PARA HECES DE PERROS', 8.89, 'No te quedes sin bolsas higiénicas cuando vayas con tu mascota, con el pack económico de Nova Clean dispondrás de todas las bolsas que necesites durante un largo período de tiempo. En esta ocasión, además, el pack incluye un cómodo y práctico dispensador que puedes llevar colgado de la correa o de tu bolsa.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw47daee9f/images/accesorios_perros_pack_dispensador_bolsas_NCL88654.jpg?sw=780&sh=780&q=85', 4);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (4, 'SERESTO COLLAR ANTIPARASITARIO PARA GATOS', 34.25, 'El collar antiparasitario externo de Seresto protege a tu gato contra pulgas, garrapatas y piojos durante un ciclo de hasta 8 meses; la duración más larga del mercado de todos los productos antiparasitarios. El collar Seresto para gatos es uno de los métodos más cómodos que existen, para que no tengas los comunes olvidos de otros sistemas mensuales, ya que solo tienes que colocarlo en el cuello de tu mascota y ningún parásito le atacará durante todo este tiempo. ', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw6f73813b/images/antiparasitarios_gatos_collar_seresto_BAY83883953.jpg?sw=528&sh=528', 1);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (5, 'FRONTPRO COMPRIMIDOS MASTICABLES ANTIPARASITARIO PARA PERROS', 32.41, 'Frontpro presenta estos comprimidos masticables antiparasitarios para perros, los cuales erradican a los parásitos externos con solo un comprimido al mes. Su principio activo es Afoxolaner, el cual es un insecticida y acaricida que provoca una reacción en el sistema nervioso central del perro, para matar a las pulgas, garrapatas y ácaros, incluso desde antes de que pongan huevos.', 'https://www.tiendanimal.es/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw21460e3a/images/Frontpro_Comprimidos_Masticables_Antiparasitario_para_perros_BOE154746_M_1%20(1).jpg?sw=528&sh=528', 1);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (6, 'ADVANCE ACTIVE DEFENSE MEDIUM PUPPY POLLO Y ARROZ PIENSO PARA PERROS', 23.79, 'El alimento para perros cachorros Affinity Advance Puppy Medium Pollo y Arroz es un alimento para perros especialmente indicado para Cachorros desde los 2 a los 12 meses de edad que en edad adulta alcancen un peso que se sitúe entre los 10 a los 30 kg. Se trata de una comida especialmente diseñada para aquellos perros que están comenzando a comer comida sólida y necesitan todas las vitaminas necesarias para un crecimiento sano.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw4d09681e/images/pienso_perros_affinity_advance_puppy_medium_12kg_ADV507319_M_0.jpg?sw=780&sh=780&q=85', 3);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (7, 'CATZILLA ADULT STERILISED PIENSO PARA GATOS ESTERILIZADOS', 17.95, 'Los gatos y gatas esterilizadas tienen tendencia a ganar peso, es posible que se vuelvan más tranquilos y con menos nivel de energía, para evitar esto necesitan un tipo de alimentación adecuada a su estilo de vida. El pienso de Catzilla Sterilised para gatos y gatas esterilizadas tiene la composición ideal para que tu mascota no tenga problema a la hora de controlar su peso.', 3);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (8, 'PLAY&BITE PELOTA ROJA DE PLÁSTICO CON SONIDO', 4.99, 'Esta pelota Squeaky de Play&Bite para perros tiene un sonido integrado que llama la atención de tu perro cuando suena, además protege las encías de tu mascota y limpia sus dientes evitando el sarro gracias al relieve.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw83a47ba8/images/play_bite_pelota_sonido_perros_PLB16482.jpg?sw=528&sh=528', 2);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (9, 'OUTECH COMEDERO PLEGABLE DE VIAJE PARA PERROS', 17.95, 'El OUTECH Comedero Plegable de Viaje para Perros es la elección ideal para dueños de mascotas que aman llevar a sus fieles amigos en aventuras al aire libre. Ya sea en un emocionante viaje de camping, una caminata en la montaña o un paseo tranquilo por el parque, este comedero plegable verde para perros se convierte en un aliado esencial.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw8040852f/images/accesorios_perro_outech_bowl_doble_OUT88714_1.jpg?sw=780&sh=780&q=85', 4);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (10, 'MEDICALPET CONDROPROTECTOR EN COMPRIMIDOS PARA GATOS Y PERROS PEQUEÑOS Y MEDIANOS', 29.99, 'Suplemento para perros Medicalpet Condroprotector para el desgaste articular en razas pequeñas y medianas para perros y gatos de razas pequeñas y medianas, el suplemento para perros Medicalpet Condroprotector les ayuda a mejora su movilidad articular, regenerar la elasticidad de los cartílagos y reducir las molestias musculares.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw793f45d5/images/suplemento_perros_pequenos_medicalpet_condroprotector_articulaciones_MDC42612_M.jpg?sw=528&sh=528', 1);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (11, 'PLAY&BITE PELOTA ROJA DE PLÁSTICO CON SONIDO', 4.99, 'Esta pelota Squeaky de Play&Bite para perros tiene un sonido integrado que llama la atención de tu perro cuando suena, además protege las encías de tu mascota y limpia sus dientes evitando el sarro gracias al relieve.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw83a47ba8/images/play_bite_pelota_sonido_perros_PLB16482.jpg?sw=528&sh=528', 4);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (12, 'PLAY&BITE PELOTA ROJA DE PLÁSTICO CON SONIDO', 4.99, 'Esta pelota Squeaky de Play&Bite para perros tiene un sonido integrado que llama la atención de tu perro cuando suena, además protege las encías de tu mascota y limpia sus dientes evitando el sarro gracias al relieve.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw83a47ba8/images/play_bite_pelota_sonido_perros_PLB16482.jpg?sw=528&sh=528', 4);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (13, 'PLAY&BITE PELOTA ROJA DE PLÁSTICO CON SONIDO', 4.99, 'Esta pelota Squeaky de Play&Bite para perros tiene un sonido integrado que llama la atención de tu perro cuando suena, además protege las encías de tu mascota y limpia sus dientes evitando el sarro gracias al relieve.', 'https://www.kiwoko.com/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw83a47ba8/images/play_bite_pelota_sonido_perros_PLB16482.jpg?sw=528&sh=528', 4);
ALTER SEQUENCE producto_seq RESTART WITH 100;
