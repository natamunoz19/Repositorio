<?php
	$json = file_get_contents("template.json");
	//var_dump(json_decode($json, true));

	$content = json_decode($json, true);


	echo "prueba de talento: <br>" .$content['response']['docs'][0]['Synopsis'][0];

	echo "<br></br>";

	echo "otra prueba de talento: <br>" .$content['response']['docs'][0]['Title'][0];

	echo "<br></br>";

	echo "otra prueba de talento: <br>" .$content['response']['docs'][0]['crid'][0];

	echo "<br></br>";

	echo "otra prueba de talento: <br>" .$content['response']['docs'][0]['Director'][0];

	echo "<br></br>";

	echo "otra prueba de talento: <br>" .$content['response']['docs'][0]['CopyrightNotice'][0];

	echo "<br></br>";

	$tmp = "Palabra Clave: ";
	echo "otra prueba de talento: <br>";
	foreach($content['response']['docs'][0]['Keyword'] as $valor) {
		$tmp .= $valor.", ";
	}
	echo "res : " .$tmp;

	echo "<br></br>";

	echo "otra prueba de talento: <br>" .$content['response']['docs'][0]['Classification'][0];

	echo "<br></br>";
	$tmp2 = "Reparto: ";
	echo "otra prueba de talento: <br>";
	foreach($content['response']['docs'][0]['Cast'] as $valor2) {
		$tmp2 .= $valor2.", ";
	}
	echo "res : " .$tmp2;
?>
