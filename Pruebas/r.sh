#! /bin/bash
clear
	 x=0 
	 p=0
         while [ "$x" != "15" ]; do
              x=$(( $x+1))
	      w="t$x.txt"
              echo $w
              en=$w
	      if [ ! -s $en ]; then
    	      	#echo "$en is empty"
		p=$(( $p+1))
	      	else
    	      	#echo "$en has content"
	      fi
        done
        x=0

	if [ "$p" != "0" ]; then
               echo "la etiqueta posee $p error en la estructura"
	       else
    	       echo "$la etiqueta no posee error en la estructura"
        fi

	 m=0 
         while [ "$m" != "15" ]; do
              m=$(( $m+1))
	      b="t$m.txt"
	      sudo rm -r /home/diana/Documentos/scrips/$b
              
         done
         m=0
