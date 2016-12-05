#! /bin/bash
# Operaciones con archivos
# Saber si es archivo, folder, vacio, ejecutable, de lectura...
 
echo "Dame el nombre de un archivo"
read entrada
grep "crid" $entrada > /home/diana/Documentos/scrips/t1.txt
grep "id" $entrada > /home/diana/Documentos/scrips/t2.txt
grep "ShortTitle" $entrada > /home/diana/Documentos/scrips/t3.txt
grep "Synopsis" $entrada > /home/diana/Documentos/scrips/t4.txt
grep "Duration" $entrada > /home/diana/Documentos/scrips/t5.txt
grep "Keyword" $entrada > /home/diana/Documentos/scrips/t6.txt
grep "Director" $entrada > /home/diana/Documentos/scrips/t7.txt
grep "Classification" $entrada > /home/diana/Documentos/scrips/t8.txt
grep "Cast" $entrada > /home/diana/Documentos/scrips/t9.txt
grep "Genre" $entrada > /home/diana/Documentos/scrips/t10.txt
grep "Language" $entrada > /home/diana/Documentos/scrips/t11.txt
grep "ProductionLocation" $entrada > /home/diana/Documentos/scrips/t12.txt
grep "FileFormat" $entrada > /home/diana/Documentos/scrips/t13.txt
grep "FileSize" $entrada > /home/diana/Documentos/scrips/t14.txt
grep "FileDuration" $entrada > /home/diana/Documentos/scrips/t15.txt

sh r.sh
