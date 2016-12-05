<?php
	$jsondata = file_get_contents("products.json");

	$json = json_decode($jsondata, true);

	//echo $json['movies'][0]['title'];

	$output = "<ul>";

	foreach($json['movies'] as $movie) {
		$output .= "<h4>".$movie['title']."</h4>";
		$output .= "<li>".$movie['year']."</li>";
	}
	$output .= "</ul>";
	echo $output;
?>
