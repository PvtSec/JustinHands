<?php
$data = ['data' => [
['Id' => 1 ,
'Title' => 'New Version',
'Description' => 'This new Version consists of added Updates.'],
['Id' => 2 ,
'Title' => 'What new',
'Description' => 'App consists of updates page which provides details on updates within the institute'],
['Id' => 3 ,
'Title' => 'What Used',
'Description' => 'The new feature uses Volley to interact with the server'],
['Id' => 4 ,
'Title' => 'How used',
'Description' => 'The Volley send the required http requests and retrieves the content'],
['Id' => 5 ,
'Title' => 'How it works',
'Description' => 'A recycler view with cards is used for the updates page so that each data can be used in the same card multiple times'],
['Id' => 6 , 'Title' => 'Data Handling',
'Description' => 'The data fetched by volley is in the JSON format.'],
['Id' => 7 , 'Title' => 'JSON Parsing',
'Description' => 'The JSON is parsed within the volley by using normal JSON parsing in JAVA'],
['Id' => 8 , 'Title' => 'Feeding Data',
'Description' => 'The Data to each card is feeded by using a simple for loop'],
['Id' => 9 ,
'Title' => 'The FOR Loop',
'Description' => 'The for loop iterates over the json array and get the required data for each card']
]];
header('Content-Type: application/json');
echo json_encode($data, JSON_PRETTY_PRINT);
?>