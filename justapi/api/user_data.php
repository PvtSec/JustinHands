<?php
$json = file_get_contents('php://input');
$json_data = json_decode($json);
$unique_id=$json_data->userID;

$database = mysqli_connect('localhost', 'db_username', 'db_password', 'db_name');

$query = "SELECT * FROM Student_Creds WHERE Student_ID='$unique_id'";
$result = mysqli_fetch_array(mysqli_query($database,$query));
$Name = $result['Name'];
$Student_ID = $result['Student_ID'];
$Course =$result['Department'];

	$data =['Status' => 'Success' , 'Name' => $Name, 'Unique_ID' => $unique_id, 'Department' => $Course, 'Notification' => ' | Verison 1.0.245 | Updated the Updates Section with online data | Adding Cards to Notes Section for Categorized notes | Signup section require more security updates | App is in bleeding edge version | Bugs are numerous | '];
	header('Content-Type: application/json');
	echo json_encode($data, JSON_PRETTY_PRINT);

?>