-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Fev-2020 às 20:59
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `foibrinks`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `nome_Cliente` varchar(256) DEFAULT NULL,
  `estado_Civil` varchar(256) DEFAULT NULL,
  `genero` varchar(256) DEFAULT NULL,
  `rua` varchar(256) DEFAULT NULL,
  `bairro` varchar(256) DEFAULT NULL,
  `cep` varchar(256) DEFAULT NULL,
  `estado` varchar(256) DEFAULT NULL,
  `cidade` varchar(256) DEFAULT NULL,
  `cpf` varchar(256) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  `codCliente` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `codproduto` smallint(6) NOT NULL,
  `nome_produto` varchar(256) DEFAULT NULL,
  `marcaProduto` varchar(256) DEFAULT NULL,
  `faixaEtaria` varchar(256) DEFAULT NULL,
  `alturaProduto` double DEFAULT NULL,
  `profundidadeProduto` double DEFAULT NULL,
  `pesoProduto` double DEFAULT NULL,
  `precoProduto` double DEFAULT NULL,
  `dataCadastro` date NOT NULL,
  `largura` double DEFAULT NULL,
  `precoDesconto` double DEFAULT NULL,
  `volume` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codCliente`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`codproduto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codCliente` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `codproduto` smallint(6) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
