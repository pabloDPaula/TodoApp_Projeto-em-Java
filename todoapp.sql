-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Abr-2022 às 22:39
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `todoapp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `projetos`
--

CREATE TABLE `projetos` (
  `Id` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `DataCriacao` datetime NOT NULL,
  `DataAtualizacao` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `projetos`
--

INSERT INTO `projetos` (`Id`, `Nome`, `Descricao`, `DataCriacao`, `DataAtualizacao`) VALUES
(3, 'Projeto', 'Descrição', '2022-04-23 00:00:00', '2022-04-23 00:00:00'),
(6, 'Projeto 2', 'Descrição do projeto 2', '2022-04-25 00:00:00', '2022-04-25 00:00:00'),
(7, 'projeto 3 ', 'descrição 3', '2022-04-25 00:00:00', '2022-04-25 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefa`
--

CREATE TABLE `tarefa` (
  `Id` int(11) NOT NULL,
  `IdProjeto` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Descricao` varchar(255) DEFAULT NULL,
  `Completado` tinyint(1) NOT NULL,
  `Observacao` varchar(255) DEFAULT NULL,
  `Prazo` date NOT NULL,
  `DataCriacao` datetime NOT NULL,
  `DataAtualizacao` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tarefa`
--

INSERT INTO `tarefa` (`Id`, `IdProjeto`, `Nome`, `Descricao`, `Completado`, `Observacao`, `Prazo`, `DataCriacao`, `DataAtualizacao`) VALUES
(6, 3, 'Tarefa 3', 'descricao da tarefa 3	', 0, 'Notas da tarefa 3', '2020-12-12', '2022-04-25 00:00:00', '2022-04-25 00:00:00'),
(7, 3, 'tarefa Teste', 'descricao teste	', 0, 'notas teste', '2022-05-05', '2022-04-25 00:00:00', '2022-04-25 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `projetos`
--
ALTER TABLE `projetos`
  ADD PRIMARY KEY (`Id`);

--
-- Índices para tabela `tarefa`
--
ALTER TABLE `tarefa`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Fk_projeto` (`IdProjeto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `projetos`
--
ALTER TABLE `projetos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tarefa`
--
ALTER TABLE `tarefa`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tarefa`
--
ALTER TABLE `tarefa`
  ADD CONSTRAINT `Fk_projeto` FOREIGN KEY (`IdProjeto`) REFERENCES `projetos` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
