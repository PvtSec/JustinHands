<?php
$final=['data'=>[
['Q_Id' =>'1ECE','Q_text'=>'What is the Question?','Q_stat'=>0,'Q_Ans'=>'This is the answer'],
['Q_Id' =>'1ECE','Q_text'=>'What is the Question?','Q_stat'=>1,'Q_Ans'=>'This is the answer'],
['Q_Id' =>'1ECE','Q_text'=>'What is the Question?','Q_stat'=>1,'Q_Ans'=>'This is the answer'],
['Q_Id' =>'1ECE','Q_text'=>'What is the Question?','Q_stat'=>0,'Q_Ans'=>'This is the answer']
]];
header('Content-Type: application/json');
echo json_encode($final, JSON_PRETTY_PRINT);
?>

