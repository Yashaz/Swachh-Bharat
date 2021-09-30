<?php

 
$host = "localhost";
//"mysql.hostinger.co.uk";
	$user = "root";
  //"u372846896_root";
	$password ="";
  // "swatch";
	$database = "project";
  //"u372846896_proj";
$con = new mysqli($host, $user, $password, $database);
 
$password=$_GET["password"];
  $username=$_GET["username"];
   
  if (!empty($_GET)) {
  if (empty($_GET['username']) || empty($_GET['password'])) {
  // Create some data that will be the JSON response 
          $response["success"] = 0;
          $response["message"] = "One or both of the fields are empty .";
          
          //die is used to kill the page, will not let the code below to be executed. It will also
          //display the parameter, that is the json data which our android application will parse to be //shown to the users
          die(json_encode($response));
      }
      $query = " SELECT * FROM department WHERE username = '$username' and password = '$password'";
    // echo $query; 
     $sql1= $con->query($query);
     //var_dump($sql1);
     if ($sql1->num_rows > 0)
     {
      $row = $sql1->fetch_assoc();

  // $row = mysqli_fetch_array($sql1);
      if (!empty($row)) {
         $response["success"] = 1;
            $response["message"] = "You have been sucessfully login";
           die(json_encode($response));
          }
  else{
   
          $response["success"] = 0;
          $response["message"] = "invalid username or password ";
          die(json_encode($response));
      }
  } 
   
  else{
   
         $response["success"] = 0;
          $response["message"] = " One or both of the fields are empty ";
  die(json_encode($response));
    }
  }
   
  $con->close();
  ?>




