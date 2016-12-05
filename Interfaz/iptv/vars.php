<?php
	$json = file_get_contents("template.json");

	$content = json_decode($json, true);

	$synopsis="<b><u>Sinopsis:</u></b> ".$content['response']['docs'][0]['Synopsis'][0];
	$title = $content['response']['docs'][0]['Title'][0];
	$crid = "Crid : " .$content['response']['docs'][0]['crid'][0];
	$director = "<b><u>Director:</u></b> ".$content['response']['docs'][0]['Director'][0];
	$productora = "<b><u>Productora:</u></b> ".$content['response']['docs'][0]['CopyrightNotice'][0];

	$keyword = "<b><u>Palabras Clave:</u></b> ";
	foreach($content['response']['docs'][0]['Keyword'] as $valor) {
		$keyword .= $valor.", ";
	}
	$clasificacion = "<b><u>Clasificación:</u></b> ".$content['response']['docs'][0]['Classification'][0];
	$reparto = "<b><u>Reparto:</u></b> ";
	foreach($content['response']['docs'][0]['Cast'] as $valor2) {
		$reparto .= $valor2.", ";
	}
?>