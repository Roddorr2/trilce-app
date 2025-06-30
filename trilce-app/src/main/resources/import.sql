INSERT INTO Grado (nombre) VALUES ('1er grado de primaria');
INSERT INTO Grado (nombre) VALUES ('2do grado de primaria');
INSERT INTO Grado (nombre) VALUES ('3er grado de primaria');
INSERT INTO Grado (nombre) VALUES ('4to grado de primaria');
INSERT INTO Grado (nombre) VALUES ('5to grado de primaria');
INSERT INTO Grado (nombre) VALUES ('6to grado de primaria');
INSERT INTO Grado (nombre) VALUES ('1er grado de secundaria');
INSERT INTO Grado (nombre) VALUES ('2do grado de secundaria');
INSERT INTO Grado (nombre) VALUES ('3er grado de secundaria');
INSERT INTO Grado (nombre) VALUES ('4to grado de secundaria');
INSERT INTO Grado (nombre) VALUES ('5to grado de secundaria');
INSERT INTO Grado (nombre) VALUES ('Preuniversitario');

INSERT INTO Seccion (nombre) VALUES ('A');
INSERT INTO Seccion (nombre) VALUES ('B');
INSERT INTO Seccion (nombre) VALUES ('C');
INSERT INTO Seccion (nombre) VALUES ('D');
INSERT INTO Seccion (nombre) VALUES ('E');

INSERT INTO tipo_usuario (nombre) VALUES ('Docente');
INSERT INTO tipo_usuario (nombre) VALUES ('Alumno');

INSERT INTO Usuario (nombres, correo, dni, id_grado, id_seccion, id_tipo_usuario) VALUES ('Rodrigo Cuya Brückmann', 'rodrigo.cuya@trilce.edu.pe', '12345678', 12, 1, 2);
INSERT INTO Usuario (nombres, correo, dni, id_grado, id_seccion, id_tipo_usuario) VALUES ('Paulo Adrian Armey Malca', 'paulo.adrian@trilce.edu.pe', '23456789', 11, 2, 2);
INSERT INTO Usuario (nombres, correo, dni, id_grado, id_seccion, id_tipo_usuario) VALUES ('Gianloui Roy Vito Huamaní', 'gianloui.roy@trilce.edu.pe', '34567890', 10, 3, 2);
INSERT INTO Usuario (nombres, correo, dni, id_grado, id_seccion, id_tipo_usuario) VALUES ('Miguel Alexander Quiroz Vila', 'miguel.alex@trilce.edu.pe', '45678901', 9, 4, 2);
INSERT INTO Usuario (nombres, correo, dni, id_grado, id_seccion, id_tipo_usuario) VALUES ('Henry Johan Sneider Enciso Canales', 'henry.sneider@trilce.edu.pe', '56789012', 8, 5, 2);

INSERT INTO Categoria (nombre) VALUES ('Matemática');
INSERT INTO Categoria (nombre) VALUES ('Comunicación');
INSERT INTO Categoria (nombre) VALUES ('Ciencias');
INSERT INTO Categoria (nombre) VALUES ('Historia');
INSERT INTO Categoria (nombre) VALUES ('Arte');

INSERT INTO sesion_laboratorio (fecha_hora) VALUES (CURRENT_TIMESTAMP);
INSERT INTO sesion_laboratorio (fecha_hora) VALUES (CURRENT_TIMESTAMP);
INSERT INTO sesion_laboratorio (fecha_hora) VALUES (CURRENT_TIMESTAMP);
INSERT INTO sesion_laboratorio (fecha_hora) VALUES (CURRENT_TIMESTAMP);
INSERT INTO sesion_laboratorio (fecha_hora) VALUES (CURRENT_TIMESTAMP);

INSERT INTO sesion_participante (id_sesion, id_usuario) VALUES (1, 1);
INSERT INTO sesion_participante (id_sesion, id_usuario) VALUES (1, 2);
INSERT INTO sesion_participante (id_sesion, id_usuario) VALUES (2, 3);
INSERT INTO sesion_participante (id_sesion, id_usuario) VALUES (3, 4);
INSERT INTO sesion_participante (id_sesion, id_usuario) VALUES (4, 5);

INSERT INTO Actividad (actividad, entrada_usuario, respuesta, id_categoria, id_sesion) VALUES ('Resolución', 'Entrada 1', 'Respuesta 1', 1, 1);
INSERT INTO Actividad (actividad, entrada_usuario, respuesta, id_categoria, id_sesion) VALUES ('Análisis', 'Entrada 2', 'Respuesta 2', 2, 2);
INSERT INTO Actividad (actividad, entrada_usuario, respuesta, id_categoria, id_sesion) VALUES ('Lectura', 'Entrada 3', 'Respuesta 3', 3, 3);
INSERT INTO Actividad (actividad, entrada_usuario, respuesta, id_categoria, id_sesion) VALUES ('Comprensión', 'Entrada 4', 'Respuesta 4', 4, 4);
INSERT INTO Actividad (actividad, entrada_usuario, respuesta, id_categoria, id_sesion) VALUES ('Síntesis', 'Entrada 5', 'Respuesta 5', 5, 5);

INSERT INTO Documento (nombre_archivo, texto_extraido, id_actividad) VALUES ('archivo1.pdf', 'Texto extraído 1', 1);
INSERT INTO Documento (nombre_archivo, texto_extraido, id_actividad) VALUES ('archivo2.pdf', 'Texto extraído 2', 2);
INSERT INTO Documento (nombre_archivo, texto_extraido, id_actividad) VALUES ('archivo3.pdf', 'Texto extraído 3', 3);
INSERT INTO Documento (nombre_archivo, texto_extraido, id_actividad) VALUES ('archivo4.pdf', 'Texto extraído 4', 4);
INSERT INTO Documento (nombre_archivo, texto_extraido, id_actividad) VALUES ('archivo5.pdf', 'Texto extraído 5', 5);


INSERT INTO Ejercicio (pregunta, respuesta_correcta, tipo_pregunta, id_actividad) VALUES ('¿Cuánto es 2 + 2?', '4', 'Objetiva', 1);
INSERT INTO Ejercicio (pregunta, respuesta_correcta, tipo_pregunta, id_actividad) VALUES ('¿Cuál es el sujeto en "El perro ladra"?', 'El perro', 'Objetiva', 2);
INSERT INTO Ejercicio (pregunta, respuesta_correcta, tipo_pregunta, id_actividad) VALUES ('Define fotosíntesis.', 'Proceso por el cual...', 'Subjetiva', 3);
INSERT INTO Ejercicio (pregunta, respuesta_correcta, tipo_pregunta, id_actividad) VALUES ('¿Qué pasó en 1821?', 'Independencia del Perú', 'Objetiva', 4);
INSERT INTO Ejercicio (pregunta, respuesta_correcta, tipo_pregunta, id_actividad) VALUES ('¿Qué representa el Guernica?', 'La guerra', 'Subjetiva', 5);

INSERT INTO evaluacion_auto (puntaje, comentario, id_actividad) VALUES (85, 'Buen trabajo', 1);
INSERT INTO evaluacion_auto (puntaje, comentario, id_actividad) VALUES (60, 'Puede mejorar', 2);
INSERT INTO evaluacion_auto (puntaje, comentario, id_actividad) VALUES (95, 'Excelente', 3);
INSERT INTO evaluacion_auto (puntaje, comentario, id_actividad) VALUES (70, 'Faltó detalle', 4);
INSERT INTO evaluacion_auto (puntaje, comentario, id_actividad) VALUES (88, 'Bien estructurado', 5);
