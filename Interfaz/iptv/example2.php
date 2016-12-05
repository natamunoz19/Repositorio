<?php
//$json = '{"a":1,"b":2,"c":3,"d":4,"e":5}';

//var_dump(json_decode($json));
//var_dump(json_decode($json, true));

$url = 'http://192.168.128.19:8983/solr/Recomendador/select?indent=on&q=id:terror_aftershock&wt=json';

$content = file_get_contents($url);
//$json = json_decode($content, true);
var_dump(json_decode($content, true));
?>
