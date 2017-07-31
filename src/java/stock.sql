drop schema public cascade;
create schema public;

CREATE TABLE public.tb_usuario (
                id_usuario SERIAL PRIMARY KEY,
                nome_usuario VARCHAR(255) NOT NULL,
                registro_funcional INTEGER,  --SIAPE
--valores de login (email e senha)
                email VARCHAR(255) NOT NULL,
                senha VARCHAR(40) NOT NULL,
--thema das janelas
                theme VARCHAR(40)
);

-- bens permanentes (com num. patrimonio) (bom,ruim,otimo,...)
CREATE TABLE public.tb_estado_bem_permanente (
    id_estado_bem_permanente VARCHAR(1) PRIMARY KEY,
    descricao_estado_fisico VARCHAR(64)
);
-- exemplo de locais: CPCX, LAPS, Lab. 01
-- exemplo: CPCX, Baixa ou CPCX, Extraviado
CREATE TABLE public.tb_locais_lotacao_bem_permanente(
    id_loca_lotacao SERIAL PRIMARY KEY,
    unidade_setorial VARCHAR(6),
    setor VARCHAR(64),
    sala VARCHAR(64)
);
CREATE TABLE public.tb_bem_permanente (
                id_bem_permanente SERIAL PRIMARY KEY,
                descricao_bem VARCHAR(255) NOT NULL,
                dt_entrada DATE,
                sala_alocacao INTEGER REFERENCES tb_locais_lotacao_bem_permanente,
                observacao VARCHAR(255),
                num_patrimonio INTEGER,
                id_estado_conservacao VARCHAR(1) REFERENCES tb_estado_bem_permanente,
                id_co_responsavel INTEGER REFERENCES tb_usuario
);
-- cria uma solicitacao de emprestimo
CREATE TABLE public.tb_emprestimo_bem_permanente (
                id_pedido_emprestimo SERIAL PRIMARY KEY,
                dt_prevista_retirada DATE,
                justificativa VARCHAR(255),
                dt_prevista_devolucao DATE,
                id_solicitante INTEGER REFERENCES tb_usuario,
                id_bem_permanente INTEGER REFERENCES tb_bem_permanente
                    ON DELETE CASCADE
                    ON UPDATE CASCADE
);
-- status: pedido, autorizado, retirado, devolvido, nao devolvido na data
-- lista de combobox
CREATE TABLE public.tb_status_emprestimo_bem_permanente (
    id_status VARCHAR(1) PRIMARY KEY,
    descricao VARCHAR(64)
);
CREATE TABLE public.tb_fases_emprestimo_bem_permanente (
    id_pedido_emprestimo INTEGER REFERENCES tb_emprestimo_bem_permanente,  
    dt_status DATE,
    id_status VARCHAR(1) REFERENCES tb_status_emprestimo_bem_permanente,
    id_responsavel INTEGER REFERENCES tb_usuario, -- quem realizou parte da etapa
    PRIMARY KEY(id_pedido_emprestimo,id_status) --
);

--bens de consumo
--unidades de medida
-- lista de combobox
CREATE TABLE public.tb_unidade (
                id_unidade SERIAL PRIMARY KEY,
                unidade VARCHAR(100) NOT NULL
);
--marcas de fabricantes
-- lista de combobox
CREATE TABLE public.tb_fabricante (
                id_fabricante SERIAL PRIMARY KEY,
                fabricante VARCHAR(100) NOT NULL
);
-- lista de combobox ou autocomplete
CREATE TABLE public.tb_produto_consumo(
                id_produto_consumo SERIAL PRIMARY KEY,
                codigo_barra VARCHAR(32),
                descricao VARCHAR(255) NOT NULL,
                especificacao VARCHAR(255),
                id_unidade INTEGER REFERENCES tb_unidade    
);
-- guarda quanto tem-se em estoque de cada produto (nao deve apagar e sim zerar qtd quando acabar)
CREATE TABLE public.tb_consumo (
                id_consumo SERIAL PRIMARY KEY,
                id_produto INTEGER REFERENCES tb_produto_consumo,
                id_fabricante INTEGER REFERENCES tb_fabricante,
                dt_fabricacao DATE,
                dt_validade DATE,
                quantidade_em_estoque INTEGER,
                id_quem_recebeu INTEGER REFERENCES tb_usuario,
                dt_quando_recebeu TIMESTAMP with time zone
);
-- armazena o historico de movimento, quanto de cada produto foi retirado ou devolvido ao estoque
CREATE TABLE public.tb_historico_consumo (
                id_material_retirado INTEGER REFERENCES tb_consumo
                    ON DELETE CASCADE
                    ON UPDATE CASCADE,
                quantidade_retirada INTEGER,
		motivo_retirada VARCHAR(255),
                id_quem_retirou INTEGER REFERENCES tb_usuario,
		dt_retirada DATE,
                PRIMARY KEY(id_material_retirado,dt_retirada)
);

-- 
-- CREATE TABLE public.tb_theme(
--     id_theme SERIAL PRIMARY KEY,
--     nome VARCHAR(64),
--     common_css VARCHAR(64),
--     especific_css VARCHAR(64)
-- );
