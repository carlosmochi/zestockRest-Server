/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gedsonfaria
 * Created: 04/07/2017
 */

INSERT INTO tb_usuario (nome_usuario, registro_funcional, email, senha, theme) 
	VALUES ('Gedson Faria', NULL, 'gedson.faria@ufms.br', '123', NULL);
INSERT INTO tb_usuario (nome_usuario, registro_funcional, email, senha, theme) 
	VALUES ('Cizenando Galvao de Lima Junior', NULL, 'cizenando.junior@ufms.br', '123', NULL);
INSERT INTO tb_usuario (nome_usuario, registro_funcional, email, senha, theme) 
	VALUES ('Ze do Orgulho Ferido', NULL, 'zof@zemail.com', '123', NULL);
INSERT INTO tb_usuario (nome_usuario, registro_funcional, email, senha, theme) 
	VALUES ('Kleber Kruger', NULL, 'kleber.kruger@ufms.br', '123', NULL);


INSERT INTO tb_unidade (unidade) 
	VALUES ('UNIDADE');
INSERT INTO tb_unidade (unidade) 
	VALUES ('CAIXA');
INSERT INTO tb_unidade (unidade) 
	VALUES ('GARRAFA');
INSERT INTO tb_unidade (unidade) 
	VALUES ('FRASCO');
INSERT INTO tb_unidade (unidade) 
	VALUES ('PACOTE');
INSERT INTO tb_unidade (unidade) 
	VALUES ('FARDO');
INSERT INTO tb_unidade (unidade) 
	VALUES ('SACA');
INSERT INTO tb_unidade (unidade) 
	VALUES ('SACOLA');


INSERT INTO tb_fabricante (fabricante) 
	VALUES ('APPLE');
INSERT INTO tb_fabricante (fabricante) 
	VALUES ('SAMSUNG');
INSERT INTO tb_fabricante (fabricante) 
	VALUES ('LG');
INSERT INTO tb_fabricante (fabricante) 
	VALUES ('CONSUL');
INSERT INTO tb_fabricante (fabricante) 
	VALUES ('BRASTEMP');
INSERT INTO tb_fabricante (fabricante) 
	VALUES ('ZEISS');


INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'CANETA PARA QUADRO BRANCO', 'COR AZUL', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'CANETA PARA QUADRO BRANCO', 'COR VERMELHA', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'CANETA PARA QUADRO BRANCO', 'COR VERDE', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'CANETA PARA QUADRO BRANCO', 'COR PRETA', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'GUARDANAPOS DE PAPEL', '20X20CM', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'GUARDANAPOS DE PAPEL', '30X30CM', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'COPO DE VIDRO', 'TIPO AMERICANO 200ML', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'COPO DE VIDRO', 'TIPO TAÇA 300ML', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'COPO DE VIDRO', 'TIPO RETO/LISO 300ML', NULL);
INSERT INTO tb_produto_consumo (codigo_barra, descricao, especificacao, id_unidade) 
	VALUES (NULL, 'COPO DE VIDRO', 'TIPO REQUEIJÃO', NULL);


INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel)
	VALUES ('MICROSCOPIO ZEISS', '2017-07-04', NULL, NULL, 123, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('MICROSCOPIO ZEISS', '2017-07-04', NULL, NULL, 124, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('MICROSCOPIO ZEISS', '2017-07-04', NULL, NULL, 125, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('MICROSCOPIO ZEISS', '2017-07-04', NULL, NULL, 126, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('CADEIRA GIRATÓRIA/AZUL', '2017-07-04', NULL, NULL, 201, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('CADEIRA GIRATÓRIA/AZUL', '2017-07-04', NULL, NULL, 202, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('CADEIRA GIRATÓRIA/AZUL', '2017-07-04', NULL, NULL, 203, NULL, NULL);
INSERT INTO tb_bem_permanente (descricao_bem, dt_entrada, sala_alocacao, observacao, num_patrimonio, id_estado_conservacao, id_co_responsavel) 
	VALUES ('CADEIRA GIRATÓRIA/AZUL', '2017-07-04', NULL, NULL, 204, NULL, NULL);


INSERT INTO tb_consumo (id_produto, id_fabricante, dt_fabricacao, dt_validade, quantidade_em_estoque, id_quem_recebeu, dt_quando_recebeu) 
	VALUES (1, NULL, '2017-07-06', '2017-07-06', NULL, NULL, '2017-07-06');
INSERT INTO tb_consumo (id_produto, id_fabricante, dt_fabricacao, dt_validade, quantidade_em_estoque, id_quem_recebeu, dt_quando_recebeu) 
	VALUES (2, NULL, '2017-07-06', '2017-07-06', 10, 1, '2017-07-06');
