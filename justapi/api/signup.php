<?php

$database = mysqli_connect('localhost', 'id10796925_pvtsec', 'Jarvis@2019', 'id10796925_gecwapi');
if (isset($_POST['Name']))
{
$Name= mysqli_real_escape_string($database, $_POST['Name']);
$StudentID= mysqli_real_escape_string($database, $_POST['StudentId']);
$Passwd= mysqli_real_escape_string($database, $_POST['Password']);
$Course= mysqli_real_escape_string($database, $_POST['Course']);

if((strlen($Name)<5)||(strlen($StudentID)<5)||(strlen($Passwd)<5))
{
	print('Please Enter Valid Details');
	print(strlen($Name));
	print(strlen($StudentID));
	exit;
}
if ($StudentID == trim($StudentID) && strpos($StudentID, ' ') !== false) 
			{
				print('StudentID should not contain spaces');
				exit;
			}

$password = md5($Passwd);
$query = "INSERT INTO Student_Creds (Name, Student_ID, Department, Password) 
VALUES('$Name', '$StudentID','$Course', '$password')";
if(mysqli_query($database, $query))
{
	echo('Signup Success');
}
}
?>