INSERT INTO tipo_animal(id, tipo) VALUES (1,'Perro');
INSERT INTO tipo_animal(id,tipo) VALUES (2,'Gato');
ALTER SEQUENCE tipo_animal_seq RESTART WITH 3;

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

INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (1, 'hjdshjd', 20.3542, 'dhsajdgsadhgsa', 'https://www.tiendanimal.es/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw150dbef4/images/accesorios_perro_play_and_bite_hula_hoop_m_PLB88274.jpg?sw=780&sh=780&q=85', 2);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (2, 'hjds', 2103.52, 'dhsajdgsadhgsadsadlñjsakjdhskajhgdksaghdgsahjdghsagdhsagdjhsgajhdgshdgsdgjhsdgjhsgdhjsg', 'https://www.tiendanimal.es/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw05b5cabb/images/TKPet_Isidoro_rascador_para_gatos_poste_de_yute_TKP40977.jpg?sw=528&sh=528', 3);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (3, 'hjds', 2103.52, 'dhsajdgsadhgsadsadlñjsakjdhskajhgdksaghdgsahjdghsagdhsagdjhsgajhdgshdgsdgjhsdgjhsgdhjsg', 'https://www.tiendanimal.es/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw481c63ec/images/comida_gatos_royal_canin_regular_sterilised_52722_M_1.jpg?sw=528&sh=528', 4);
INSERT INTO producto (id, nombre, precio, descripcion, foto, cat_producto_id) VALUES (4, 'hjds', 2103.52, 'dhsajdgsadhgsadsadlñjsakjdhskajhgdksaghdgsahjdghsagdh', 'https://www.tiendanimal.es/dw/image/v2/BDLQ_PRD/on/demandware.static/-/Sites-kiwoko-master-catalog/default/dw21460e3a/images/Frontpro_Comprimidos_Masticables_Antiparasitario_para_perros_BOE154746_M_1%20(1).jpg?sw=528&sh=528', 1);
ALTER SEQUENCE producto_seq RESTART WITH 100;