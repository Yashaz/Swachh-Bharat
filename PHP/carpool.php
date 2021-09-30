<?php
$servername = "localhost";
    $username = "manvi";
    $password = "manvi";
    $dbname = "swachhbharat";

    // Create connection
    $conn = mysqli_connect($servername, $username, $password, $dbname);
    


    echo "hello";
   // ??? if(isset($_GET['login'])) ???

    { 
    $name = $_GET["name"];
    $contact = $_GET["contact"];
     $start = $_GET["start"];
      $dest = $_GET["dest"];

   $sql = "insert into carpool (name,contact,start,destination) values('$name','$contact','$start','$dest')" ;

		if (mysqli_query($conn, $sql)) 
		{
			echo '<i><h2 id="login-p">Signup Successful!</h2></i>' ;
            echo '<br/>';
		} 
		else 
		{
			echo "Error: " . $sql . "<br>" . mysqli_error($conn);
		}
   

mysqli_close($conn);
    ?>
