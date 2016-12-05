<?php
	$json = file_get_contents("multi-leveljson.json");
	//var_dump(json_decode($json, true));

	$content = json_decode($json, true);


	echo "prueba de talento: <br>" .$content['field3'][1]['field31'] .$content['field3'][1]['field32'];

	echo $content->field2;

	//$tmp = 0;
	//foreach($content as $products) {
		//echo "<br>otra prueba<br>" .$products;
		//$tmp++;
	//    echo "varias lineas: $tmp $products->products_and_categories <br>";
	//}
?>
