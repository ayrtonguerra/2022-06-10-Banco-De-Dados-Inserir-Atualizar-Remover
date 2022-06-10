CREATE DATABASE 202201_usjt_psc_sexta_pessoas;
SHOW DATABASES;
USE 202201_usjt_psc_sexta_pessoas;
# os comandos são case insensitives. Já os nomes das tabelas e bancos de dados são case sensitives por causa do sistema operacional (Linux). No Windows é case insensitive.
# padronização
# tabela -> tb
# trigger -> tg
# stored procedures -> sp
# nome da tabela no singular: cada tupla representa uma pessoa, e não várias pessoas.
CREATE TABLE tb_pessoa(
	-- surrogate key -> uma chave primária artificial (e não natural -> ex: CPF)
    cod_pessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200),
    fone VARCHAR(200),
    email VARCHAR(200)
);
-- CRUD: CREATE, READ, UPDATE, DELETE

-- C
INSERT INTO tb_pessoa
(nome, fone, email) 
VALUES
('José', '123456789', 'jose@email.com');

INSERT INTO tb_pessoa
(nome, fone, email) 
VALUES
('Maria', '987564321', 'maria@email.com'),
('Pedro', '547934849', 'pedro@email.com');

-- R
# Projeção: escolher as colunas
# SELECT * 
# SELECT cod_pessoa, nome, fone, email
SELECT * FROM tb_pessoa;
SELECT nome, fone FROM tb_pessoa;
SELECT * FROM tb_pessoa WHERE cod_pessoa = 1;

-- U
UPDATE tb_pessoa SET nome='José da Silva' WHERE cod_pessoa = 1;
UPDATE tb_pessoa SET nome='Maria Luiza', fone = '777444657' WHERE cod_pessoa = 2;

-- D
-- Pode ser tentador fazer DELETE * FROM, mas esse é função de um outro comando para alterar a estrutura de uma coluna e não do comando DELETE que exclui uma linha por completo
-- Com o safe mode habilitado, o Workbench não vai executar esse comando
DELETE FROM tb_pessoa;
DELETE FROM tb_pessoa WHERE cod_pessoa = 3;