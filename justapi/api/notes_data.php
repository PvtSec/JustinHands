<?php
$sem_year=$_POST["Sem_Year_id"];

switch ($sem_year)
{
    case "first":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'Calculus'],
		['Id' => 2 , 'Course' => 'Engineering Chemistry'],
		['Id' => 3 , 'Course' => 'Engineering Mechanics'],
		['Id' => 4 , 'Course' => 'Basics of Electrical Engineering'],
		['Id' => 5 , 'Course' => 'Introduction to Electronics Engineering'],
		['Id' => 6 , 'Course' => 'Introduction to Sustainable Engineering'],
		['Id' => 7 , 'Course' => 'Differential Equations'],
		['Id' => 8 , 'Course' => 'Engineering Physics'],
		['Id' => 9 , 'Course' => 'Engineering Graphics'],
		['Id' => 10 , 'Course' => 'Basics of Civil Engineering'],
		['Id' => 11 , 'Course' => 'Design and Engineering'],
		['Id' => 12 , 'Course' => 'Basics of Mechanical Engineering']
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
	case "third":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'Linear Algebra and Complex Analysis'],
		['Id' => 2 , 'Course' => 'Network Theory'],
		['Id' => 3 , 'Course' => 'Solid State Devices'],
		['Id' => 4 , 'Course' => 'Electronic Circuits'],
		['Id' => 5 , 'Course' => 'Logic Circuit Design'],
		['Id' => 6 , 'Course' => 'Business Economics'],
		['Id' => 7 , 'Course' => 'Electronic Devices and Circuits Lab'],
		['Id' => 8 , 'Course' => 'Electronic Design Automation Lab']
		
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
	case "fourth":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'Probability, Random Processes and Numerical Methods'],
		['Id' => 2 , 'Course' => 'Signals and Systems'],
		['Id' => 3 , 'Course' => 'Analog Integrated Circuits'],
		['Id' => 4 , 'Course' => 'Computer Organization'],
		['Id' => 5 , 'Course' => 'Analog Communication Engineering'],
		['Id' => 6 , 'Course' => 'Life Skills'],
		['Id' => 7 , 'Course' => 'Analog Integrated Circuits Lab'],
		['Id' => 8 , 'Course' => 'Logic Circuit Design Lab']
		
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
	case "fifth":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'Digital Signal Processing'],
		['Id' => 2 , 'Course' => 'Applied Electromagnetic Theory'],
		['Id' => 3 , 'Course' => 'Microprocessors and Microcontrollers'],
		['Id' => 'EC307' , 'Course' => 'Power Electronics and Instrumentation'],
		['Id' => 5 , 'Course' => 'Principles of Management'],
		['Id' => 6 , 'Course' => 'Biomedical Engineering'],
		['Id' => 7 , 'Course' => 'Digital Signal Processing Lab'],
		['Id' => 8 , 'Course' => 'Power Electronics and Instrumentation Lab']
		
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
	case "sixth":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'Digital Communication'],
		['Id' => 2 , 'Course' => 'V.L.S.I'],
		['Id' => 3 , 'Course' => 'Antenna and Wave Propagation'],
		['Id' => 4 , 'Course' => 'Enbedded Systems'],
		['Id' => 5 , 'Course' => 'Object Oriented Programming'],
		['Id' => 6 , 'Course' => 'Robotics'],
		['Id' => 7 , 'Course' => 'Communication Engineering Lab'],
		['Id' => 8 , 'Course' => 'Microcontroller Lab'],
		['Id' => 9 , 'Course' => 'Comprehensive']
		
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
	case "seventh":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'uioijh'],
		['Id' => 2 , 'Course' => 'uioijh'],
		['Id' => 3 , 'Course' => 'uioijh'],
		['Id' => 4 , 'Course' => 'uioijh'],
		['Id' => 5 , 'Course' => 'uioijh'],
		['Id' => 6 , 'Course' => 'uioijh'],
		['Id' => 7 , 'Course' => 'uioijh'],
		['Id' => 8 , 'Course' => 'uioijh'],
		
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
	case "eighth":
        $data = ['data' => [
		['Id' => 1 , 'Course' => 'uioijh'],
		['Id' => 2 , 'Course' => 'uioijh'],
		['Id' => 3 , 'Course' => 'uioijh'],
		['Id' => 4 , 'Course' => 'uioijh'],
		['Id' => 5 , 'Course' => 'uioijh'],
		['Id' => 6 , 'Course' => 'uioijh'],
		['Id' => 7 , 'Course' => 'uioijh'],
		['Id' => 8 , 'Course' => 'uioijh'],
		
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
        break;
	
    default:
        $data = ['data' => [
		['Id' => 0 , 'Course' => 'Course not found. Will be updated soon']
							]];
		header('Content-Type: application/json');
		echo json_encode($data, JSON_PRETTY_PRINT);
}
?>