@echo off

 IF EXIST C:\\Users\\%username%\\Documents\\FERRAMENTA_TESTE (
	echo JA FOI CRIADO A ESTRUTURA DE DIRETORIO
 ) ELSE (
	mkdir C:\\Users\\%username%\\Documents\\FERRAMENTA_TESTE
	mkdir C:\\Users\\%username%\\Documents\\FERRAMENTA_TESTE\\logsCSV
	mkdir C:\\Users\\%username%\\Documents\\FERRAMENTA_TESTE\\prints
	mkdir C:\\Users\\%username%\\Documents\\FERRAMENTA_TESTE\\relatorio
 )



rem IF EXIST C:\\FERRAMENTA_TESTE (
rem 	echo JA FOI CRIADO A ESTRUTURA DE DIRETORIO
rem ) ELSE (
rem 	mkdir C:\\FERRAMENTA_TESTE
rem 	mkdir C:\\FERRAMENTA_TESTE\\logsCSV
rem 	mkdir C:\\FERRAMENTA_TESTE\\prints
rem 	mkdir C:\\FERRAMENTA_TESTE\\relatorio
rem )