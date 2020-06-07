# !/bin/bash
export usuario=`eval whoami`
#or export usuario=$(whoami)

if [ ! -d "$/home/$usuario/FERRAMENTA_TESTE/" ] 
then
  # Control will enter here if $DIRECTORY exists.
  mkdir /home/$usuario/FERRAMENTA_TESTE/
	chmod 777 -Rf /home/$usuario/FERRAMENTA_TESTE/
	cd /home/$usuario/FERRAMENTA_TESTE/
	mkdir -m 777 logsCSV
	mkdir -m 777 prints
	mkdir -m 777 relatorio
	echo "FOI CRIADO OS DIRETORIOS"
  
else
	echo "EXISTE"
fi