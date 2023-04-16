#!/bin/bash
java -version
if [ $? -eq 0 ];
then
        echo 
        "java instalado"
else
        echo "java nao instalado"
        echo "instalando java"

                sudo apt install openjdk-17-jdk openjdk-17-jre -y
        git clone https://github.com/Grupo1-2ADSB/aplicacao-java/
fi
        cd aplicacao-java/smart-analytic-machine/target
        java -jar smart-analytic-machine-1.0-SNAPSHOT-jar-with-dependencies.jar
