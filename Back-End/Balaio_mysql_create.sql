CREATE TABLE `Produto` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nomeProduto` varchar(255) NOT NULL,
	`descricaoProduto` longtext NOT NULL,
	`valor` double(8,2) NOT NULL,
	`dataFabricacao` DATE NOT NULL,
	`dataValidade` DATE,
	`quantidade` int NOT NULL,
	`categoria_id` bigint NOT NULL,
	`usuario_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Usuario` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`usuario` varchar(100) NOT NULL,
	`senha` varchar(255) NOT NULL,
	`cep` varchar(45) NOT NULL,
	`numeroEndereco` int NOT NULL,
	`complementoEndereco` varchar(45) NOT NULL,
	`telefone` varchar(16) NOT NULL,
	`cpf` varchar(18) NOT NULL,
	`descricaoUsuario` varchar(500),
	`isVendedor` BOOLEAN NOT NULL DEFAULT false,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Categoria` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`palavraChave` varchar(255) NOT NULL,
	`descricao` varchar(500) NOT NULL,
	`ativo` BOOLEAN NOT NULL DEFAULT true,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk0` FOREIGN KEY (`categoria_id`) REFERENCES `Categoria`(`id`);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario`(`id`);



