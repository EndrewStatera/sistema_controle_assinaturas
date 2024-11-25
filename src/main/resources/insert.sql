INSERT INTO CLIENTES (username, email) VALUES ('Alice', 'alice@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Bob', 'bob@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Charlie', 'charlie@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Diana', 'diana@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Edward', 'edward@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Fiona', 'fiona@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('George', 'george@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Hannah', 'hannah@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Isaac', 'isaac@example.com');
INSERT INTO CLIENTES (username, email) VALUES ('Julia', 'julia@example.com');

INSERT INTO APPS (name, price) VALUES ('Spotify', 19.99);
INSERT INTO APPS (name, price) VALUES ('Netflix', 39.99);
INSERT INTO APPS (name, price) VALUES ('Amazon Prime', 25.99);
INSERT INTO APPS (name, price) VALUES ('Disney+', 29.99);
INSERT INTO APPS (name, price) VALUES ('HBO Max', 34.99);

INSERT INTO ASSINATURAS (app_cd_app, cliente_id_cliente, inicio_vigencia, fim_vigencia)
VALUES (1, 1, '2024-11-01', '2024-12-01');
INSERT INTO ASSINATURAS (app_cd_app, cliente_id_cliente, inicio_vigencia, fim_vigencia)
VALUES (2, 3, '2024-10-15', '2024-11-15');
INSERT INTO ASSINATURAS (app_cd_app, cliente_id_cliente, inicio_vigencia, fim_vigencia)
VALUES (3, 2, '2024-11-20', '2024-12-20');
INSERT INTO ASSINATURAS (app_cd_app, cliente_id_cliente, inicio_vigencia, fim_vigencia)
VALUES (4, 4, '2024-10-01', '2024-11-01');
INSERT INTO ASSINATURAS (app_cd_app, cliente_id_cliente, inicio_vigencia, fim_vigencia)
VALUES (5, 5, '2024-11-22', '2024-12-22');
