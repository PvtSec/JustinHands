<?php
$json = file_get_contents('php://input');
$data = json_decode($json);

$userId=$data->user_id;
$status=$data->status;
$final=['user' => $userId,'Life' => $status];
header('Content-Type: application/json');
echo json_encode($final, JSON_PRETTY_PRINT);
?>