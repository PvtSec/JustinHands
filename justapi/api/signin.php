<?php

session_start();
$database = mysqli_connect('localhost', 'id10796925_pvtsec', 'Jarvis@2019', 'id10796925_gecwapi');
$errors = [];

$json = file_get_contents('php://input');
$data = json_decode($json);
$userId=$data->user;
$passwd=$data->passwd;


if (isset($userId)) 
	{
		$StudentID= mysqli_real_escape_string($database, $userId);
		$Password = mysqli_real_escape_string($database, $passwd);

		if (empty($StudentID)) 
		{
			$errors['Status']="Student ID and Password is required";
		}
		if (empty($Password)) 
		{
			$errors['Status']="Student ID and Password is required";
		}
		if(count($errors)!=0)
		{
			header('Content-Type: application/json');
			echo json_encode($errors, JSON_PRETTY_PRINT);
		}

		if (count($errors) == 0) 
		{
			if ($StudentID == trim($StudentID) && strpos($StudentID, ' ') !== false) 
			{
				print('StudentID should not contain spaces');
				exit;
			}
			$Password = md5($Password);
			$query = "SELECT * FROM Student_Creds WHERE Student_ID='$StudentID' AND Password='$Password'";
			$results = mysqli_query($database, $query);

			if (mysqli_num_rows($results) == 1) 
			{
				$_SESSION['username'] = $StudentID;
				$_SESSION['success'] = "You are now logged in";
				$final=['Status' => 'Success'];
				header('Content-Type: application/json');
				echo json_encode($final, JSON_PRETTY_PRINT);
			}
			else 
			{
			    $final=['Status' => 'Username or Password is Incorrect'];
				header('Content-Type: application/json');
				echo json_encode($final, JSON_PRETTY_PRINT);
			}
		}
	}

?>